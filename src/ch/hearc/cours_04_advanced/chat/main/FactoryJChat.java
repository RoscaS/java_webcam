
package ch.hearc.cours_04_advanced.chat.main;

import ch.hearc.cours_04_advanced.chat.main.tools.JPanelMain;
import ch.hearc.cours_04_advanced.chat.main.tools.connection.JPanelConnection;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelChat;

public class FactoryJChat
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static JChat_A create()
	{
		return new JPanelMain();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

