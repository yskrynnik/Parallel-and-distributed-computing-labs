package singlethread;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FromLocalDrive {
    public static void main(String[] args)
    {
        File file;
        BufferedImage image;
        String[] paths = {
                "D:/images/krasivye_kollazh_na_temu_prirody_1920x1200.jpg",
                "D:/images/242624_565001.jpg",
                "D:/images/krasivye-kartinki-Priroda-2278640.jpeg",
                "D:/images/wallpapers-nature-16.jpg",
                "D:/images/voshod_solnca_priroda_pole_mostik_4499x2231.jpg",
                "D:/images/v2.jpg",
                "D:/images/priroda_kartinki_foto_05.jpg",
                "D:/images/priroda_kartinki_foto_01.jpg",
                "D:/images/priroda_05.jpg",
                "D:/images/priroda_01.jpg",
                "D:/images/plitvickiye-ozera-1.jpg",
                "D:/images/maxresdefault-10.jpg",
                "D:/images/maxresdefault-1-4.jpg"
        };

        long t = System.currentTimeMillis();

        for(String path: paths) {
            file = new File(path);
            try
            {
                image = ImageIO.read(file);
                ImageIO.write(image, "jpg", new File("D:/Kartinki/"+file.getName()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("done");
        }

        System.out.println("Время выполнения программы(localDrive): " + (System.currentTimeMillis()-t) + " мс");
    }
}
