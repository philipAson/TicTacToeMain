import java.util.Scanner;

public class GameBoard {

    // char 2D array that defines
    private char [][] gameBoard = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}};
    // method for printing the gameBoard and its content in a visually appealing way
    void printGameBoard() {
        System.out.println(
                " "+gameBoard[0][0]+" | "+gameBoard[0][1]+" | "+gameBoard[0][2]+" \n" +
                "---+---+---\n" +
                " "+gameBoard[1][0]+" | "+gameBoard[1][1]+" | "+gameBoard[1][2]+" \n" +
                "---+---+---\n" +
                " "+gameBoard[2][0]+" | "+gameBoard[2][1]+" | "+gameBoard[2][2]+" ");
    }

    void placePiece(String player, int pos) {

        char symbol = ' ';

        if (player.equals("Player1")) {
            symbol = 'X';
        } else if (player.equals("Player2")) {
            symbol = 'O';
        }


        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][1] = symbol;
                break;
            case 3:
                gameBoard[0][2] = symbol;
                break;
            case 4:
                gameBoard[1][0] = symbol;
                break;
            case 5:
                gameBoard[1][1] = symbol;
                break;
            case 6:
                gameBoard[1][2] = symbol;
                break;
            case 7:
                gameBoard[2][0] = symbol;
                break;
            case 8:
                gameBoard[2][1] = symbol;
                break;
            case 9:
                gameBoard[2][2] = symbol;
                break;
            default:
                break;
               // System.out.println("Not a valid position!");
        }
    }


    boolean checkWin() {
        return true;
    }
}

