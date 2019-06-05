
package ch.hearc.cours_04_advanced.flux.file.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataBinTools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void write(String filename, double[] tabData) throws IOException
		{
		FileOutputStream fos = new FileOutputStream(filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);

		for(double data:tabData)
			{
			dos.writeDouble(data);
			}

		dos.close();
		bos.close();
		fos.close();
		}

	public static Double[] read(String filename) throws IOException
		{
		FileInputStream fis = new FileInputStream(filename);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);

		List<Double> list = new ArrayList<Double>();

		try
			{
			while(true)
				{
				double valeur = dis.readDouble();
				list.add(valeur);
				}
			}
		catch (Exception e)
			{
			//Fin du fichier
			}

		dis.close();
		bis.close();
		fis.close();

		return toTableau(list);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Double[] toTableau(List<Double> list)
		{
		Double[] tab = list.toArray(new Double[0]); //l'Input de toArray est un tableau vide indiquant le type de l'output.
		return tab;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
