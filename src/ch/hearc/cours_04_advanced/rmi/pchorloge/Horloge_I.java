
package ch.hearc.cours_04_advanced.rmi.pchorloge;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface Horloge_I extends Remote
	{
	public Date date() throws RemoteException;
	}

