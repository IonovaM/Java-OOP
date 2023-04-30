package LWork_3a;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main3aa {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream_f1 = new DataInputStream(new FileInputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f1_1.txt"));
        DataOutputStream dataOutputStream_f2 = new DataOutputStream(new FileOutputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f2_2.txt"));
        DataOutputStream dataOutputStream_f3 = new DataOutputStream(new FileOutputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f3_3.txt"));
        DataOutputStream dataOutputStream_f4 = new DataOutputStream(new FileOutputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f4_4.txt"));

        byte b[] = Files.readAllBytes(Paths.get("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f1_1.txt"));
        int symbols = 0;
        int words = 0;

        for (int i = 0; i < b.length; i++) {
            symbols++;
            if ((char) b[i] == ' ') {
                words++;
                symbols++;
            }
            if ((char) b[i] == '\n') {
                words++;
                symbols--;
                String Count_symbols = String.valueOf(symbols / 2);
                dataOutputStream_f2.write(Count_symbols.getBytes());
                dataOutputStream_f2.write('\n');
                String Count_words = String.valueOf(words);
                dataOutputStream_f3.write(Count_words.getBytes());
                dataOutputStream_f3.write('\n');
                symbols = 0;
                words = 0;
            }
            if (i == b.length - 1) {
                words++;
                String Count_symbols = String.valueOf((symbols + 1) / 2);
                dataOutputStream_f2.write(Count_symbols.getBytes());
                String Count_words = String.valueOf(words);
                dataOutputStream_f3.write(Count_words.getBytes());
            }
        }

        dataOutputStream_f2.close();
        dataOutputStream_f3.close();

        FileInputStream fileInputStream_f2 = new FileInputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f2_2.txt");
        FileInputStream fileInputStream_f3 = new FileInputStream("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f3_3.txt");

        char peremen = ' ';

        for (int i = 0; i < b.length; i++) {
            if (i == b.length - 1) {
                dataOutputStream_f4.write(b[i]);
                dataOutputStream_f4.write(' ');
                while (fileInputStream_f2.available() != 0) dataOutputStream_f4.write(fileInputStream_f2.read());
                dataOutputStream_f4.write(' ');
                while (fileInputStream_f3.available() != 0) dataOutputStream_f4.write(fileInputStream_f3.read());
            } else if ((char) b[i + 1] == '\n') {
                dataOutputStream_f4.write(' ');
                while ((peremen = (char) fileInputStream_f2.read()) != '\n') dataOutputStream_f4.write(peremen);
                dataOutputStream_f4.write(' ');
                while ((peremen = (char) fileInputStream_f3.read()) != '\n') dataOutputStream_f4.write(peremen);
            } else dataOutputStream_f4.write(b[i]);
        }

        dataInputStream_f1.close();
        dataOutputStream_f2.close();
        dataOutputStream_f3.close();
        dataOutputStream_f4.close();

    }
}
