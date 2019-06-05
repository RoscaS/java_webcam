
package ch.hearc.cours_04_advanced.chat.main.video;

import ch.hearc.cours_04_advanced.chat.video.WebcamConcrete;

public class FactoryWebcam
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static Webcam_I create()
		{
		return new WebcamConcrete(); //FIXME a changer par la vraie webcam
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
