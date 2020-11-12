package com.company;

import java.util.Scanner;
import java.util.Vector;

class Matrix
{
    private Vector<Integer> vector_;
    private int lines_;
    private int columns_;

    Matrix(int lines, int columns)
    {
        if (lines < 1 || columns < 1)
        {
            throw new IllegalArgumentException("Lines and columns mist be positive");
        }
        vector_ = new Vector<>(lines * columns);
        for (int i = 0; i < vector_.capacity(); ++i)
        {
            vector_.add(0);
        }
        lines_ = lines;
        columns_ = columns;
    }

    Matrix(int lines, int columns, Vector<Integer> vector)
    {
        if (lines < 1 || columns < 1)
        {
            throw new IllegalArgumentException("Lines and columns mist be positive");
        }
        if (lines * columns != vector.size())
        {
            throw new IllegalArgumentException("Number of lines and columns is not equal with vector's ones");
        }
        vector_ = new Vector<>(vector);
        lines_ = lines;
        columns_ = columns;
    }

    int getLines()
    {
        return lines_;
    }

    int getColumns()
    {
        return columns_;
    }

    Integer elementAt(int line, int column)
    {
        if (line < 0 || line >= lines_ || column < 0 || column >= columns_)
        {
            throw new IllegalArgumentException("Out of matrix range");
        }
        return vector_.elementAt(line * columns_ + column);
    }

    void setElementAt(Integer element, int line, int column)
    {
        if (line < 0 || line >= lines_ || column < 0 || column >= columns_)
        {
            throw new IllegalArgumentException("Out of matrix range");
        }
        vector_.setElementAt(element, line * columns_ + column);
    }

    void removeLine(int line)
    {
        if (line < 0 || line >= lines_)
        {
            throw new IllegalArgumentException("Ont of matrix range");
        }
        for (int i = 0; i < columns_; ++i)
        {
            vector_.remove(line * columns_);
        }
        --lines_;
    }

    void print()
    {
        for (int i = 0; i < lines_; ++i)
        {
            for (int j = 0; j < columns_; ++j)
            {
                System.out.print(elementAt(i, j));
                System.out.print('\t');
            }
            System.out.print('\n');
        }
    }
}

public class Main {
    public static Vector<Integer> getMinElemIndexLine(Matrix matrix)
    {
        Vector<Integer> vector = new Vector<>(matrix.getLines());
        for (int i = 0; i < matrix.getLines(); ++i)
        {
            int max = matrix.elementAt(i, 0);
            for (int j = 1; j < matrix.getColumns(); ++j)
            {
                if (matrix.elementAt(i, j) > max)
                {
                    max = matrix.elementAt(i, j);
                }
            }
            vector.add(max);
        }
        return vector;
    }

    public static int getMinIndex(Vector<Integer> vector)
    {
        int index = 0;
        Integer min = vector.elementAt(0);
        for (int i = 0; i < vector.size(); ++i)
        {
            if (vector.elementAt(i) < min)
            {
                index = i;
                min = vector.elementAt(i);
            }
        }
        return index;
    }

    public static void main(String[] args) {
	try
    {
        if (args.length != 2)
        {
            throw new IllegalArgumentException("Illegal number of arguments");
        }
        int lines = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        Vector<Integer> vector = new Vector<>(lines * columns);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < vector.capacity(); ++i)
        {
            vector.add(scanner.nextInt());
        }
        Matrix matrix = new Matrix(lines, columns, vector);
        System.out.println("Input matrix:");
        matrix.print();
        vector = getMinElemIndexLine(matrix);
        int line = getMinIndex(vector);
        matrix.removeLine(line);
        System.out.println("Changed matrix:");
        matrix.print();
    }
	catch (Exception exception)
    {
        System.out.println(exception.getMessage());
        System.exit(1);
    }
    }
}
