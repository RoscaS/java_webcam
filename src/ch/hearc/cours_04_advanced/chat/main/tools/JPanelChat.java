package ch.hearc.cours_04_advanced.chat.main.tools;


import ch.hearc.cours_04_advanced.chat.main.JChat_A;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelChatWriter;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelWebcam;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JPanelChat extends JChat_A {

    public JPanelChat() {
        geometry();
        control();
        apparence();
    }

    /*------------------------------------------------------------------*\
   	|*							Control Methods 						*|
   	\*------------------------------------------------------------------*/

    private void geometry() {
        jPanelChatWriter = new JPanelChatWriter();
        jPanelWebcam = new JPanelWebcam();

        setLayout(new BorderLayout());

        add(jPanelChatWriter, BorderLayout.CENTER);
        add(jPanelWebcam, BorderLayout.WEST);
    }

    private void control() {

    }

    private void apparence() {

    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Public Methods							*|
    \*------------------------------------------------------------------*/
    @Override
    public void setText(String text) {

    }

    @Override
    public void setRemoteImage(BufferedImage bRemoteImage) {

    }

    @Override
    public void setLocalImage(BufferedImage bLocalImage) {

    }

    @Override
    public void setRemotePseudo(String remotePseudo) {

    }

    @Override
    public void setLocalPseudo(String localPseudo) {

    }

    @Override
    public void showError(String error) {

    }

    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private JPanelWebcam jPanelWebcam;
    private JPanelChatWriter jPanelChatWriter;


}
