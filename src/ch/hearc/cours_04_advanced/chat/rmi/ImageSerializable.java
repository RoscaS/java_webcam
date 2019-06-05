package ch.hearc.cours_04_advanced.chat.rmi;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class ImageSerializable implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageSerializable(BufferedImage image)
		{
		this.bImage = image;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public BufferedImage getImage()
		{
		return this.bImage;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	* Customisation serialisation
	*/
	private void writeObject(ObjectOutputStream oos)
		{
		try
			{
			ImageIO.write(this.bImage, "jpeg", oos);
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	/**
	* Customisation deserialisation
	*/
	private void readObject(ObjectInputStream ois)
		{
		try
			{
			this.bImage = ImageIO.read(ois);
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// transient -> l'attribut ne sera pas serialise
	// Rappel: BufferedImage n'est pas serialisable
	private transient BufferedImage bImage;
	}
