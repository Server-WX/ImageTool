package club.dongfang7su.imagetool.util;

import net.sf.image4j.codec.ico.ICOEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ToIco {

    public ToIco(String filePath) {
        try {
            BufferedImage image = ImageIO.read(new File(filePath));
            ICOEncoder.write(image, new File(filePath));
        } catch (IOException e) {
            System.out.println("文件读写异常");
        }
    }

}
