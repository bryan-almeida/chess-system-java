package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.printf("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                System.out.println();
                System.out.printf("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException exception){
                System.out.println(exception.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
            }


        }

    }
}
