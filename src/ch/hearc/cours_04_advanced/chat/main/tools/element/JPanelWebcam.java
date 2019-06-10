package ch.hearc.cours_04_advanced.chat.main.tools.element;

import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;
import java.awt.*;

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

        webcam = new CustomWebcam();
        webcam.setGrey(1.5f, 1f);
        webcamPanel = new WebcamPanel(webcam.getWebcam());
        add(webcamPanel, BorderLayout.CENTER);
    }

    private void control() {
        //rien
    }

    private void apparence() {
        webcamPanel.setFPSDisplayed(true);
        // webcamPanel.setDisplayDebugInfo(true);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(true);
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/



    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private WebcamPanel webcamPanel;
    private CustomWebcam webcam;
}
