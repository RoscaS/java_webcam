package ch.hearc.cours_04_advanced.chat.main.tools.connection;

import ch.hearc.cours_04_advanced.chat.main.Application;
import ch.hearc.cours_04_advanced.chat.main.JChat_A;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class JPanelConnection extends JChat_A {

    public JPanelConnection() {
        geometry();
        control();
        apparence();
    }

    /*------------------------------------------------------------------*\
   	|*							Control Methods 						*|
   	\*------------------------------------------------------------------*/

    private void geometry() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        gridLayout = new GridBagLayout();

        lblIpServer = new JLabel("Adresse IP distante");
        lblPseudo = new JLabel("Votre pseudo");
        assert inetAddress != null;
        lblIpClient = new JLabel("Votre adresse IP : " + inetAddress.getHostAddress());
        txfPseudo = new JTextField();
        txfIp = new JPanelIpFormat();
        btnConnection = new JButton("Connexion");

        setLayout(gridLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(lblIpServer, constraints);
        constraints.gridy = 1;
        add(lblPseudo, constraints);
        constraints.gridy = 2;
        add(lblIpClient, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.NONE;
        add(txfIp, constraints);
        constraints.gridy = 1;
        add(txfPseudo, constraints);
        constraints.gridy = 2;
        add(btnConnection, constraints);
    }

    private void control() {
        txfPseudo.getDocument().addDocumentListener(getDocumentListener());

        btnConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().setLocalPseudo(txfPseudo.getText());
                System.setProperty("IP_ADDRESS", txfIp.getIp());
                Application.getInstance().connect();
            }
        });
    }

    private void apparence() {
        //this.getRootPane().setDefaultButton(btnConnection);
        Color backgroundColor = new Color(50,50,50);
        this.setBackground(backgroundColor);
        this.setPreferredSize(new Dimension(430, 150));
        this.setMinimumSize(new Dimension(430, 150));

        txfIp.setBackground(backgroundColor);

        Color backgroundTextField = new Color(25,25,25);
        txfIp.setBackgroundColor(backgroundTextField);
        txfPseudo.setBackground(backgroundTextField);

        Color textFieldFontColor = new Color(200,200,200);
        txfPseudo.setForeground(textFieldFontColor);
        txfIp.setForegroundColor(textFieldFontColor);

        txfPseudo.setBorder(BorderFactory.createLineBorder(backgroundTextField, 2, true));
        txfIp.setBorderTextField(BorderFactory.createLineBorder(backgroundTextField, 2, true));

        btnConnection.setEnabled(false);
        btnConnection.setForeground(Color.white);
        btnConnection.setBackground(new Color(100, 100, 200));
        btnConnection.setPreferredSize(new Dimension(175, 25));
        Border borderButton = BorderFactory.createLineBorder(new Color(100, 100, 200));
        btnConnection.setBorder(borderButton);

        txfPseudo.setMinimumSize(new Dimension(175,30));
        txfPseudo.setPreferredSize(new Dimension(175,20));

        Color colorFont = Color.WHITE;
        lblIpServer.setForeground(colorFont);
        lblIpClient.setForeground(colorFont);
        lblPseudo.setForeground(colorFont);
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/
    private DocumentListener getDocumentListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                warn();
            }
        };
    }

    private void warn() {
        if (valideValue()) {
            btnConnection.setEnabled(true);
        } else {
            btnConnection.setEnabled(false);
        }
    }

    private boolean valideValue(){
        return (!txfPseudo.getText().isEmpty() && txfIp.isValide());
    }

    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/
    public JButton getBtnConnection() {
        return btnConnection;
    }

    private JLabel lblIpServer, lblPseudo, lblIpClient;
    private JPanelIpFormat txfIp;
    private JTextField txfPseudo;
    private JButton btnConnection;
    private GridBagLayout gridLayout;

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

    @Override
    public void startVideo() {

    }
}
