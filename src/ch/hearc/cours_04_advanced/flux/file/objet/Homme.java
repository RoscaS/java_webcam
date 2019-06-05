
package ch.hearc.cours_04_advanced.flux.file.objet;

import java.io.Serializable;

public class Homme implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Homme(String nom, int age, int poids)
		{
		this.nom = nom;
		this.age = age;
		this.poids = poids;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Hommes [nom=");
		builder.append(this.nom);
		builder.append(", age=");
		builder.append(this.age);
		builder.append(", poids=");
		builder.append(this.poids);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getNom()
		{
		return this.nom;
		}

	public int getAge()
		{
		return this.age;
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

	//INPUT
	private String nom;
	private int age;
	private int poids;
	}
