package com.company;

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

public class Main
{
    public static void fillMatrix(Matrix matrix)
    {
        for (int i = 0; i < matrix.getLines(); ++i)
        {
            matrix.setElementAt(i + 1, i, 0);
            for (int j = 1; j < matrix.getColumns(); ++j)
            {
                matrix.setElementAt(0, i, j);
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {
            if (args.length != 2)
            {
                throw new IllegalArgumentException("Illegal number of arguments");
            }
            int lines = Integer.parseInt(args[0]);
            int columns = Integer.parseInt(args[1]);
            System.out.print("Lines in matrix: ");
            System.out.println(lines);
            System.out.print("Columns in matrix");
            System.out.println(columns);
            Matrix matrix = new Matrix(lines, columns);
            fillMatrix(matrix);
            matrix.print();
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
            System.exit(1);
        }
    }
}
