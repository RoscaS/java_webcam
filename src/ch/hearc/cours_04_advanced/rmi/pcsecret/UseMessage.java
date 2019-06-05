
package ch.hearc.cours_04_advanced.rmi.pcsecret;

import java.io.IOException;

import ch.hearc.cours_04_advanced.flux.serialisation.objet.SerializerTools;

public class UseMessage
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		try
			{
			Message message = new Message("test");
			Message copie = (Message)SerializerTools.clone(message);
			System.out.println(message);
			System.out.println(copie);
			}
		catch (ClassNotFoundException | IOException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

