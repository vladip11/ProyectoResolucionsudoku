/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoresolucionsudoku;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CAB COMPUTERS
 */
public class SudokuTest {

    private final int[][] tablero = {
        {0, 7, 2, 0, 0, 4, 9, 0, 0},
        {3, 0, 4, 0, 8, 9, 1, 0, 0},
        {8, 1, 9, 0, 0, 6, 2, 5, 4},
        {7, 0, 1, 0, 0, 0, 0, 9, 5},
        {9, 0, 0, 0, 0, 2, 0, 7, 0},
        {0, 0, 0, 8, 0, 7, 0, 1, 2},
        {4, 0, 5, 0, 0, 1, 6, 2, 0},
        {2, 3, 7, 0, 0, 0, 5, 0, 1},
        {0, 0, 0, 0, 2, 5, 7, 0, 0}
    };

    Sudoku sudoku = new Sudoku(tablero);

    @Test
    public void testContieneNumero() {
        assertTrue(sudoku.contieneNumeroCaja(0, 1, 7));
        assertTrue(sudoku.contieneNumeroFila(0, 7));
        assertTrue(sudoku.contieneNumeroFila(1, 3));
        assertTrue(sudoku.contieneNumeroFila(2, 9));
        assertTrue(sudoku.contieneNumeroFila(3, 0));
        assertTrue(sudoku.contieneNumeroCol(0, 8));
        assertTrue(sudoku.contieneNumeroCol(1, 1));
        assertTrue(sudoku.contieneNumeroCol(2, 4));
        assertTrue(sudoku.contieneNumeroCol(3, 0));
    }

    @Test
    public void testSolveSudoku() {
        assertTrue(sudoku.solveSudoku());
    }

    @Test
    public void testDisplaySudoku() {
        String result = " 0  7  2  |  0  0  4  |  9  0  0 \n"
                + " 3  0  4  |  0  8  9  |  1  0  0 \n"
                + " 8  1  9  |  0  0  6  |  2  5  4 \n"
                + "----------------------------------\n"
                + " 7  0  1  |  0  0  0  |  0  9  5 \n"
                + " 9  0  0  |  0  0  2  |  0  7  0 \n"
                + " 0  0  0  |  8  0  7  |  0  1  2 \n"
                + "----------------------------------\n"
                + " 4  0  5  |  0  0  1  |  6  2  0 \n"
                + " 2  3  7  |  0  0  0  |  5  0  1 \n"
                + " 0  0  0  |  0  2  5  |  7  0  0 \n"
                + "__________________________________________";

        String comp = sudoku.displaySudoku();
        assertEquals(comp, result);
    }

    @Test
    public void testVerfificarSolucion() {

        int[][] t = {
            {0, 7, 2, 0, 0, 4, 9, 0, 0},
            {3, 0, 4, 0, 8, 9, 1, 0, 0},
            {8, 1, 9, 0, 0, 6, 2, 5, 4},
            {7, 0, 1, 0, 0, 0, 0, 9, 5},
            {9, 0, 0, 0, 0, 2, 0, 7, 0},
            {0, 0, 0, 8, 0, 7, 0, 1, 2},
            {4, 0, 5, 0, 0, 1, 6, 2, 0},
            {2, 3, 7, 0, 0, 0, 5, 0, 1},
            {0, 0, 0, 0, 2, 5, 7, 0, 0}
        };
        Sudoku s =new Sudoku(t);
        s.solveSudoku();
        String c=s.displaySudoku();
        String r = " 6  7  2  |  1  5  4  |  9  3  8 \n"
                + " 3  5  4  |  2  8  9  |  1  6  7 \n"
                + " 8  1  9  |  3  7  6  |  2  5  4 \n"
                + "----------------------------------\n"
                + " 7  2  1  |  6  4  3  |  8  9  5 \n"
                + " 9  4  8  |  5  1  2  |  3  7  6 \n"
                + " 5  6  3  |  8  9  7  |  4  1  2 \n"
                + "----------------------------------\n"
                + " 4  8  5  |  7  3  1  |  6  2  9 \n"
                + " 2  3  7  |  9  6  8  |  5  4  1 \n"
                + " 1  9  6  |  4  2  5  |  7  8  3 \n"
                + "__________________________________________";
        assertEquals(c, r);
    }

    @Test
    public void mainTest() {
        main m = new main();
        String[] args = {};
        main.main(args);
    }
}
