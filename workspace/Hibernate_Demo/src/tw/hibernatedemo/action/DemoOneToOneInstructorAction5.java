package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorAction5 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			// Jerry (Instructor 1) 又想改電話
			Instructor ins1 = session.get(Instructor.class, 1);
			
			InstructorDetail detail = ins1.getInstructorDetail();
			
			detail.setPhone("010203");


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