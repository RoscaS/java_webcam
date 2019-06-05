
package ch.hearc.cours_04_advanced.flux.serialisation.data;

import java.io.IOException;
import java.util.Arrays;

public class UseDataBinTools
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

		try
			{
			byte[] tabByte = DataBinTools.write(tabData);
			Double[] tabDataCopie = DataBinTools.read(tabByte);
			System.out.println(Arrays.toString(tabDataCopie));
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
