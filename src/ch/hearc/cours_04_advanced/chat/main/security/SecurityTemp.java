
package ch.hearc.cours_04_advanced.chat.main.security;

import java.security.PublicKey;

public class SecurityTemp implements Security_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public byte[] encrypt(byte[] byteArray)
		{
		return byteArray;
		}

	@Override
	public byte[] decrypt(byte[] byteArray)
		{
		return byteArray;
		}

	@Override
	public void init(PublicKey publicKey)
		{

		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private PublicKey foreignKey;

	}
