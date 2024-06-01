package com.example.tetris;

public class Piece {
    private final int id;
    private final int[][] shape;

    public static final int[][][] SHAPES = {
        {{1, 1, 1, 1}}, // I piece
        {{1, 1}, {1, 1}}, // O piece
        {{1, 1, 1}, {0, 1, 0}}, // T piece
        {{1, 1, 0}, {0, 1, 1}}, // Z piece
        {{0, 1, 1}, {1, 1, 0}}  // S piece
    };

    public Piece(int id) {
        this.id = id;
        this.shape = SHAPES[id];
    }

    public int getId() {
        return id;
    }

    public int[][] getShape() {
        return shape;
    }

    public Piece rotate() {
        int n = shape.length;
        int[][] rotatedShape = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedShape[i][j] = shape[n - j - 1][i];
            }
        }
        return new Piece(id); // Fix this to match the constructor
    }
}
