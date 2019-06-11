package ch.hearc.cours_04_advanced.chat.main.tools.element;


import ch.hearc.cours_04_advanced.chat.main.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
        message = "Envoyer un message dans le chat";
        jtfMessage = new JTextField(message);
        lblChat = new JTextArea();
        btnDisconnect = new JButton("Se déconnecter");

        Box hBoxSender = Box.createHorizontalBox();
        Box vBoxSender = Box.createVerticalBox();

        hBoxSender.add(Box.createHorizontalStrut(20));
        hBoxSender.add(vBoxSender);
        hBoxSender.add(Box.createHorizontalStrut(20));

        vBoxSender.add(new JSeparator(SwingConstants.HORIZONTAL));
        vBoxSender.add(Box.createVerticalStrut(10));
        vBoxSender.add(jtfMessage);
        vBoxSender.add(Box.createVerticalStrut(10));

        setLayout(new BorderLayout());


        add(lblChat, BorderLayout.CENTER);
        add(hBoxSender, BorderLayout.SOUTH);
    }

    private void control() {

        jtfMessage.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                String message = localPseudo + ": " + jtfMessage.getText();
                                addTextLabel(message);
                                Application.getInstance().sendText(message);
                                jtfMessage.setText("");
                            }
                        });


        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                if (jtfMessage.getText().equals(message)) {
                    jtfMessage.setForeground(Color.BLACK);
                    jtfMessage.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                if (jtfMessage.getText().equals("")) {
                    jtfMessage.setForeground(new Color(84, 87, 94));
                    jtfMessage.setText(message);
                }
            }
        });
    }

    private void apparence() {
        this.setBackground(new Color(84, 87, 94));

        jtfMessage.setFont(new Font("Arial", Font.PLAIN, 15));
        jtfMessage.setForeground(new Color(84, 87, 94));
        jtfMessage.setPreferredSize(new Dimension(0, 40));
        jtfMessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jtfMessage.setBackground(new Color(164, 167, 174));
    }


    /*------------------------------------------------------------------*\
    |*							Public Methods							*|
    \*------------------------------------------------------------------*/

    public void addTextLabel(String text)
    {
        lblChat.setText(lblChat.getText() + "\n" + text);
    }

    public void setLocalPseudo(String localPseudo)
    {
        this.localPseudo = localPseudo;
    }

        /*------------------------------------------------------------------*\
       	|*							Private Methods							*|
       	\*------------------------------------------------------------------*/



        /*------------------------------------------------------------------*\
       	|*							Private Attributs 						*|
       	\*------------------------------------------------------------------*/

    private JTextField jtfMessage;
    private JTextArea lblChat;
    public JButton btnDisconnect;

    private String localPseudo;

    private String message;
}
