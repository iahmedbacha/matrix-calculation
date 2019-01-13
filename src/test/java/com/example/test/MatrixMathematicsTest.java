package com.example.test;

import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixMathematicsTest {

    double delta = 0.00000001;

    @Test
    public void transpose() {
        double[][] dat = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix matrix = new Matrix(dat);
        double[][] expected = {{1,4,7},{2,5,8},{3,6,9}};
        assertTrue(Arrays.deepEquals(MatrixMathematics.transpose(matrix).getValues(),expected));
    }

    @Test
    public void inverse() throws NoSquareException {
        double[][] dat = {{1,0,0},{0,0,1},{1,1,0}};
        Matrix matrix = new Matrix(dat);
        double[][] expected = {{1,0,0},{-1,0,1},{0,1,0}};
        double[][] inverse = MatrixMathematics.inverse(matrix).getValues();
        for (int i = 0; i < matrix.getNrows(); i++) {
            for (int j = 0; j < matrix.getNcols(); j++) {
                assertEquals(inverse[i][j],expected[i][j],delta);
            }
        }
    }

    @Test
    public void determinant() throws NoSquareException {
        double[][] dat = {{1,0,0},{0,0,1},{0,1,0}};
        Matrix matrix = new Matrix(dat);
        double expected = -1;
        assertEquals(MatrixMathematics.determinant(matrix),expected,delta);
    }

    @Test
    public void createSubMatrix() {
        double[][] dat = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix matrix = new Matrix(dat);
        double[][] expected = {{1,3},{7,9}};
        assertTrue(Arrays.deepEquals(MatrixMathematics.createSubMatrix(matrix,1,1).getValues(),expected));
    }

    @Test
    public void cofactor() throws NoSquareException {
        double[][] dat = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix matrix = new Matrix(dat);
        double[][] expected = {{-3,6,-3},{6,-12,6},{-3,6,-3}};
        assertTrue(Arrays.deepEquals(MatrixMathematics.cofactor(matrix).getValues(),expected));
    }
}