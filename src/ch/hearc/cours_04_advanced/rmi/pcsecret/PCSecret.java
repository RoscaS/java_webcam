
package ch.hearc.cours_04_advanced.rmi.pcsecret;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import ch.hearc.cours_04_advanced.rmi.pchorloge.Horloge_I;
import ch.hearc.cours_04_advanced.rmi.pchorloge.PCHorloge;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

/**
 * singleton
 */
public class PCSecret
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private PCSecret()
		{
		serverSide();
		clientSide();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized PCSecret getInstance()
		{
		if (instance == null)
			{
			instance = new PCSecret();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Server				*|
	\*------------------------------*/

	private void serverSide()
		{
		Secret_I secret = new Secret();
		share(secret);
		}

	private void share(Secret_I secret)
		{
		try
			{
			RmiTools.shareObject(secret, new RmiURL(SECRET_RMI_ID));
			}
		catch (RemoteException | MalformedURLException e)
			{
			System.err.println("[PCSecret] : shareSecret : erreur de partage du secret");
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			Client				*|
	\*------------------------------*/

	private void clientSide()
		{
		Horloge_I horlogeRemote = connectHorloge();
		work(horlogeRemote);
		}

	private Horloge_I connectHorloge()
		{
		try
			{
			String ipAdress = System.getProperty("ipAddress");
			if (ipAdress == null) { throw new IllegalArgumentException(); }

			//RmiURL rmiurl = new RmiURL(PCHorloge.HORLOGE_RMI_ID, InetAddress.getByName(ipAdress), RmiTools.PORT_RMI_DEFAUT);
			RmiURL rmiurl = new RmiURL(PCHorloge.HORLOGE_RMI_ID, RmiTools.getLocalHost(), RmiTools.PORT_RMI_DEFAUT);
			Horloge_I horlogeRemote = (Horloge_I)RmiTools.connectionRemoteObjectBloquant(rmiurl);
			return horlogeRemote;
			}
		catch (RemoteException | MalformedURLException e)
			{
			System.err.println("[PCSecret] : connectHorloge : Erreur de connexion");
			e.printStackTrace();
			}
		catch (IllegalArgumentException e)
			{
			System.err.println("[PCSecret] : connectHorloge : Adresse IP non spécifiée");
			}

		return null;
		}

	private void work(Horloge_I horlogeRemote)
		{
		try
			{
			System.out.println(horlogeRemote.date());
			}
		catch (RemoteException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static PCSecret instance = null;

	public static final String SECRET_RMI_ID = "nimportequoi";

	}
