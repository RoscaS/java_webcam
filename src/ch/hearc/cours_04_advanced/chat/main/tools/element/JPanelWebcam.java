package ch.hearc.cours_04_advanced.chat.main.tools.element;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;

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
        addWebcam();

        webcam = Webcam.getDefault();


        try {
            setGrey(1.5f, 1f);
            webcamPanel = new WebcamPanel(webcam);
            add(webcamPanel, BorderLayout.CENTER);

        } catch (Exception ignored) {
        }

        add(webcamComboBox, BorderLayout.SOUTH);
    }

    private void control() {
        //rien
        webcamComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Webcam.getWebcams().get(webcamComboBox.getSelectedIndex()).isOpen();//TODO use it
                setWebcam(webcamComboBox.getSelectedIndex());
                webcamPanel = new WebcamPanel(webcam);
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
        } catch (Exception ignored) {
        }
    }


    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/

    private void setGrey(float ScaleFactor, float Offset) {
        webcam.setImageTransformer((BufferedImage image) -> {
            BufferedImage modified;
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            RescaleOp ro = new RescaleOp(ScaleFactor, Offset, null);
            ColorConvertOp op = new ColorConvertOp(cs, null);

            modified = ro.filter(image, null);
            op.filter(modified, modified);

            return modified;
        });
    }

    private void addWebcam() {
        for (Webcam webcam : Webcam.getWebcams()) {
            webcamComboBox.addItem(webcam);
        }
    }

    private void setWebcam(int i) {
        webcam = Webcam.getWebcams().get(i);
    }
    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private WebcamPanel webcamPanel;
    private JComboBox<Webcam> webcamComboBox;
    private Webcam webcam;
    private BufferedImage webcamOther;
}
