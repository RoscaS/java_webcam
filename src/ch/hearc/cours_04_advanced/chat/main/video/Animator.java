
package ch.hearc.cours_04_advanced.chat.main.video;

import java.util.Timer;
import java.util.TimerTask;

import ch.hearc.cours_04_advanced.chat.main.Application;

/**
 * Singleton
 *
 */
public class Animator
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Animator()
		{
		timer = new Timer();
		webcamService = WebcamService.getInstance();
		timerTask = new TimerTask()
			{

			@Override
			public void run()
				{
				try
					{
					Application.getInstance().sendImage(webcamService.getImage());
					}
				catch (WebcamException e)
					{
					Application.getInstance().showError("[Animator] : [Constructor] : erreur de lecture de l'image");
					e.printStackTrace();
					}
				}
			};
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized Animator getInstance()
		{
		if (instance == null)
			{
			instance = new Animator();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void start()
		{
		timer.schedule(timerTask, DELAY, PERIOD);
		}

	public void stop()
		{
		timer.cancel();
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

	private Timer timer;
	private TimerTask timerTask;
	private WebcamService webcamService;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Animator instance = null;
	private static final long DELAY = 0;
	private static final long PERIOD = 100;

	}
