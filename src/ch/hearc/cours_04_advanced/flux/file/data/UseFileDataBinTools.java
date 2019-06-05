
package ch.hearc.cours_04_advanced.flux.file.data;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class UseFileDataBinTools
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
		double[] tabData = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		String filename = "tabData.bin";

		try
			{
			FileDataBinTools.write(filename, tabData);
			Double[] tabDataCopie = FileDataBinTools.read(filename);
			System.out.println(Arrays.toString(tabDataCopie));

			File file = new File(filename);
			file.delete(); // Ne marche pas si on oublie de fermer les flux dans FileBinTools !
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
