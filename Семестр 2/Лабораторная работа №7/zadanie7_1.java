/*
ВАРИАНТ 10
а) В заданной строке символов перевернуть (прочитать наоборот - справа налево)
определенную по двум индексам группу символов.
б) В предложении поменять местами слова с максимальной и минимальной длинами.
 */

import java.util.Scanner;
public class zadanie7_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Введите строку: ");
		String str = input.nextLine();
		System.out.println("Введите два индекса: ");
		int x = input.nextInt();
		int y = input.nextInt();
		{if (x==y) {
			System.out.println("Индесы равны");
		}
		else if (x>y) {
			System.out.println("Индесы заданы некорректно");
		}
		else if (x<y) {
			String s1 = str.substring(x, y);
			String s0 = str.substring(0, x);
			String s2 = str.substring(y, str.length());
			String result = new StringBuffer(s1).reverse().toString();	
			System.out.println();
			System.out.println("Измененная строка: ");
			System.out.println(s0 + result + s2);
		}
		
		}
	}
}
