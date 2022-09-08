package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.InstructorDetail;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoOneToOneInstructorAction {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			Instructor ins1 = new Instructor();
			ins1.setName("jerry");
			
			InstructorDetail detail = new InstructorDetail();
			detail.setEmail("jerry@gmail.com");
			detail.setPhone("556677");
			
			ins1.setInstructorDetail(detail);
			
			session.save(ins1);

			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("ROLLBACK!!!");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
