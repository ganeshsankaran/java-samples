public class Strings {
    public static void main(String[] args) {
        String a = "foo";
        String b = new String("foo");

        System.out.println(a.length()); 
        System.out.println(a.substring(1, 2));
        System.out.println(a.toUpperCase());
        System.out.println(a.charAt(0));
        System.out.println(a.equals(b));
        System.out.println(a.equals("bar"));
        System.out.println(a.compareTo("bar"));
        System.out.println(a + "bar");
        
        String three = "3";
        String five = Integer.toString(5);
        int i = Integer.parseInt(three);
        System.out.println(three + " + " + five + " = ");
        System.out.println(i + 5);

        // String Pool
        String c = "foo";
        System.out.println(a == b);
        System.out.println(a == c);

    }
}