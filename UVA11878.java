import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;
        int a, b, c;
        String res;
        int count = 0;
        int ind, ind2;
        while (input.hasNext()) {
            line = input.nextLine();
            ind = line.indexOf("+");
            ind2 = line.indexOf("=");
            res = line.substring(ind2 + 1);
            if (res.equals("?")) {
            } else if (ind > 0) {
                a = Integer.parseInt(line.substring(0, ind));
                b = Integer.parseInt(line.substring(ind + 1, ind2));
                c = Integer.parseInt(res);
                if (a + b == c)
                    count++;
            } else {
                ind = line.indexOf("-");
                a = Integer.parseInt(line.substring(0, ind));
                b = Integer.parseInt(line.substring(ind + 1, ind2));
                c = Integer.parseInt(res);
                if (a - b == c)
                    count++;
            }
        }
        System.out.println(count);
    }
}
