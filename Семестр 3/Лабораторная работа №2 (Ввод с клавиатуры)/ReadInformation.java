package LWork_2;

import java.io.IOException;

public class ReadInformation {
    public static String вводСтрокиСКлавиатуры() throws IOException {
        byte b[] = new byte[100];
        System.in.read(b);
        String s = new String(b);
        s = s.trim();
        return s;
    }

    public static int  вводЧислаСКлавиатуры() throws IOException, NumberFormatException{
        byte[] b = new byte[100];
        int i = 0;
        System.in.read(b);
        String s = new String(b);
        s = s.trim();
        try {
            i = Integer.parseInt(s);
            return i;
        }
        catch(NumberFormatException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return i;
    }
}
