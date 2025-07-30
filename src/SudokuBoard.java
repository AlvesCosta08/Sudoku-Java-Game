public class SudokuBoard {
    private SudokuCell[][] board;

    public SudokuBoard() {
        board = new SudokuCell[9][9];
        initEmptyBoard();
    }

    private void initEmptyBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = new SudokuCell(row, col, 0, false);
            }
        }
    }

public void loadFromArguments(String[] args) {
    if (args.length == 0) {
        System.out.println("Nenhum argumento recebido.");
        return;
    }

        // Une todos os args numa string só (para garantir que mesmo se o terminal quebrou as aspas)
        String allArgs = String.join(" ", args);


        String[] entradas = allArgs.trim().split(" (?=\\d+,\\d+;\\d+,(true|false))");

        for (String entrada : entradas) {
            System.out.println("Processando entrada: [" + entrada + "]"); /
            try {
                String[] pos_val = entrada.split(";");
                if (pos_val.length != 2) {
                    System.out.println("Formato inválido: " + entrada);
                    continue;
                }

                String[] pos = pos_val[0].split(",");
                String[] val = pos_val[1].split(",");

                if (pos.length != 2 || val.length != 2) {
                    System.out.println("Formato inválido: " + entrada);
                    continue;
                }

                int col = Integer.parseInt(pos[0]);
                int row = Integer.parseInt(pos[1]);
                int value = Integer.parseInt(val[0]);
                boolean fixed = Boolean.parseBoolean(val[1]);

                board[row][col] = new SudokuCell(row, col, value, fixed);
            } catch (Exception e) {
                System.out.println("Erro ao interpretar entrada: " + entrada);
                e.printStackTrace();
            }
        }
    }




    public void display() {
        System.out.println("Sudoku:");
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) System.out.println("-------------------------");
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) System.out.print("| ");
                int val = board[row][col].getValue();
                System.out.print(val == 0 ? ". " : val + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }

    public boolean isValidMove(int row, int col, int value) {
        // verifica linha
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getValue() == value) return false;
        }

        // verifica coluna
        for (int i = 0; i < 9; i++) {
            if (board[i][col].getValue() == value) return false;
        }

        // verifica 3x3
        int boxRow = row / 3 * 3;
        int boxCol = col / 3 * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j].getValue() == value) return false;
            }
        }

        return true;
    }

    public boolean setCellValue(int row, int col, int value) {
        if (!board[row][col].isFixed() && isValidMove(row, col, value)) {
            board[row][col].setValue(value);
            return true;
        }
        return false;
    }

    public boolean isComplete() {
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 9; col++)
                if (board[row][col].getValue() == 0)
                    return false;
        return true;
    }
}
