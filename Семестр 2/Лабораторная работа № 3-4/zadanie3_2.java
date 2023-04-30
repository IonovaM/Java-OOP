/* Составить программу, вычисляющую значения переменной по заданному условию. 
 * Значения исходных переменных, используемые в условии, задаются произвольным образом. 
 * Вывести на экран значения исходных переменных и результат. 
 * Проверить работу блоков условий, задавая соответствующие значения исходных переменных. 
 
 
   Вариант 9
 * Даны три числа. Вывести их на экран в порядке возрастания.*/

// импорт (для ипользования Scanner'а)

import java.util.Scanner; 

public class zadanie3_2 {
	public static void main(String[] args) {
		// Создание объекта Scanner
	    Scanner input = new Scanner (System.in);
	    // Считывание с консоли
	    System.out.print("Задайте три числа: ");
	    int a = input.nextInt();
	    int b = input.nextInt();
	    int c = input.nextInt();
	    // Вывод на экран результата.
	    if ((a == b) && (a == c) && (b == c)) 
	    	System.out.println("Числа равны: " + a + " " + b + " "+ c);
	    else if ((a >= b) && (a >= c) && (b >= c))
	    	System.out.println("Числа в порядке возрастания: " + c + " " + b + " " + a);
	    else if ((a >= b) && (a >= c) && (b <= c))
	    	System.out.println("Числа в порядке возрастания: " + b + " " + c + " " + a);
	    else if ((a <= b) && (a >= c) && (b >= c))
	    	System.out.println("Числа в порядке возрастания: " + c + " " + a + " " + b);
	    else if ((a <= b) && (a <= c) && (b >= c))
	    	System.out.println("Числа в порядке возрастания: " + a + " " + c + " " + b);
	    else if ((a <= b) && (a <= c) && (b <= c))
	    	System.out.println("Числа в порядке возрастания: " + a + " " + b + " " + c);
	    else 
	    	System.out.println("Числа в порядке возрастания: " + b + " " + a + " " + c);
	}
}
