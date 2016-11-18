package br.umc.iod.rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author marcio
 */
public interface JPAMessenger extends Remote {
 
	
    public void salva(Object objeto)throws RemoteException;
    public void remove(Object objeto)throws RemoteException;
    public void atualiza (Object objeto)throws RemoteException;
    public void consulta(String campo) throws RemoteException;
    public void abreConexao()throws RemoteException;
    public void fechaConexao()throws RemoteException;
    
}
