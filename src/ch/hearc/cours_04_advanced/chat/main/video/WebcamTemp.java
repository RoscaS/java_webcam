
package ch.hearc.cours_04_advanced.chat.main.video;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class WebcamTemp implements Webcam_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public BufferedImage getImage()
		{
		return createImage();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static BufferedImage createImage()
		{
		int w = 600;
		int h = 400;
		BufferedImage bImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		int rgb = new Color(123, 56, 39).getRGB();
		for(int i = 0; i < h; i++)
			{
			for(int j = 0; j < w; j++)
				{
				bImage.setRGB(j, i, rgb);
				}
			}

		return bImage;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
