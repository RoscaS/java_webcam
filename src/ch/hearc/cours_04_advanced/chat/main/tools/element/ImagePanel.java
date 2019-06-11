package ch.hearc.cours_04_advanced.chat.main.tools.element;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel{

private BufferedImage image;

public ImagePanel() {
    image = new BufferedImage(
                        640,
                        480,
                        BufferedImage.TYPE_BYTE_BINARY);

    this.setMinimumSize(new Dimension(640/10,480/10));
    this.setPreferredSize(new Dimension(640,480));
}

public void setImage(BufferedImage bf)
{
    this.image = bf;
    this.repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
}

}
