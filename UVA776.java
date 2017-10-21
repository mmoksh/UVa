import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;
        String [] arr = null;
        char [][] matrix, m;
        int [][] output;
        int index;
        StringBuilder sb;
        while (input.hasNext()) {
            sb = new StringBuilder();
            matrix = new char[1000][1000];
            index = 0;
            while (input.hasNext()) {
                line = input.nextLine();
                if (line.equals("%")) {
                    break;
                }
                arr = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    matrix[index][i] = arr[i].charAt(0);
                }
                index++;
            }
            m = new char[index][arr.length];
            output = new int[index][arr.length];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] = matrix[i][j];
                }
            }
            int spec = 1;
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    if (calc(m, i, j, output, matrix[i][j], spec))
                        spec++;
                }
            }
            int [] size = new int[m[0].length];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    int count = countDigits(output[i][j]);
                    if (count > size[j])
                        size[j] = count;
                }
            }
            for (int i = 0; i < m.length; i++) {
                sb.append(String.format("%" + (size[0] - 1) + "d", output[i][0]));
                for (int j = 1; j < m[0].length; j++) {
                    sb.append(String.format("%" + size[j] + "d", output[i][j]));
                }
                sb.append("\n");
            }
            sb.append("%");
            System.out.println(sb.toString());
        }
    }
    
    public static int countDigits (int n) {
        int count = 1;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
    
    public static boolean calc (char [][] m, int i, int j, int [][] output, char c, int num) {
        if (i < 0 || j < 0)
            return false;
        if (i >= m.length || j >= m[0].length)
            return false;
        if (output[i][j] != 0)
            return false;
        if (m[i][j] != c)
            return false;
        output[i][j] = num;
        calc(m, i + 1, j, output, c, num);
        calc(m, i - 1, j, output, c, num);
        calc(m, i, j + 1, output, c, num);
        calc(m, i, j - 1, output, c, num);
        calc(m, i + 1, j + 1, output, c, num);
        calc(m, i + 1, j - 1, output, c, num);
        calc(m, i - 1, j + 1, output, c, num);
        calc(m, i - 1, j - 1, output, c, num);
        return true;
    }
}
