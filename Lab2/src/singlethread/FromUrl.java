package singlethread;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.nio.file.Paths;

public class FromUrl {

    public static void main(String[] args) {
        URL url = null;
        BufferedImage image;
        String[] links = {
            "https://bipbap.ru/wp-content/uploads/2017/04/krasivye_kollazh_na_temu_prirody_1920x1200.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/242624_565001.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/krasivye-kartinki-Priroda-2278640.jpeg",
            "https://bipbap.ru/wp-content/uploads/2017/04/wallpapers-nature-16.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/voshod_solnca_priroda_pole_mostik_4499x2231.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/v2.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_05.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_01.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/priroda_05.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/priroda_01.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/plitvickiye-ozera-1.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-10.jpg",
            "https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-1-4.jpg"

        };

        long t=System.currentTimeMillis();

        for (String link: links) {
            try
            {
                url = new URL(link);
            }
            catch (MalformedURLException e1)
            {
                e1.printStackTrace();
            }
            try
            {
                image = ImageIO.read(url);
                ImageIO.write(image, "jpg", new File("D:/images/"+ Paths.get(url.getPath()).getFileName()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("done");
        }

        System.out.println("Время выполнения программы(url): " + (System.currentTimeMillis()-t) + " мс");

    }
}
