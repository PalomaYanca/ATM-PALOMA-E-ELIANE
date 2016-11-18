package br.umc.iod.rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * rmic -classpath `pwd` br.umc.iod.ChatMessengerImpl
*/


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.umc.iod.jpa.MinhaEntidade;


/**
 *
 * @author marcio
 */
public class JPAMessengerImpl implements JPAMessenger{
    Map<Long, Message> messages = new HashMap<>();
    String nome;
	EntityManagerFactory emf;
	EntityManager em;
	

    public JPAMessengerImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 1099);
	}

	public void abreConexao (){
		emf = Persistence.createEntityManagerFactory("minha-persistence-unit");
		em = emf.createEntityManager();
	}
	
    public void fechaConexao (){
    	emf.close();
    	em.close();
    }
    
	public void salva(Object objeto) throws RemoteException {
		em.getTransaction().begin();
	  	em.persist(objeto);
	  	em.getTransaction().commit();
		
	}


	public void remove(Object objeto) throws RemoteException {
		em.getTransaction().begin();
		em.remove(objeto);
	  	em.getTransaction().commit();
		
	}


	public void atualiza(Object objeto) throws RemoteException {
		if(em==null || emf==null || !em.isOpen() || !emf.isOpen()){
			abreConexao();		
		em.getTransaction().begin();
		em.merge(objeto); 
	  	em.getTransaction().commit();
		
		}else {
			em.getTransaction().begin();
			em.merge(objeto); 
		  	em.getTransaction().commit();
			
		}
	}


	public void consulta(String campo) throws RemoteException {
		if(em==null || emf==null || !em.isOpen() || !emf.isOpen()){
			abreConexao();
			em.getTransaction().begin();
		List<MinhaEntidade> lista = em.createQuery("FROM MinhaEntidade", MinhaEntidade.class).getResultList();
		  for (MinhaEntidade selected : lista){
			  System.out.println("Objeto no banco: " + selected.getNumero());
		  }
			em.getTransaction().commit();
			fechaConexao();
		
	}   
  } 
}
    
    

