
package ch.hearc.cours_04_advanced.rmi.pcsecret;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Message implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Message(String secret)
		{
		this.secret = secret;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Message [secret=");
		builder.append(this.secret);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getSecret()
		{
		return this.secret;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Serialisation			*|
	\*------------------------------*/

	private void writeObject(ObjectOutputStream out) throws IOException
		{
		//System.out.println("writeObject appelée");
		out.writeObject(Message.crypter(this.secret));
		}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
		{
		//System.out.println("readObject appelée");
		this.secret = Message.decrypter((String)in.readObject());
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	/**
	 * Attendre le cours de cryptage de 3ème année pour faire un truc sérieux !
	 */
	private static String crypter(String message)
		{
		return message + "arc";
		}

	private static String decrypter(String message)
		{
		return message.substring(0, message.length() - 3);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input/Output
	private String secret;

	}
