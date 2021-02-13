package main;

public class Main {

    public static void main(String[] args) {

        // Устанавливаем нужные нам размеры массива для подсчета времени
        int[] n = new int[]{150,1500,3000,4500,6000,7500,9000,10500,12000};

        for (int size : n) {
            int bytes = size * size * 4 / 1024;

            System.out.println("Заполнение по строкам(int):\nРазмер массива = " + size + "\nРазмер в памяти = " + bytes + " kb\nЗатраченное время = " + fillByRowsInt(size) + " мс\n");
            System.out.println("Заполнение по столбцам(int):\nРазмер массива = " + size + "\nРазмер в памяти = " + bytes + " kb\nЗатраченное время = " + fillByColumnsInt(size) + " мс\n");
            System.out.println("Заполнение по строкам(float):\nРазмер массива = " + size + "\nРазмер в памяти = " + bytes + " kb\nЗатраченное время = " + fillByRowsFloat(size) + " мс\n");
            System.out.println("Заполнение по столбцам(float):\nРазмер массива = " + size + "\nРазмер в памяти = " + bytes + " kb\nЗатраченное время = " + fillByColumnsFloat(size) + " мс\n");
        }
    }

    // Распределение данных по строкам для типа данных int
    public static long fillByRowsInt(int size)
    {
        int[][] a=new int[size][size];
        long t=System.currentTimeMillis();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                a[i][j]=i*j;
            }
        }
        return System.currentTimeMillis()-t;
    }

    // Распределение данных по столбцам для типа данных int
    public static long fillByColumnsInt(int size)
    {
        int[][] a=new int[size][size];
        long t=System.currentTimeMillis();

        int bytes=size*size*4/1024;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                a[j][i] = i * j;
            }
        }
        return System.currentTimeMillis()-t;
    }

    // Распределение данных по строкам для типа данных float
    public static long fillByRowsFloat(int size)
    {
        float[][] a=new float[size][size];
        long t=System.currentTimeMillis();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                a[i][j]=i*j;
            }
        }
        return System.currentTimeMillis()-t;
    }

    // Распределение данных по столбцам для типа данных float
    public static long fillByColumnsFloat(int size)
    {
        float[][] a=new float[size][size];
        long t=System.currentTimeMillis();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                a[j][i] = i * j;
            }
        }
        return System.currentTimeMillis()-t;
    }
}
