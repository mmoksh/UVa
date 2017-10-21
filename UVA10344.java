import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr;
        boolean breakk;
        while (true) {
            breakk = true;
            arr = new int[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = input.nextInt();
                if (arr[i] > 0) {
                    breakk = false;
                }
            }
            if (breakk) {
                break;
            }
            if (calc(arr, new boolean[5], new int[5], 0))
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
    }

    public static boolean calc(int[] arr, boolean[] visited, int[] temp, int i) {
        if (i == 5) {
            return check(temp, 1, temp[0]);
        }
        for (int j = 0; j < 5; j++) {
            if (!visited[j]) {
                visited[j] = true;
                temp[i] = arr[j];
                if (calc(arr, visited, temp, i + 1))
                    return true;
                visited[j] = false;
            }
        }
        return false;
    }

    public static boolean check(int[] temp, int n, int res) {
        if (n == 5) {
            return res == 23;
        } else {
            return check(temp, n + 1, res + temp[n])
                    || check(temp, n + 1, res - temp[n])
                    || check(temp, n + 1, res * temp[n]);
        }
    }
}
