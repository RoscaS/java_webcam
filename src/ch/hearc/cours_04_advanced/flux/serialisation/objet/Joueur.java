
package ch.hearc.cours_04_advanced.flux.serialisation.objet;

import java.io.Serializable;

public class Joueur implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Joueur(String name, int poids)
		{
		this.name = name;
		this.poids = poids;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Joueur [name=");
		builder.append(this.name);
		builder.append(", poids=");
		builder.append(this.poids);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	public int getPoids()
		{
		return this.poids;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	private String name;
	private int poids;
	}
