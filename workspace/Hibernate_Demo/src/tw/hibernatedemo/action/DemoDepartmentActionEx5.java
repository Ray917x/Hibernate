package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx5 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
//			Department dept2 = session.get(Department.class, 2);
			
			Department dept2 = session.load(Department.class, 2);
			
//			dept2.setDeptname("RDD"); //修改
			
			session.delete(dept2); //刪除
			
			System.out.println("Name: " + dept2.getDeptname());
			
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
