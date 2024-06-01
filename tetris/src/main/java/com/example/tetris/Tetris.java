package com.example.tetris;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tetris")
public class Tetris extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Board board;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        board = new Board(10, 20); // Standard Tetris board size
        mapper = new ObjectMapper();
        
        // Example of placing a piece
        Piece piece = new Piece(0); // I piece
        if (board.canMove(piece, 3, 0)) {
            board.placePiece(piece, 3, 0);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getPathInfo() != null && request.getPathInfo().equals("/board")) {
            response.setContentType("application/json");
            response.getWriter().write(mapper.writeValueAsString(board.getBoard()));
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body><h1>Tetris Game</h1><canvas id='tetrisCanvas' width='300' height='600'></canvas><script src='tetris.js'></script></body></html>");
        }
    }
}
