package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorAction6 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			// Jerry (Instructor 1) 又想加 Detail 回去
			Instructor ins1 = session.get(Instructor.class, 1);
			
			InstructorDetail detail = new InstructorDetail();
			detail.setEmail("jerry@yahoo.com");
			detail.setPhone("56321");

			session.save(detail);

			ins1.setInstructorDetail(detail);

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