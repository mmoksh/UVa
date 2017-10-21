import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T;
        char[][] matrix;
        boolean[][] visited;
        int sum;
        int count = 1;
        while (input.hasNext()) {
            T = input.nextInt();
            input.nextLine();
            matrix = new char[T][];
            for (int i = 0; i < T; i++) {
                matrix[i] = input.nextLine().toCharArray();
            }
            visited = new boolean[matrix.length][matrix[0].length];
            sum = 0;
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    sum += calc(matrix, i, j, visited);
                }
            }
            System.out.printf("Image number %d contains %d war eagles.\n", count++, sum);
        }
    }

    public static int calc(char[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] == '0') {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        calc(matrix, i, j + 1, visited);
        calc(matrix, i, j - 1, visited);
        calc(matrix, i + 1, j, visited);
        calc(matrix, i - 1, j, visited);
        calc(matrix, i - 1, j + 1, visited);
        calc(matrix, i - 1, j - 1, visited);
        calc(matrix, i + 1, j + 1, visited);
        calc(matrix, i + 1, j - 1, visited);
        return 1;
    }
}
