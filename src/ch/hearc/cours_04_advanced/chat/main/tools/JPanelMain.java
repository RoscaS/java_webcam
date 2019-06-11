package ch.hearc.cours_04_advanced.chat.main.tools;

import ch.hearc.cours_04_advanced.chat.main.JChat_A;
import ch.hearc.cours_04_advanced.chat.main.tools.connection.JPanelConnection;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelChat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JPanelMain extends JChat_A {

    public JPanelMain() {
        geometry();
        control();
        apparence();
    }

    /*------------------------------------------------------------------*\
   	|*							Control Methods 						*|
   	\*------------------------------------------------------------------*/

    private void geometry() {
        jPanelConnection = new JPanelConnection();
        jPanelChat = new JPanelChat();
        setLayout(new BorderLayout());
        Box hBox = Box.createHorizontalBox();
        Box vBox = Box.createVerticalBox();

        hBox.add(Box.createHorizontalGlue());
        hBox.add(jPanelConnection);
        hBox.add(Box.createHorizontalGlue());

        vBox.add(Box.createVerticalGlue());
        vBox.add(hBox);
        vBox.add(Box.createVerticalGlue());
        add(vBox, BorderLayout.CENTER);
    }

    private void control() {

    }

    private void apparence() {
        this.setBackground(new Color(84, 87, 94));
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/



    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    JPanelConnection jPanelConnection;
    JPanelChat jPanelChat;



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
}
