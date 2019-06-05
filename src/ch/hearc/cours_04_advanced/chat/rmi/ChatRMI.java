
package ch.hearc.cours_04_advanced.chat.rmi;

import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import ch.hearc.cours_04_advanced.chat.main.Application;
import ch.hearc.cours_04_advanced.rmi.pcsecret.Message;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

/**
 * singleton
 */
public class ChatRMI implements ChatRemote_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private ChatRMI()
		{
		serverSide();
		clientSide();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized ChatRMI getInstance()
		{
		if (instance == null)
			{
			instance = new ChatRMI();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * Appelle a distance la methode et change le gui
	 */
	public void sendText(String text)
		{
		try
			{
			chatRemote.setText(new Message(text));
			}
		catch (RemoteException e)
			{
			Application.getInstance().showError("[ChatRMI] : sendText : " + text);
			e.printStackTrace();
			}
		}

	/**
	 * Appelle a distance la methode et change le gui
	 */
	public void sendImage(BufferedImage bImage)
		{
		try
			{
			chatRemote.setImage(new ImageSerializable(bImage));
			}
		catch (RemoteException e)
			{
			Application.getInstance().showError("[ChatRMI] : sendImage");
			e.printStackTrace();
			}
		}

	/**
	 * Appelee a distance, change le gui local
	 */
	@Override
	public void setText(Message message) throws RemoteException
		{
		Application.getInstance().setText(message.getSecret());
		}

	/**
	 * Appelee a distance, change le gui local
	 */
	@Override
	public void setImage(ImageSerializable imageSerializable) throws RemoteException
		{
		Application.getInstance().setRemoteImage(imageSerializable.getImage());
		}

	/**
	 * Appelee a distance, change le gui local
	 */
	@Override
	public void initPseudo(String pseudo) throws RemoteException
		{
		Application.getInstance().setRemotePseudo(pseudo);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Server			*|
	\*------------------------------*/

	private void serverSide()
		{
		try
			{
			RmiTools.shareObject(this, new RmiURL(ID_SHARE));
			}
		catch (RemoteException | MalformedURLException e)
			{
			Application.getInstance().showError("[ChatRMI] : serverSide : share error");
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*				Client			*|
	\*------------------------------*/

	private void clientSide()
		{
		chatRemote = connect();
		}

	private ChatRemote_I connect()
		{
		try
			{
			RmiURL rmiURL = new RmiURL(ID_CONNECT, InetAddress.getByName(IP_ADDRESS), RmiTools.PORT_RMI_DEFAUT);
			ChatRemote_I chatRemote = (ChatRemote_I)RmiTools.connectionRemoteObjectBloquant(rmiURL);
			return chatRemote;
			}
		catch (RemoteException | MalformedURLException | UnknownHostException e)
			{
			Application.getInstance().showError("[ChatRMI] : clientSide : connect error");
			e.printStackTrace();
			return null;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools
	private ChatRemote_I chatRemote;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static ChatRMI instance = null;

	private static final String ID_SHARE = System.getProperty("ID_SHARE");
	private static final String ID_CONNECT = System.getProperty("ID_CONNECT");
	private static final String IP_ADDRESS = System.getProperty("IP_ADDRESS");

	}
