import java.util.Scanner;

public class SudokuGame {
    private SudokuBoard board;

    public SudokuGame(String[] args) {
        board = new SudokuBoard();
        board.loadFromArguments(args);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!board.isComplete()) {
            board.display();
            System.out.print("Digite linha (0-8), coluna (0-8) e valor (1-9): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int val = scanner.nextInt();

            if (!board.setCellValue(row, col, val)) {
                System.out.println("Movimento inválido!");
            }
        }

        board.display();
        System.out.println("Parabéns, você completou o Sudoku!");
    }
}
