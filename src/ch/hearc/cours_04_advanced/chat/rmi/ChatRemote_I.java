
package ch.hearc.cours_04_advanced.chat.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.PublicKey;

import ch.hearc.cours_04_advanced.chat.main.security.Message;

public interface ChatRemote_I extends Remote
	{
		public void setText(Message message) throws RemoteException;

		public void initForeignKey(PublicKey foreignKey) throws RemoteException;

		public void setImage(ImageSerializable imageSerializable) throws RemoteException;

		public void initPseudo(String pseudo) throws RemoteException;
	}

