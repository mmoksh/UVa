import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        String line;
        input.nextLine();
        input.nextLine();
        ArrayList<String> list;
        int [][] matrix;
        boolean [][] visited;
        int max;
        for (int t = 0; t < T; t++) {
            list = new ArrayList<>();
            while (input.hasNext()) {
                line = input.nextLine();
                if ("".equals(line)) {
                    break;
                }
                list.add(line);
            }
            matrix = new int[list.size()][list.get(0).length()];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = list.get(i).charAt(j) - '0';
                }
            }
            visited = new boolean[matrix.length][matrix[0].length];
            max = 0;
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++) {
                    max = Math.max(max, calc(matrix, i, j, visited));
                }
            }
            System.out.println(max);
            if (input.hasNext()) {
                System.out.println();
            }
        }
    }
    
    public static int calc (int [][] matrix, int i, int j, boolean [][] visited) {
        if (i < 0 || j < 0) 
            return 0;
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;
        if (matrix[i][j] == 0)
            return 0;
        if (visited[i][j])
            return 0;
        visited[i][j] = true;
        return 1
                + calc(matrix, i, j + 1, visited)
                + calc(matrix, i, j - 1, visited)
                + calc(matrix, i + 1, j, visited)
                + calc(matrix, i - 1, j, visited)
                + calc(matrix, i - 1, j + 1, visited)
                + calc(matrix, i - 1, j - 1, visited)
                + calc(matrix, i + 1, j + 1, visited)
                + calc(matrix, i + 1, j - 1, visited);
    }
}
