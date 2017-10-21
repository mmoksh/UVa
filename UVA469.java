import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        input.nextLine();
        String line = null;
        ArrayList<String> list;
        char [][] matrix;
        boolean [][] visited;
        int a, b;
        String [] temp;
        int max;
        for (int t = 0; t < T; t++) {
            list = new ArrayList<>();
            while (input.hasNext()) {
                line = input.nextLine();
                if (line.contains(" ")) {
                    break;
                }
                list.add(line);
            }
            matrix = new char[list.size()][list.get(0).length()];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = list.get(i).charAt(j);
                }
            }
            do {
                visited = new boolean[matrix.length][matrix[0].length];
                temp = line.split(" ");
                a = Integer.parseInt(temp[0]);
                b = Integer.parseInt(temp[1]);
                System.out.println(calc(matrix, a - 1, b - 1, visited));
                if (!input.hasNext())
                    break;
                line = input.nextLine();
            } while (!line.equals(""));
            if (input.hasNext()) {
                System.out.println();
            }
        }
    }
    
    public static int calc (char [][] matrix, int i, int j, boolean [][] visited) {
        if (i < 0 || j < 0) 
            return 0;
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;
        if (matrix[i][j] == 'L')
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
