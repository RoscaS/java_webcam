
package ch.hearc.cours_04_advanced.flux.serialisation.objet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Equipe implements Iterable<Joueur> ,Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Equipe(String name)
		{
		this.name = name;
		this.listJoueurs = new ArrayList<Joueur>();
		}

	public static Equipe createExample()
		{
		Joueur joueur1 = new Joueur("Boris", 75);
		Joueur joueur2 = new Joueur("Ivan", 82);
		Joueur joueur3 = new Joueur("Vladimir", 95);

		Equipe equipe = new Equipe("Russie");
		equipe.add(joueur1);
		equipe.add(joueur2);
		equipe.add(joueur3);

		return equipe;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public Iterator<Joueur> iterator()
		{
		return listJoueurs.iterator();
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("Equipe [listJoueurs=");
		builder.append(this.listJoueurs);
		builder.append(", name=");
		builder.append(this.name);
		builder.append("]");
		return builder.toString();
		}

	public void add(Joueur joueur)
		{
		listJoueurs.add(joueur);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private List<Joueur> listJoueurs;
	private String name;
	}
