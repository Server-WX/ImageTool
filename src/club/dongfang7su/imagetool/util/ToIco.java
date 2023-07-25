package club.dongfang7su.imagetool.util;

import net.sf.image4j.codec.ico.ICOEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToIco {

    public ToIco(String filePath) {
        try {
            BufferedImage image = ImageIO.read(new File(filePath));

            // Resize image to 256x256
            BufferedImage resizedImage = resizeImage(image);

            // Create a list to hold different size images for ICO
            List<BufferedImage> imageList = new ArrayList<>();
            imageList.add(resizedImage);

            // Convert and write as ICO
            ICOEncoder.write(imageList, new File(filePath.replace(".png", ".ico")));
        } catch (IOException e) {
            System.out.println("文件读写异常");
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage) {
        BufferedImage resizedImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        resizedImage.getGraphics().drawImage(originalImage.getScaledInstance(256, 256, BufferedImage.SCALE_SMOOTH), 0, 0, null);
        return resizedImage;
    }

}
