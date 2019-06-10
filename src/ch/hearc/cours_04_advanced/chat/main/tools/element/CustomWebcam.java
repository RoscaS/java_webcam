package ch.hearc.cours_04_advanced.chat.main.tools.element;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.RescaleOp;

public class CustomWebcam {

    /*------------------------------------------------------------------*\
	|*							Constructors						  *|
	\*------------------------------------------------------------------*/

    public CustomWebcam() {
        webcam = Webcam.getDefault();
        System.out.println("\n\n");
        for (Webcam webcam : Webcam.getWebcams())
            {
                System.out.println(webcam.getName());
            }
        webcam.setViewSize(WebcamResolution.VGA.getSize());
    }

	/*------------------------------------------------------------------*\
	|*							Public Methods 						  *|
	\*------------------------------------------------------------------*/

    public void setGrey(float ScaleFactor, float Offset) {
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

	/*------------------------------*\
	|*				Getters		   *|
	\*------------------------------*/
    public Webcam getWebcam() {
        return webcam;
    }

	/*------------------------------*\
	|*				Setters		   *|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Private Methods 				      *|
	\*------------------------------------------------------------------*/

	private Webcam webcam;
}
