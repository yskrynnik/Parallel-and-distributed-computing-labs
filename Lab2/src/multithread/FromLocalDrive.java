package multithread;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FromLocalDrive {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Callable<Void>> callables = Arrays.asList(
                callable("D:/images/krasivye_kollazh_na_temu_prirody_1920x1200.jpg"),
                callable("D:/images/242624_565001.jpg"),
                callable("D:/images/krasivye-kartinki-Priroda-2278640.jpeg"),
                callable("D:/images/wallpapers-nature-16.jpg"),
                callable("D:/images/voshod_solnca_priroda_pole_mostik_4499x2231.jpg"),
                callable("D:/images/v2.jpg"),
                callable("D:/images/priroda_kartinki_foto_05.jpg"),
                callable("D:/images/priroda_kartinki_foto_01.jpg"),
                callable("D:/images/priroda_05.jpg"),
                callable("D:/images/priroda_01.jpg"),
                callable("D:/images/plitvickiye-ozera-1.jpg"),
                callable("D:/images/maxresdefault-10.jpg"),
                callable("D:/images/maxresdefault-1-4.jpg"));

        long t = System.currentTimeMillis();

        executor.invokeAll(callables);
        executor.shutdown();

        System.out.println("Время выполнения программы(localDrive): " + (System.currentTimeMillis()-t) + " мс");

    }

    static Callable<Void> callable(String path)
    {
        return () -> {
            File file = new File(path);
            BufferedImage image;
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
            return null;
        };
    }
}