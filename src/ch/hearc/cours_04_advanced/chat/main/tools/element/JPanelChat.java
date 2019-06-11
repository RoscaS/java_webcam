package ch.hearc.cours_04_advanced.chat.main.tools.element;


import ch.hearc.cours_04_advanced.chat.main.Application;
import ch.hearc.cours_04_advanced.chat.main.JChat_A;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelChatWriter;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelWebcam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jPanelWebcam, jPanelChatWriter);
        setLayout(new BorderLayout());

        add(splitPane, BorderLayout.CENTER);
    }

    private void control() {

    }

    private void apparence() {
        splitPane.setDividerSize(3);
        splitPane.getTopComponent().setSize(200,500);
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Public Methods							*|
    \*------------------------------------------------------------------*/
    @Override
    public void setText(String text) {
        jPanelChatWriter.addTextLabel(text);
    }

    @Override
    public void setRemoteImage(BufferedImage bRemoteImage) {

    }

    @Override
    public void setLocalImage(BufferedImage bLocalImage) {

    }

    @Override
    public void setRemotePseudo(String remotePseudo) {
        this.remotePseudo = remotePseudo;
    }

    @Override
    public void setLocalPseudo(String localPseudo) {
        this.localPseudo = localPseudo;
        jPanelChatWriter.setLocalPseudo(this.localPseudo);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void startVideo() {
        jPanelWebcam.startVideo();
    }

    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private JPanelWebcam jPanelWebcam;
    private JPanelChatWriter jPanelChatWriter;

    private String remotePseudo, localPseudo;
    private JSplitPane splitPane;


}
