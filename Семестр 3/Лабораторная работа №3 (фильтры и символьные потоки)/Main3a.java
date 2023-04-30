package LWork_3a;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main3a {
    public static void main(String[] args) throws IOException {
        FileReader fileReader_f1 = new FileReader("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f1.txt");
        FileWriter fileWriter_f2 = new FileWriter("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f2.txt");
        FileWriter fileWriter_f3 = new FileWriter("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f3.txt");

        char peremen = ' ';
        int letter2 = ' ';
        int letter3 = ' ';

        int symbols = 0;
        int words = 0;
        String str = "";
        while(fileReader_f1.ready()) {
            char letter = (char) fileReader_f1.read();
            str += String.valueOf(letter);
            symbols++;

            if (letter == ' ') {
                words++; }
            if (letter == '\n'){
                words++;
                //letter2 = symbols;
                fileWriter_f2.write(String.valueOf(symbols) + '\n');
                fileWriter_f3.write(String.valueOf(words) + '\n');
                symbols = 0;
                words = 0;
            }
            if (!fileReader_f1.ready()) {
                words++;
                //letter3 = words;
                fileWriter_f2.write(String.valueOf(symbols));
                fileWriter_f3.write(String.valueOf(words));

            }
        }
        char[] b = str.toCharArray();
        System.out.print(b);
        //System.out.println(letter2);
        //System.out.println(letter3);
        fileWriter_f2.close();
        fileWriter_f3.close();

        FileReader fileReader_f2 = new FileReader("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f2.txt");
        FileReader fileReader_f3 = new FileReader("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f3.txt");
        FileWriter fileWriter_f4 = new FileWriter("/Users/margarita/IdeaProjects/untitled/src/LWork_3a/f4.txt");

        for (int i = 0; i < b.length; i++) {
            if (i == b.length - 1) {
                fileWriter_f4.write(b[i]);
                fileWriter_f4.write(' ');
                if ((peremen = (char)fileReader_f2.read()) != '\n' ) fileWriter_f4.write(peremen);
                if ((peremen = (char)fileReader_f2.read()) != 0 ) fileWriter_f4.write(peremen);
                fileWriter_f4.write(' ');
                if ((peremen = (char)fileReader_f3.read()) != 0) fileWriter_f4.write(peremen);
            }
            else if ((char) b[i+1] == '\n') {
                fileWriter_f4.write(' ');
                while ((peremen = (char)fileReader_f2.read()) != '\n' ) fileWriter_f4.write(peremen);
                fileWriter_f4.write(' ');
                while ((peremen = (char)fileReader_f3.read()) != '\n' ) fileWriter_f4.write(peremen);
            }
            else fileWriter_f4.write(b[i]);
        }

        fileReader_f1.close();
        fileReader_f2.close();
        fileReader_f3.close();
        fileWriter_f4.close();
    }
}
