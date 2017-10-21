import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        char[] arr;
        Character[] arr2;
        boolean[] taken;
        StringBuilder sb;
        String line;
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            line = input.nextLine();
            arr = line.toCharArray();
            arr2 = new Character[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            taken = new boolean[arr.length];
            Arrays.sort(arr2, new Compare());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr2[i];
            }
            findCombinations(arr, new char[arr.length], 0, taken, sb);
        }
        System.out.print(sb.toString());
    }

    private static void findCombinations(char[] arr, char[] temp, int i, boolean[] taken, StringBuilder sb) {
        if (i == arr.length) {
            sb.append(String.valueOf(temp));
            sb.append("\n");
        }
        for (int j = 0; j < arr.length; j++) {
            if (!taken[j]) {
                if ((j > 0 && arr[j - 1] == arr[j] && !taken[j - 1])) {
                    continue;
                }
                taken[j] = true;
                temp[i] = arr[j];
                findCombinations(arr, temp, i + 1, taken, sb);
                taken[j] = false;
            }
        }
    }
}

class Compare implements Comparator<Character> {

    @Override
    public int compare(Character o1, Character o2) {
        if (Character.toLowerCase(o1) == Character.toLowerCase(o2)) {
            return o1 - o2;
        }
        return Character.toLowerCase(o1) - Character.toLowerCase(o2);
    }

}
