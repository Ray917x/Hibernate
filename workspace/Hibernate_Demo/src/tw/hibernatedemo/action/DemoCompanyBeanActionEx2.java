package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;

public class DemoCompanyBeanActionEx2 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		CompanyBean cpyBean = new CompanyBean(1002, "Meta");
		
		Serializable identifier = session.save(cpyBean);
		
		System.out.print(" identifier :" + identifier);

		session.save(cpyBean);

		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
