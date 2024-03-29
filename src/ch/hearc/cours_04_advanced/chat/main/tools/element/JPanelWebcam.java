package ch.hearc.cours_04_advanced.chat.main.tools.element;

import ch.hearc.cours_04_advanced.chat.main.Application;
import ch.hearc.cours_04_advanced.chat.main.JChat_A;
import ch.hearc.cours_04_advanced.chat.main.video.WebcamException;
import ch.hearc.cours_04_advanced.chat.main.video.WebcamService;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;
import java.util.Timer;
import java.util.TimerTask;

public class JPanelWebcam extends JChat_A {

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
        img = new ImagePanel();
        Box hBoxWebcam = Box.createHorizontalBox();
        Box vBoxWebcam = Box.createVerticalBox();

        addComboBoxWebcam();

        int idWebcam = getValideWebcamId();
        if (idWebcam != -1) {
            showWebcam(idWebcam);
        }

        hBoxWebcam.add(Box.createHorizontalGlue());
        hBoxWebcam.add(vBoxWebcam);
        hBoxWebcam.add(Box.createHorizontalGlue());
        vBoxWebcam.add(Box.createVerticalGlue());
        vBoxWebcam.add(img);
        vBoxWebcam.add(Box.createVerticalGlue());

        add(vBoxWebcam, BorderLayout.WEST);
        add(webcamComboBox, BorderLayout.SOUTH);
    }

    private void control() {
        webcamComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (webcam != webcamComboBox.getItemAt(webcamComboBox.getSelectedIndex())) {
                    showWebcam(webcamComboBox.getSelectedIndex());
                }
            }
        });
    }

    private void apparence() {
    }

    /*------------------------------------------------------------------*\
   	|*							Private Methods							*|
   	\*------------------------------------------------------------------*/

    private void setWebcamPanel() {
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(true);
    }


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

    private void addComboBoxWebcam() {
        for (Webcam webcam : Webcam.getWebcams()) {
            webcamComboBox.addItem(webcam);
        }
    }

    private int getValideWebcamId() {
        int i = 0;
        for (Webcam webcam : Webcam.getWebcams()) {
            {
                if (!webcam.getLock().isLocked()) {
                    webcamComboBox.setSelectedIndex(i);
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    private void setWebcam(int i) {
        if (!Webcam.getWebcams().get(i).getLock().isLocked()) {
            webcam = Webcam.getWebcams().get(i);
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            webcam.open();
        } else {
            JOptionPane.showOptionDialog(null, "La webcam n'est pas accessible !", "Webcam utilisé", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        }
    }

    private void showWebcam(int idWebcam) {
        setWebcam(idWebcam);
        setGrey(1.5f, 0.8f);
        webcamPanel = new WebcamPanel(webcam);
        setWebcamPanel();
        add(webcamPanel, BorderLayout.EAST);
    }
    /*------------------------------------------------------------------*\
   	|*							Private Attributs 						*|
   	\*------------------------------------------------------------------*/

    private WebcamPanel webcamPanel;
    private JComboBox<Webcam> webcamComboBox;
    private Webcam webcam;
    private BufferedImage webcamOther;

    private ImagePanel img;

    @Override
    public void setText(String text) {

    }

    @Override
    public void setRemoteImage(BufferedImage bRemoteImage) {
        img.setImage(bRemoteImage);
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
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                Application.getInstance().sendImage(webcam.getImage());
            }

            ;
        };

        timer.schedule(timerTask, 0, 75);
    }
}
