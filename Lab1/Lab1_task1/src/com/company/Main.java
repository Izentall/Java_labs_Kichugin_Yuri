package com.company;

import java.util.Vector;

public class Main
{
    private  static void readVector(Vector<Integer> vector, String[] elements)
    {
        for (int i = 0; i < elements.length; ++i)
        {
            vector.add(Integer.parseInt(elements[i]));
        }
    }

    private static  void printVector(Vector<Integer> vector)
    {
        for(int i = 0; i < vector.size(); ++i)
        {
            System.out.print(vector.elementAt(i));
            System.out.print(' ');
        }
        System.out.print('\n');
    }

    public static void shellSort(Vector<Integer> vector)
    {
        int d = vector.size() / 2;
        while (d > 0)
        {
            for (int i = 0; i < vector.size() - d; i++)
            {
                int j = i;
                while (j>=0 && vector.elementAt(j) > vector.elementAt(j + d))
                {
                    Integer temp = vector.elementAt(j);
                    vector.set(j, vector.elementAt(j + d));
                    vector.set(j + d, temp);
                    j--;
                }
            }
            d = d / 2;
        }
    }

    public static void main(String[] args)
    {
        Vector<Integer> vector = new Vector<>();
        readVector(vector, args);
        System.out.println("Unsorted array:");
        printVector(vector);
        shellSort(vector);
        System.out.println("Sorted array:");
        printVector(vector);
    }
}
