package ch.hearc.cours_04_advanced.chat.main.tools.element;

import javax.swing.*;
import java.awt.*;

public class JPanelChatWriter extends JPanel {

    public JPanelChatWriter() {
        geometry();
        control();
        apparence();
    }

        /*------------------------------------------------------------------*\
       	|*							Control Methods 						*|
       	\*------------------------------------------------------------------*/

    private void geometry() {
        jtfMessage = new JTextField();
        jtaChat = new JTextArea();
        btnDisconnect = new JButton("Se déconnecter");
        btnSend = new JButton("->");
        Box box = Box.createVerticalBox();

        setLayout(new BorderLayout());

        add(box, BorderLayout.CENTER);
        box.add(this.jtfMessage);
        box.add(Box.createVerticalGlue());
        box.add(this.jtaChat);
        box.add(this.btnSend);
        box.add(this.btnDisconnect);
    }

    private void control() {

    }

    private void apparence() {

    }

        /*------------------------------------------------------------------*\
       	|*							Private Methods							*|
       	\*------------------------------------------------------------------*/



        /*------------------------------------------------------------------*\
       	|*							Private Attributs 						*|
       	\*------------------------------------------------------------------*/

    private JTextField jtfMessage;
    private JTextArea jtaChat;
    private JButton btnSend;
    public JButton btnDisconnect;
}
