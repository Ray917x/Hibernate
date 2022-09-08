package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Department dept2 = new Department("餐具2");
		
		
		session.beginTransaction();
		
		Serializable id = session.save(dept2);
		System.out.println("id: "+ id);
		
		session.getTransaction().commit();
		
		factory.close();

	}

}
