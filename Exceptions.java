import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");

        int n;
        try {
            n = Integer.parseInt(s.nextLine());
            if(n < 0) {
                throw new NegativeException();
            }
            System.out.println(n);

        } 
        catch(NumberFormatException | NegativeException e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Done");
        }
    }
}

class NegativeException extends Exception {}