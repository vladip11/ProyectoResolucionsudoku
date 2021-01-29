/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoresolucionsudoku;

import static java.lang.Math.sqrt;

/**
 *
 * @author CAB COMPUTERS
 */
public class Sudoku {
    private int[][] sudoku;
    private static final int UNASSIGNED = 0;
    
    public Sudoku(int[][] tablero) {
        this.sudoku = tablero;
    }

    boolean contieneNumeroCaja(int fila,int col,int num) {
        int p = (int)sqrt(sudoku.length);
        int r = fila - fila % p;
        int c = col - col % p;
        for (int i = r; i < r + p; i++) {
            for (int j = c; j < c + p; j++) {
                if (sudoku[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contieneNumeroFila(int fila, int num) {
        int p = sudoku.length;
        for (int i = 0; i < p; i++) {
            if (sudoku[fila][i] == num) {
                return true;
            }
        }
        return false;
    }

    boolean contieneNumeroCol(int col, int num) {
        int p = sudoku.length;
        for (int i = 0; i < p; i++) {
            if (sudoku[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean solveSudoku() {
        int p = sudoku.length;
        for (int row = 0; row < p; row++) {
            for (int col = 0; col < p; col++) {
                if (sudoku[row][col] == UNASSIGNED) {
                    for (int number = 1; number <= p; number++) {
                        if (isAllowed(row, col, number)) {
                            sudoku[row][col] = number;
                            if (solveSudoku()) {
                                return true;
                            } else {
                                sudoku[row][col] = UNASSIGNED;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isAllowed(int row, int col, int number) {
        return !(contieneNumeroFila(row, number) || contieneNumeroCol(col, number) || contieneNumeroCaja(row, col, number));
    }
    
    public String displaySudoku() {
        String r="";
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                r+="----------------------------------\n";
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    r+=" | ";
                }
                r+=" " + sudoku[i][j] + " ";
            }
            r+="\n";
        }
        r+="__________________________________________";
    return r;
    }
    
    
}
