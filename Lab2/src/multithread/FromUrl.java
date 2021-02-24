package multithread;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FromUrl {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Callable<Void>> callables = Arrays.asList(
                callable("https://bipbap.ru/wp-content/uploads/2017/04/krasivye_kollazh_na_temu_prirody_1920x1200.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/242624_565001.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/voshod_solnca_priroda_pole_mostik_4499x2231.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/krasivye-kartinki-Priroda-2278640.jpeg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/v2.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/wallpapers-nature-16.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_05.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_01.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/priroda_05.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/priroda_01.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/plitvickiye-ozera-1.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-10.jpg"),
                callable("https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-1-4.jpg"));

        long t = System.currentTimeMillis();

        executor.invokeAll(callables);
        executor.shutdown();

        System.out.println("Время выполнения программы(url): " + (System.currentTimeMillis()-t) + " мс");

    }

    static Callable<Void> callable(String link)
    {
        return () -> {
            URL url = null;
            BufferedImage image;
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
            return null;
        };
    }
}


