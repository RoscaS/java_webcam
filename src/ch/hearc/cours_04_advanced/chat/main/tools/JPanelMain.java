package ch.hearc.cours_04_advanced.chat.main.tools;

import ch.hearc.cours_04_advanced.chat.main.JChat_A;
import ch.hearc.cours_04_advanced.chat.main.tools.connection.JPanelConnection;
import ch.hearc.cours_04_advanced.chat.main.tools.element.JPanelChat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        vBox = Box.createVerticalBox();

        hBox.add(Box.createHorizontalGlue());
        hBox.add(jPanelConnection);
        hBox.add(Box.createHorizontalGlue());

        vBox.add(Box.createVerticalGlue());
        vBox.add(hBox);
        vBox.add(Box.createVerticalGlue());
        add(vBox);
    }

    private void control() {
        jPanelConnection.getBtnConnection().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(vBox);
                add(jPanelChat);
                revalidate();
                repaint();
            }
        });
    }

    private void apparence() {
        setBackground(new Color(84, 87, 94));
        setMinimumSize(new Dimension(jPanelConnection.getMinimumSize()));
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/



    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private JPanelConnection jPanelConnection;
    private JPanelChat jPanelChat;
    private Box vBox;



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
