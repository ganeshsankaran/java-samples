import java.io.File;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;

public class FileIO {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));

        Scanner inFile = null;
        String line, word;
        try {
            inFile = new Scanner(new File("file.txt"));
            while(inFile.hasNextLine()) {
                line = inFile.nextLine();
                System.out.println(line);
            }

            inFile = new Scanner(new File("file.txt"));
            while(inFile.hasNext()) {
                word = inFile.next();
                System.out.println(word);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            if(inFile != null) inFile.close();
        }

        Scanner remoteInFile = null;
        try {
            URL url = new URL("https://www.le.ac.uk/oerresources/bdra/html/page_09.htm");
            URLConnection cnxn = url.openConnection();
            remoteInFile = new Scanner(cnxn.getInputStream());

            for(int i = 0; i < 10 && remoteInFile.hasNextLine(); i++) {
                line = remoteInFile.nextLine();
                System.out.println(line);
            } 
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            if(remoteInFile != null) remoteInFile.close();
        }
    }
}