package club.dongfang7su.imagetool;

import java.io.File;

public class app {
    public static void main(String[] args) {
        for (String arg : args) {
            if (new File(arg).exists()) {
                String filePath = arg.replace("\\", "\\\\");
            }
        }
    }
}
