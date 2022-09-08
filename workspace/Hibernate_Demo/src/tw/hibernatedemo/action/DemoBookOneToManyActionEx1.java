
package tw.hibernatedemo.action;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.BookUsers;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoBookOneToManyActionEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		// Tom 要借兩本書
		try {
			session.beginTransaction();
			
			Books book1 = new Books();
			book1.setBooktitle("jQuery");
			book1.setPublicYear("2018");
			
			Books book2 = new Books();
			book2.setBooktitle("Spy Family");
			book2.setPublicYear("2022-1");
			
			BookUsers user1 = new BookUsers();
			user1.setUsername("Tom");
			
			// book 關聯使用者
			book1.setBookUsers(user1);
			book2.setBookUsers(user1);
			
			// 使用者 關聯 book
			Set<Books> tempSet = new LinkedHashSet<Books>();
			tempSet.add(book1);
			tempSet.add(book2);
			
			user1.setBooks(tempSet);
			
			session.save(user1);
			
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}