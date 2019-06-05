
package ch.hearc.cours_04_advanced.flux.file.objet;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;

public class UseFileObjectBinTools
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
			Homme homme = new Homme("Boris", 32, 85);
			String fileName = "homme.bin";

			FileObjectBinTools.write(homme, fileName);
			Homme hommeCopy = FileObjectBinTools.read(fileName);

			System.out.println(homme);
			System.out.println(hommeCopy);

			Assert.assertTrue(new File(fileName).delete());
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
