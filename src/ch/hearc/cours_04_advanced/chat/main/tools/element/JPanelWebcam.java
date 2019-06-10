package ch.hearc.cours_04_advanced.chat.main.tools.element;

import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

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
        try{
        webcam = new CustomWebcam();
        webcam.setGrey(1.5f, 1f);

        webcamPanel = new WebcamPanel(webcam.getWebcam());
        add(webcamPanel, BorderLayout.CENTER);
        }catch (Exception e) {}

    }

    private void control() {
        //rien
    }

    private void apparence() {
        try {
            webcamPanel.setFPSDisplayed(true);
            // webcamPanel.setDisplayDebugInfo(true);
            webcamPanel.setImageSizeDisplayed(true);
            webcamPanel.setMirrored(true);
        } catch (Exception e) {}

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
