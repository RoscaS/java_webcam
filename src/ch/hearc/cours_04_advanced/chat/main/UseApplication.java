
package ch.hearc.cours_04_advanced.chat.main;

import ch.hearc.cours_04_advanced.chat.rmi.ChatRMI;

public class UseApplication
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
		Application.getInstance();
		ChatRMI.getInstance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
