
package ch.hearc.cours_04_advanced.chat.main;

import ch.hearc.cours_04_advanced.chat.main.tools.JChatTemp;
import ch.hearc.cours_04_advanced.chat.main.tools.JPanelChat;

public class FactoryJChat
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static JChat_A create()
	{
		return new JPanelChat(); //FIXME a remplacer par la classe de l'equipe gui
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

