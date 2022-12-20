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
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("Failed to load image");
        }
    }
}
