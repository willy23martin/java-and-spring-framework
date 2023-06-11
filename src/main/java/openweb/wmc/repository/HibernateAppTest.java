package openweb.wmc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import openweb.wmc.model.entities.Contacts;

public class HibernateAppTest {

	public static void main(String[] args) {
		
		// 1) Initialization:
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// 2) New Session
		Session session = sessionFactory.openSession();
		// 3) Create instances:
		Contacts contactA = new Contacts();
		contactA.setId("01");
		contactA.setName("Test name");
		contactA.setEmail("springdev@domain.subdomain");
		contactA.setTelephone("3333333");
		Contacts contactB = new Contacts();
		contactB.setId("02");
		contactB.setName("Test name II");
		contactB.setEmail("springdev2@domain.subdomain");
		contactB.setTelephone("3333332");
		// 4) Start transaction:
		session.getTransaction().begin();
		// 5) Store data:
		session.save(contactA);
		session.save(contactB);
		// 6) Commit data:
		session.getTransaction().commit();
		// 7) Close sessions:		
		session.close();
		sessionFactory.close();

	}

}
