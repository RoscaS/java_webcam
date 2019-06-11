package ch.hearc.cours_04_advanced.chat.main.tools.connection;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class JPanelConnection extends JPanel {

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

        gridLayout = new GridLayout(3, 3);
        lblIpServer = new JLabel("Adresse IP distante");
        lblPseudo = new JLabel("Votre pseudo");
        assert inetAddress != null;
        lblIpClient = new JLabel("Votre adresse IP : " + inetAddress.getHostAddress());
        txfPseudo = new JTextField();
        txfIp = new JPanelIpFormat();
        btnConnection = new JButton("Connexion");

        setLayout(gridLayout);

        add(lblIpServer);
        add(txfIp);
        add(lblPseudo);
        add(txfPseudo);
        add(lblIpClient);
        add(btnConnection);
    }

    private void control() {
        txfPseudo.getDocument().addDocumentListener(getDocumentListener());
    }

    private void apparence() {
        //this.getRootPane().setDefaultButton(btnConnection);

        btnConnection.setEnabled(false);
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
    private GridLayout gridLayout;
}
