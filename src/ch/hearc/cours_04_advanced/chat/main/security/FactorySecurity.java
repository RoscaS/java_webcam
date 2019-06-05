
package ch.hearc.cours_04_advanced.chat.main.security;

public class FactorySecurity
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static Security_I create()
		{
		return new SecurityTemp(); // FIXME a changer par la vraie classe
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
