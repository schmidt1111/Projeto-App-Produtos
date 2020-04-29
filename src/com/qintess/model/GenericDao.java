package com.qintess.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.qintess.config.HibernateConfig;

//<coloca nome generic para domain(entidade)
public class GenericDao <T extends EntidadeBase> {
	
	//(salvar objeto na entidade)
	public void salvar (T Objeto) {
		
		//capturar uma sessao aberta
		Session session = HibernateConfig.getSessionFactory().openSession();

		//declarar um objeto do tipo Transaçãp(Org.hibernate)
		Transaction transaction = null;
		
		//tentar
		try {
			//abrir transaçao
			transaction = session.beginTransaction();
			System.out.println(Objeto);
			//faça alguma coisa, no caso salvar
			session.save(Objeto);
			//confirmar a transacao
			transaction.commit();
			
		}catch (Exception e) { //desfazer
			
			//se a transacao for diferente de nula
			if(transaction != null) {
				
				//ele desfaz a transacao
				transaction.rollback();
				
			} //printar o erro
			e.printStackTrace();
			
		} finally { //ele sempre executa
			
			//finalizar sessao
			session.close();
		}
	}
	
	public T buscaPorId (Class<T> clazz, Long id) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = null;
		
		return session.find(clazz, id);
	}
	
	public void deletar (Class <T> clazz, Long id) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.remove (id);
			transaction.commit();
			
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
	}

	public void buscaPorId(Venda venda1, int i) {
		// TODO Auto-generated method stub
		
	}
	
}
