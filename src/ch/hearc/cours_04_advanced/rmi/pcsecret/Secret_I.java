
package ch.hearc.cours_04_advanced.rmi.pcsecret;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Secret_I extends Remote
	{

	public Message secret() throws RemoteException;

	}
