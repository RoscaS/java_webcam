
package ch.hearc.cours_04_advanced.chat.main.video;

import java.awt.image.BufferedImage;

/**
 * singleton
 */
public class WebcamService
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private WebcamService()
		{
		webcam = FactoryWebcam.create();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized WebcamService getInstance()
		{
		if (instance == null)
			{
			instance = new WebcamService();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public BufferedImage getImage() throws WebcamException
		{
		return webcam.getImage();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools

	private Webcam_I webcam;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static WebcamService instance = null;

	}
