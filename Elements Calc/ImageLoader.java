import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    public class Images{
        public static BufferedImage element = null;
    
    }

    public static void loadImages(){
        try {
            Images.element = ImageIO.read(new File("Images/element.png"));
        } catch (IOException e) {
        }
    }
}
