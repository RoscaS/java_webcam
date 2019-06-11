package ch.hearc.cours_04_advanced.chat.main.tools.connection;

import org.apache.commons.validator.routines.InetAddressValidator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;


public class JPanelIpFormat extends JPanel {

    public JPanelIpFormat() {
        geometry();
        control();
        apparence();
    }

    /*------------------------------------------------------------------*\
   	|*							Control Methods 						*|
   	\*------------------------------------------------------------------*/

    private void geometry() {
        textFieldsIp = new ArrayList<>(4);
        setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++) {
            textFieldsIp.add(new JTextField(3));
            add(textFieldsIp.get(i));
        }
    }

    private void control() {
        for (JTextField jtf : textFieldsIp) {
            jtf.getDocument().addDocumentListener(getDocumentListener());
        }
    }

    private void apparence() {
        Dimension dimension = new Dimension();
        dimension.setSize(200,textFieldsIp.get(0).getHeight());
        this.setMinimumSize(dimension);
    }

    /*------------------------------------------------------------------*\
   	|*							Public Methods							*|
   	\*------------------------------------------------------------------*/

    public String getIp() {
        StringBuilder sb = new StringBuilder();
        for (JTextField jtf : textFieldsIp) {
            sb.append(jtf.getText()).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void setIp(String ip){
        String[] tableIp = ip.split("\\.");
        for(int i = 0; i < tableIp.length; i++)
        {
            textFieldsIp.get(i).setText(tableIp[i]);
        }
    }

    public Boolean isValide() {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        return validator.isValidInet4Address(getIp());
    }

    public void setBackgroundColor(Color bgColor)
    {
        for(JTextField ipComponent : textFieldsIp)
        {
            ipComponent.setBackground(bgColor);
        }
    }

    public void setForegroundColor(Color fgColor)
    {
        for(JTextField ipComponent : textFieldsIp)
        {
            ipComponent.setForeground(fgColor);
        }
    }

    public void setBorderTextField(Border border)
    {
        for (JTextField ipComponent : textFieldsIp)
        {
            ipComponent.setBorder(border);
        }
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
        isValide();
    }

    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private ArrayList<JTextField> textFieldsIp;

}
