
package ch.hearc.cours_04_advanced.rmi.pchorloge;

import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import ch.hearc.cours_04_advanced.rmi.pcsecret.PCSecret;
import ch.hearc.cours_04_advanced.rmi.pcsecret.Secret_I;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

/**
 * singleton
 */
public class PCHorloge
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private PCHorloge()
		{
		serverSide();
		clientSide();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized PCHorloge getInstance()
		{
		if (instance == null)
			{
			instance = new PCHorloge();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Server				*|
	\*------------------------------*/

	private void serverSide()
		{
		this.horloge = new Horloge();
		shareHorloge();
		}

	private void shareHorloge()
		{
		try
			{
			RmiTools.shareObject(this.horloge, new RmiURL(PCHorloge.HORLOGE_RMI_ID));
			}
		catch (RemoteException | MalformedURLException e)
			{
			System.err.println("[PCHorloge] : shareHorloge : Failed");
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			Client				*|
	\*------------------------------*/

	private void clientSide()
		{
		Secret_I secretRemote = connect();
		work(secretRemote);
		}

	private Secret_I connect()
		{
		try
			{
			RmiURL rmiURL = new RmiURL(PCSecret.SECRET_RMI_ID, RmiTools.getLocalHost(), RmiTools.PORT_RMI_DEFAUT);
			Remote remote = RmiTools.connectionRemoteObjectBloquant(rmiURL);
			Secret_I secretRemote = (Secret_I)remote;
			return secretRemote;
			}
		catch (RemoteException | MalformedURLException e)
			{
			System.err.println("[PCHorloge] : connectSecret : erreur");
			e.printStackTrace();
			return null;
			}
		}

	private void work(Secret_I secretRemote)
		{
		try
			{
			System.out.println(secretRemote.secret());
			}
		catch (RemoteException e)
			{
			System.err.println("[PCHorloge] : workSecret : erreur");
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools
	private Horloge horloge;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static PCHorloge instance = null;

	public static final String HORLOGE_RMI_ID = "Horloge_rmi_id";

	}
