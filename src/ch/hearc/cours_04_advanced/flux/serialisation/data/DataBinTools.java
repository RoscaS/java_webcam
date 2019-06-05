
package ch.hearc.cours_04_advanced.flux.serialisation.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataBinTools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static byte[] write(double[] tabData) throws IOException
		{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(baos);
		DataOutputStream dos = new DataOutputStream(bos);

		for(double data:tabData)
			{
			dos.writeDouble(data);
			}

		dos.close();
		bos.close();
		baos.close();

		return baos.toByteArray();
		}

	public static Double[] read(byte[] tabByte) throws IOException
		{
		ByteArrayInputStream bais = new ByteArrayInputStream(tabByte);
		BufferedInputStream bis = new BufferedInputStream(bais);
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
		bais.close();

		return list.toArray(new Double[0]);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
