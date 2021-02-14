package main;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Устанавливаем нужные нам размеры массива для подсчета времени
        int[] n = new int[]{150,1500,3000,4500,6000,7500,9000,10500,12000};

        for (int size : n) {
            int bytes = size * size * 4 / 1024;

            System.out.println("Вариант №1:\nРазмер массива = " + size + "\nЗатраченное время = " + VarOne(size) + " мс\n");
            System.out.println("Вариант №2:\nРазмер массива = " + size + "\nЗатраченное время = " + VarTwo(size) + " мс\n");
            System.out.println("Вариант №3:\nРазмер массива = " + size + "\nЗатраченное время = " + VarThree(size) + " мс\n");
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

    public static long VarOne(int size)
    {
        double array[] = new double[size];
        long t=System.currentTimeMillis();

        for (int i=0;i<size;i++)
            array[i]=i;
        double sum=0;

        for (int i=0;i<size;i++)
            sum+=array[i];

        return System.currentTimeMillis()-t;
    }

    public static long VarTwo(int size)
    {
        LinkedList<Double> linked_list = new LinkedList<Double>();
        long t=System.currentTimeMillis();

        for (int i=0;i<size;i++)
            linked_list.add(new Double(i));
        double sum=0;

        for (int i=0;i<size;i++)
            sum+=linked_list.get(i);

        return System.currentTimeMillis()-t;
    }

    public static long VarThree(int size)
    {
        ArrayList<Double> array_list = new ArrayList<Double>(size);
        long t=System.currentTimeMillis();

        for (int i=0;i<size;i++)
            array_list.add(new Double(i));
        double sum=0;

        for (int i=0;i<size;i++)
            sum+=array_list.get(i);
        return System.currentTimeMillis()-t;
    }

}
