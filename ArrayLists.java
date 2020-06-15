import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]); // command-line argument
        System.out.println(n);

        Scanner s = new Scanner(System.in);
        
        String[] array = new String[n];
        ArrayList<String> arrayList = new ArrayList<String>();

        for(int i = 0; i < n; i++) {
            String input = s.nextLine();
            array[i] = input;
            arrayList.add(input);
        }

        s.close();

        System.out.println(arrayList);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] == arrayList.get(i) + " ");
        }
        System.out.println();

        ArrayList<ArrayList<Integer>> arrayList2D = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();

        Random rng = new Random();
        for(int i = 0; i < n; i++) {
            arrayList1.add(rng.nextInt(10));
            arrayList2.add(rng.nextInt(10));
        }

        arrayList2D.add(arrayList1);
        arrayList2D.add(arrayList2);

        for(int i = 0; i < arrayList2D.size(); i++) {
            for(int j = 0; j < arrayList2D.get(i).size(); j++) {
                System.out.print(arrayList2D.get(i).get(j) + " ");
            }
            System.out.println();
        }

        int first = arrayList2D.get(0).get(0);
        arrayList2D.get(0).remove((Integer) first);

        for(int i = 0; i < arrayList2D.size(); i++) {
            for(int j = 0; j < arrayList2D.get(i).size(); j++) {
                System.out.print(arrayList2D.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}