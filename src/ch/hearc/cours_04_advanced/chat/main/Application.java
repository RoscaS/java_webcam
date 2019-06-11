
package ch.hearc.cours_04_advanced.chat.main;

import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import ch.hearc.cours_04_advanced.chat.main.tools.JFramePanelContainer;
import ch.hearc.cours_04_advanced.chat.main.tools.connection.JPanelConnection;
import ch.hearc.cours_04_advanced.chat.rmi.ChatRMI;

import javax.swing.*;

/**
 * singleton
 */
public class Application implements JChat_I, Runnable {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

    private Application() {
        jChat = FactoryJChat.create();
        new JFramePanelContainer(jChat);
    }

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

    public static synchronized Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }

        return instance;
    }

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run() {
		 ChatRMI.getInstance();
		 jChat.startVideo();
	}

    public void connect() {

    	if(System.getProperty("ID_SHARE") == null)
		{
			System.setProperty("ID_SHARE", "1");
			System.setProperty("ID_CONNECT", "1");
		}

    	Thread thread = new Thread(this);
    	thread.start();
    }

    public void sendText(String text) {
        ChatRMI.getInstance().sendText(text);
    }

    public void sendImage(BufferedImage bImage) {
        ChatRMI.getInstance().sendImage(bImage);
    }

	/*----------------------------------*\
	|*				JChat_I				*|
	\*----------------------------------*/

    @Override
    public void setText(String text) {
        this.jChat.setText(text);
    }

    @Override
    public void setRemoteImage(BufferedImage bImage) {
        this.jChat.setRemoteImage(bImage);
    }

    @Override
    public void setLocalImage(BufferedImage bLocalImage) {
        this.jChat.setLocalImage(bLocalImage);
    }

    @Override
    public void setRemotePseudo(String remotePseudo) {
        this.jChat.setRemotePseudo(remotePseudo);
    }

    @Override
    public void setLocalPseudo(String localPseudo) {
        this.jChat.setLocalPseudo(localPseudo);
    }

    @Override
    public void showError(String error) {
        this.jChat.showError(error);
    }

	@Override
	public void startVideo() {

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

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

    private static Application instance = null;
}
