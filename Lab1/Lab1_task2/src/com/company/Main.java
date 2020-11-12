package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class Main {
    private static void readVector(Vector<Integer> vector, String[] elements)
    {
        for (int i = 0; i < elements.length; ++i)
        {
            vector.add(Integer.parseInt(elements[i]));
        }
    }

    public static boolean checkVector(Vector<Integer> vector)
    {
        Set<Integer> set = new HashSet<>(vector);
        return (vector.size() == set.size());
    }

    public static void randomReplace(Vector<Integer> vector)
    {
        Random random = new Random();
        for (int i = vector.size() - 1; i > 0; --i)
        {
            int index = random.nextInt(i);
            Integer temp = vector.elementAt(i);
            vector.set(i, vector.elementAt(index));
            vector.set(index, temp);
        }
    }

    private static void printVector(Vector<Integer> vector)
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
        try
        {
            Vector<Integer> vector = new Vector<>();
            readVector(vector, args);
            System.out.println("Input array:");
            printVector(vector);
            if (!checkVector(vector))
            {
                throw new IllegalArgumentException("Array contains repeatable elements");
            }
            randomReplace(vector);
            System.out.println("Output array:");
            printVector(vector);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
            System.exit(1);
        }
    }
}
