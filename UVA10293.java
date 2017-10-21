import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;
        String [] arr;
        StringBuilder sb;
        int [] count;
        while (input.hasNext()) {
            count = new int[31];
            sb = new StringBuilder(1000);
            while (true) {
                line = input.nextLine();
                if (line.startsWith("#"))
                    break;
                else {
                    sb.append(line);
                    sb.append(" ");
                }
            }
            line = sb.toString().trim().replaceAll("- ", "").replaceAll("'", "").replaceAll("-", "")
                    .replaceAll("[?!,.]", " ");
            arr = line.split(" ");
            for (String string : arr) {
                count[string.length()]++;
            }
            for (int i = 1; i < 31; i++) {
                if (count[i] > 0) {
                    System.out.printf("%d %d\n", i, count[i]);
                }
            }
            System.out.println();
        }
    }   
}
