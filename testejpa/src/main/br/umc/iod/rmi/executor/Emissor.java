/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.umc.iod.rmi.executor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.umc.dao.PersonDAO;
import br.umc.entity.Person;

/**
 *
 * @author marciomendes
 */
public class Emissor  {//1 passo
// JPAMessenger chat;
// Object objeto;
// 
// 
//    public Emissor() throws NotBoundException, MalformedURLException, RemoteException {
//        chat= (JPAMessenger)Naming.lookup("rmi://08LABS01:1023/person");//2 passo
//    }
//
//   public void salvar(Object o){
//	    try {
//			chat.atualiza(o);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//   }
//   public void remover (Object o){
//	    try {
//			chat.remove(o);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//  }
//   public void atualizar (Object o){
//	    try {
//			chat.atualiza(o);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// }
//   
//
//    public static void main(String[] args) {
//		Emissor emissor;
//		try {
//			
//			emissor = new Emissor();
//			MinhaEntidade entidade = new MinhaEntidade();
//			entidade.setTexto("OK");
//			emissor.salvar(entidade);
//			emissor.remover(entidade);
//			emissor.atualizar(entidade);
//			
//		} catch (MalformedURLException | RemoteException | NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
   
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		System.setProperty("java.rmi.server.hostname","10.51.11.2");
		PersonDAO personDAO = (PersonDAO) Naming.lookup("rmi://10.51.11.8:1023/person");
		System.out.println(personDAO);
		System.out.println(personDAO.findById(4L).getName());
	}
  }

