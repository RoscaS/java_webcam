
package ch.hearc.cours_04_advanced.chat.main;

import java.awt.image.BufferedImage;

import ch.hearc.cours_04_advanced.chat.main.tools.JFramePanelContainer;
import ch.hearc.cours_04_advanced.chat.rmi.ChatRMI;

/**
 * singleton
 */
public class Application implements JChat_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Application()
		{
		jChat = FactoryJChat.create();
		jFramePanelContainer = new JFramePanelContainer(jChat);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized Application getInstance()
		{
		if (instance == null)
			{
			instance = new Application();
			}

		return instance;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void sendText(String text)
		{
		ChatRMI.getInstance().sendText(text);
		}

	public void sendImage(BufferedImage bImage)
		{
		ChatRMI.getInstance().sendImage(bImage);
		}

	/*----------------------------------*\
	|*				JChat_I				*|
	\*----------------------------------*/

	@Override
	public void setText(String text)
		{
		this.jChat.setText(text);
		}

	@Override
	public void setRemoteImage(BufferedImage bImage)
		{
		this.jChat.setRemoteImage(bImage);
		}

	@Override
	public void setLocalImage(BufferedImage bLocalImage)
		{
		this.jChat.setLocalImage(bLocalImage);
		}

	@Override
	public void setRemotePseudo(String remotePseudo)
		{
		this.jChat.setRemotePseudo(remotePseudo);
		}

	@Override
	public void setLocalPseudo(String localPseudo)
		{
		this.jChat.setLocalPseudo(localPseudo);
		}

	@Override
	public void showError(String error)
		{
		this.jChat.showError(error);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Outputs

	// Tools

	private JChat_A jChat;
	private JFramePanelContainer jFramePanelContainer;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application instance = null;

	}
