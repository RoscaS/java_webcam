
package ch.hearc.cours_04_advanced.chat.main.security;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.PublicKey;

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

	public static void setForeignPublicKey(PublicKey foreignPublicKey)
	{
		SECURITY.init(foreignPublicKey);
	}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getSecret()
		{
		return this.secret;
		}

	public static PublicKey getPublicKey()
	{
		return SECURITY.getPublicKey();
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
		this.secret = Message.decrypter((byte[])in.readObject());
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static byte[] crypter(String message)
		{
		return SECURITY.encrypt(message.getBytes());
		}

	private static String decrypter(byte[] byteArray)
		{
		return new String(SECURITY.decrypt(byteArray));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input/Output
	private String secret;

	// Tools
	private static final Security_I SECURITY = FactorySecurity.create();

	}
