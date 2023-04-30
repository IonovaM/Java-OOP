/*
ВАРИАНТ 10
а) В заданной строке символов перевернуть (прочитать наоборот - справа налево)
определенную по двум индексам группу символов.
б) В предложении поменять местами слова с максимальной и минимальной длинами.
 */

import java.util.Scanner;
public class zadanie7_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Введите строку: ");
		String str = input.nextLine();
		String max = "";
		String min = str;
		int w = -1, v = -1;
		String [] s = str.split(" ");
		for (int i = 0; i < s.length; i++) {
			int f = s[i].length();
			//System.out.println(f);
			if (max.length() < s[i].length()) {
				max = s[i];
				w = i;
			}
			if (min.length() > s[i].length()) {
				min = s[i];
				v = i;
			}
		}
		System.out.println(max);
		System.out.println(min);
		for (int i = 0; i < s.length; i++) {
			if (i == w) {
				System.out.print(min + " ");
			}
			else if (i == v) {
				System.out.print(max + " ");
			}
			else {
				System.out.print(s[i] + ' ');
			}
		}
	}
}
