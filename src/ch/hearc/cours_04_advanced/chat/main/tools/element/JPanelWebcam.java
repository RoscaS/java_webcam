package ch.hearc.cours_04_advanced.chat.main.tools.element;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelWebcam extends JPanel {

    public JPanelWebcam() {
        geometry();
        control();
        apparence();

    }

    /*------------------------------------------------------------------*\
   	|*							Control Methods 						*|
   	\*------------------------------------------------------------------*/

    private void geometry() {
        setLayout(new BorderLayout());
        webcamComboBox = new JComboBox<>();

        for (Webcam webcam : Webcam.getWebcams())
            {
                webcamComboBox.addItem(webcam);
            }

        try{
        webcam = new CustomWebcam();
        webcam.setGrey(1.5f, 1f);

        webcamPanel = new WebcamPanel(webcam.getWebcam());
        add(webcamPanel, BorderLayout.CENTER);

        } catch (Exception ignored) {}

        add(webcamComboBox, BorderLayout.NORTH);
    }

    private void control() {
        //rien
        webcamComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Webcam.getWebcams().get(webcamComboBox.getSelectedIndex()).isOpen();//TODO use it
                webcam.setWebcam(webcamComboBox.getSelectedIndex());
                webcamPanel = new WebcamPanel(webcam.getWebcam());
                add(webcamPanel, BorderLayout.CENTER);
            }
        });
    }

    private void apparence() {
        try {
            webcamPanel.setFPSDisplayed(true);
            // webcamPanel.setDisplayDebugInfo(true);
            webcamPanel.setImageSizeDisplayed(true);
            webcamPanel.setMirrored(true);
        } catch (Exception ignored) {}
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/



    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private WebcamPanel webcamPanel;
    private JComboBox<Webcam> webcamComboBox;
    private CustomWebcam webcam;
}
