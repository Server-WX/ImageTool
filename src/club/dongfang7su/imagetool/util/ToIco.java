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

            // 文件格式支持
            String[] extensionName = {
                    ".png",
                    ".jpg"
            };

            //  导出图像尺寸
            int[] sizeNumber = {
                    512,
                    256,
                    128,
                    64,
                    32,
                    16
            };

            for (String i : extensionName) {
                if (filePath.contains(i)) {
                    //  导出图像
                    ICOEncoder.write(resizeImage(image, sizeNumber[1]), new File(filePath.replace(i, "-" + sizeNumber[1] + "px" + ".ico")));
                }
            }

        } catch (IOException e) {
            System.out.println("文件读写异常");
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int size) {
        BufferedImage resizedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        resizedImage.getGraphics().drawImage(originalImage.getScaledInstance(size, size, BufferedImage.SCALE_SMOOTH), 0, 0, null);
        return resizedImage;
    }

}
