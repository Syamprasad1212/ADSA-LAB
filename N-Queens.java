import java.util.*;

class NQueens {

    int N;
    int board[][];

    NQueens(int N) {

        this.N = N;
        board = new int[N][N];
        // Create NxN chessboard initialized with 0
    }

    boolean isSafe(int row, int col) {
        // Check whether queen can be placed at board[row][col]

        // Check column
        for (int i = 0; i < row; i++) {

            if (board[i][col] == 1)
                return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < N; i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
        // Safe position
    }

    boolean solveNQueens(int row) {
        // Recursive function to place queens row by row

        if (row == N)
            // All queens placed successfully
            return true;

        for (int col = 0; col < N; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;
                // Place queen

                if (solveNQueens(row + 1))
                    return true;
                // Recur for next row

                board[row][col] = 0;
                // Backtrack if placement fails
            }
        }

        return false;
    }

    void printSolution() {

        System.out.println("Solution Matrix:");

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of queens: ");
        int N = sc.nextInt();

        NQueens obj = new NQueens(N);

        if (obj.solveNQueens(0)) {

            System.out.println("\nSolution exists:\n");
            obj.printSolution();

        } else {

            System.out.println("\nNo solution exists.");
        }
    }
}
