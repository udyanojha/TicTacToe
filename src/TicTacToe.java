import java.util.Scanner;

public class TicTacToe {
    Scanner s = new Scanner(System.in);
    String[] players = new String[2];
    char[][] board = new char[3][3];

    void inputPlayerNames() {
        System.out.println("Enter Player 1 name : ");
        this.players[0] = s.next();
        System.out.println("Enter Player 2 name : ");
        this.players[1] = s.next();
    }

    boolean checkValidIfWinner(int row, int col, int currentPLayer, int turns) {
        if(row<0||row>3||col<0||col>3||board[row][col]!=0) {
            System.out.println("Please enter in valid range: ");
            return false;
        }
        char xOrO = (currentPLayer==1)?'X':'O';
        board[row][col] = xOrO;
        if(turns>=5) {
            // TODO check winner here
            boolean winner = checkWinner(xOrO, row, col);
            if(winner) {

            }

        }
        return true;
    }
    boolean checkWinner(char xOrO, int row, int col) {
        // horizontal
        boolean winner = true;
        for(int j = 0; j<3; j++) {
            if(board[row][j]!=xOrO) {
                winner = false;
                break;
            }
        }
        if(winner) return true;

        for(int i = 0; i<3; i++) {
            if(board[i][col]!=xOrO) {
                winner = false;
                break;
            }
        }
        if(winner) return true;

        return false;
    }
    void printBoard() {
        System.out.println("__________");
        System.out.println("|"+board[0][0]+"| |"+board[0][1]+"| |"+board[0][2]+"|");
        System.out.println("|"+board[1][0]+"| |"+board[1][1]+"| |"+board[1][2]+"|");
        System.out.println("|"+board[2][0]+"| |"+board[2][1]+"| |"+board[2][2]+"|");
        System.out.println("__________");
    }

    void play() {
        inputPlayerNames();
//        boolean result = false;
        int currentPlayer = 1;
        int turns = 1;
        while(turns<=9) {
            String currentPlayerName;
            if(currentPlayer==1) {
                currentPlayerName = players[0];
            } else {
                currentPlayerName = players[1];
            }
            System.out.println("Enter cell no "+currentPlayerName+" ");
            int row = s.nextInt();
            int col = s.nextInt();

            while(turns<10&&!checkValidIfWinner(row, col, currentPlayer, turns)) {
                row = s.nextInt();
                col = s.nextInt();
            }

            // TODO Print board
            printBoard();
            turns++;
            currentPlayer = currentPlayer%2+1;

        }
    }

}
