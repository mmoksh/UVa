import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Character, Character> hash = new HashMap();
        hash.put(']', 'p');
        hash.put('[', 'o');
        hash.put('p', 'i');
        hash.put('o', 'u');
        hash.put('i', 'y');
        hash.put('u', 't');
        hash.put('y', 'r');
        hash.put('t', 'e');
        hash.put('r', 'w');
        hash.put('e', 'q');
        
        hash.put('\'', 'l');
        hash.put(';', 'k');
        hash.put('l', 'j');
        hash.put('k', 'h');
        hash.put('j', 'g');
        hash.put('h', 'f');
        hash.put('g', 'd');
        hash.put('f', 's');
        hash.put('d', 'a');
        
        hash.put('/', ',');
        hash.put('.', 'm');
        hash.put(',', 'n');
        hash.put('m', 'b');
        hash.put('n', 'v');
        hash.put('b', 'c');
        hash.put('v', 'x');
        hash.put('c', 'z');
        
        String line;
        while (input.hasNext()) {
            line = input.nextLine().toLowerCase();
            char [] arr = line.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                Character c = hash.get(arr[i]);
                if (c != null) {
                    arr[i] = c;
                }
            }
            System.out.println(String.valueOf(arr));
        }
    }
}
