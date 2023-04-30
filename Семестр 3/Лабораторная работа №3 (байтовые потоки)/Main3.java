package LWork_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream_f1 = new FileInputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f1.txt");
        FileOutputStream fileOutputStream_f2 = new FileOutputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f2.txt");
        FileOutputStream fileOutputStream_f3 = new FileOutputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f3.txt");
        FileOutputStream fileOutputStream_f4 = new FileOutputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f4.txt");

        byte b[] = Files.readAllBytes(Paths.get("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f1.txt"));
        int symbols = 0;
        int words = 0;

        for (int i = 0; i < b.length; i++) {
            if (i == 0)
                symbols--;
            else symbols++;

            if ((char)b[i] == ' ') {
                words++;
                symbols++;
            }
            if ((char)b[i] == '\n') {
                words++;
                symbols--;
                String Count_symbols = String.valueOf(symbols/2);
                fileOutputStream_f2.write(Count_symbols.getBytes());
                fileOutputStream_f2.write('\n');
                String Count_words = String.valueOf(words);
                fileOutputStream_f3.write(Count_words.getBytes());
                fileOutputStream_f3.write('\n');
                symbols = 0;
                words = 0;
            }
            if (i == b.length - 1) {
                words++;
                String Count_symbols = String.valueOf((symbols+1)/2);
                fileOutputStream_f2.write(Count_symbols.getBytes());
                String Count_words = String.valueOf(words);
                fileOutputStream_f3.write(Count_words.getBytes());
            }
        }

        fileOutputStream_f2.close();
        fileOutputStream_f3.close();

        FileInputStream fileInputStream_f2 = new FileInputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f2.txt");
        FileInputStream fileInputStream_f3 = new FileInputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3/f3.txt");

        char peremen = ' ';

        for (int i = 0; i < b.length; i++) {
            if (i == b.length - 1) {
                fileOutputStream_f4.write(b[i]);
                fileOutputStream_f4.write(' ');
                while (fileInputStream_f2.available() != 0) fileOutputStream_f4.write(fileInputStream_f2.read());
                fileOutputStream_f4.write(' ');
                while (fileInputStream_f3.available() != 0) fileOutputStream_f4.write(fileInputStream_f3.read());
            }
            else if ((char) b[i+1] == '\n') {
                fileOutputStream_f4.write(' ');
                while ((peremen = (char)fileInputStream_f2.read()) != '\n' ) fileOutputStream_f4.write(peremen);
                fileOutputStream_f4.write(' ');
                while ((peremen = (char)fileInputStream_f3.read()) != '\n' ) fileOutputStream_f4.write(peremen);
            }
            else fileOutputStream_f4.write(b[i]);
        }

        fileInputStream_f1.close();
        fileOutputStream_f2.close();
        fileOutputStream_f3.close();
        fileOutputStream_f4.close();

    }

}
