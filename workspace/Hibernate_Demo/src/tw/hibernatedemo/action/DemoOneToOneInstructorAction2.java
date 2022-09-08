package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			// 已知 Instructor Jerry 的 id 為 1 ，請查出他的 email
			Instructor data = session.get(Instructor.class, 1);

			System.out.println("email: " + data.getInstructorDetail().getEmail());

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ROLLBACK!!!");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}