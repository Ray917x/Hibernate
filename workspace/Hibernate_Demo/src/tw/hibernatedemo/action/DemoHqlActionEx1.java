package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.model.Employee;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoHqlActionEx1 {

	public void queryAllEmployee() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

//			String hql = "from Employee";
			String hql = "from Employee where salary >= 30000 and vacation >= 10";

			Query<Employee> query = session.createQuery(hql, Employee.class);

			List<Employee> list = query.getResultList();

			for (Employee oneEmp : list) {
				System.out.println(oneEmp);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	public void queryEmployeeByVacationAndSalary(Integer vacation, Integer salary) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

//			String hql = "from Employee";
			String hql = "from Employee where salary >= :salary and vacation >= :vacation";

			Query<Employee> query = session.createQuery(hql, Employee.class).setParameter("salary", salary)
					.setParameter("vacation", vacation);

			List<Employee> list = query.getResultList();

			for (Employee oneEmp : list) {
				System.out.println(oneEmp);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	// 根據名子(Name)找人
	public void queryEmployeeByName(String name) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			String hql = "from Employee where empName = :name";

			Query<Employee> query = session.createQuery(hql, Employee.class)
					.setParameter("name", name);

			List<Employee> list = query.getResultList();

			for (Employee oneEmp : list) {
				System.out.println(oneEmp);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}
	
	public void updateSalaryByName(String name, Integer salary) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			String hql = "update Employee set salary = :salary where empName = :name";

			session.createQuery(hql)
					.setParameter("name", name)
					.setParameter("salary", salary)
					.executeUpdate();

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}

	}

	public static void main(String[] args) {
		DemoHqlActionEx1 hqlTest = new DemoHqlActionEx1();
//		hqlTest.queryAllEmployee();
//		hqlTest.queryEmployeeByVacationAndSalary(10, 30000);
//		hqlTest.queryEmployeeByName("Betty");
		hqlTest.updateSalaryByName("John", 25000);
		
	

	}

}