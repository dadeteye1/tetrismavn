package com.example.tetris;

import java.util.Arrays;

public class Board {
    private final int width;
    private final int height;
    private final int[][] board;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[height][width];
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }
    }

    public boolean canMove(Piece piece, int x, int y) {
        for (int[] block : piece.getShape()) {
            int newX = x + block[0];
            int newY = y + block[1];
            if (newX < 0 || newX >= width || newY < 0 || newY >= height || board[newY][newX] != 0) {
                return false;
            }
        }
        return true;
    }

    public void placePiece(Piece piece, int x, int y) {
        for (int[] block : piece.getShape()) {
            int newX = x + block[0];
            int newY = y + block[1];
            board[newY][newX] = piece.getId() + 1;
        }
    }

    public void clearLines() {
        for (int y = 0; y < height; y++) {
            boolean fullLine = true;
            for (int x = 0; x < width; x++) {
                if (board[y][x] == 0) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                for (int i = y; i > 0; i--) {
                    board[i] = Arrays.copyOf(board[i - 1], width);
                }
                Arrays.fill(board[0], 0);
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
}
