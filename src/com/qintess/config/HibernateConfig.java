package com.qintess.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.Test.Test;
import com.qintess.model.EntidadeBase;
import com.qintess.model.GenericDao;
import com.qintess.model.ItemVenda;
import com.qintess.model.Produto;
import com.qintess.model.Venda;

public class HibernateConfig {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties prop = new Properties();
				
				prop.put(Environment.DRIVER, "org.h2.Driver");
				prop.put(Environment.URL, "jdbc:h2:~/desafio_hibernate");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(prop);
				
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(ItemVenda.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(configuration.getProperties())
													.build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
			return sessionFactory;
	}
}
