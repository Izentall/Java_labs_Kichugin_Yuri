package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Main {
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

    public static void main(String[] args)
    {
        Vector<Integer> vector = new Vector<>();
        readVector(vector,args);
        System.out.println("Input array:");
        printVector(vector);
        Set<Integer> set = new HashSet<>(vector);
        System.out.print("Count of unique elements in array: ");
        System.out.println(set.size());
    }
}
