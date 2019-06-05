
package ch.hearc.cours_04_advanced.flux.serialisation.objet;

import java.io.IOException;

public class UseEquipe
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
			Equipe equipe = Equipe.createExample();
			Equipe equipeClone = (Equipe)SerializerTools.clone(equipe);

			System.out.println(equipe);
			System.out.println(equipeClone);
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
