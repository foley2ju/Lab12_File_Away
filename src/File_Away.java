import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

public class File_Away {
    public static void main(String[] args) {

        Scanner in;
        JFileChooser chooser = new JFileChooser();
        String line;
        int numLines = 0;
        int numWords = 0;
        int numCharacters = 0;

        Path target = new File(System.getProperty("user.dir")).toPath();

        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                in = new Scanner(target);
                System.out.println("File: " + target.getFileName());

                while (in.hasNextLine()) {
                    line = in.nextLine();
                    numLines ++;
                    numCharacters += line.length();
                    numWords += new StringTokenizer(line, " ,").countTokens();
                }
                in.close();
                System.out.println("Lines: " + numLines );
                System.out.println("Words: " + numWords );
                System.out.println("Characters: " + numCharacters );
            } else {
                System.out.println("Please select a file.");
            }

        } catch (IOException e) {
            System.out.println("Error");
        }







    }
}