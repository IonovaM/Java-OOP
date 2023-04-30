/* Составить программу, вычисляющую значения переменной по заданному условию. 
 * Значения исходных переменных, используемые в условии, задаются произвольным образом. 
 * Вывести на экран значения исходных переменных и результат. 
 * Проверить работу блоков условий, задавая соответствующие значения исходных переменных. 
 
 Вариант 9
    | 0 ,    если Y < 0.5 ; 
    | 1 ,         0.5 ≤ Y < 1.5 ;
X = | 2 ,         1.5 ≤ Y < 2.5 ;
    | 3 ,         2.5 ≤ Y < 3.5 ;
    | 4 ,         Y ≥ 3.5             */

// импорт (для ипользования Scanner'а)

import java.util.Scanner;

public class zadanie3_1 {
	public static void main(String[] args) {
		int x = -1;
		// Создание объекта Scanner
	    Scanner input = new Scanner (System.in);
	    // Считывание с консоли
	    System.out.print("Задайте y = ");
	    double y = input.nextDouble();

	    if (y < 0.5) {
	    	System.out.println("Ветвь 1");
	    	x = 0;}
	    if ((0.5 <= y) && (y < 1.5)) {
	    	System.out.println("Ветвь 2");
	    	x = 1;}
	    if ((1.5 <= y) && (y < 2.5)) {
	    	System.out.println("Ветвь 3");
	    	x = 2;}
	    if ((2.5 <= y) && (y < 3.5)) {
	    	System.out.println("Ветвь 4");
	    	x = 3;}
	    if (y >= 3.5) {
	    	System.out.println("Ветвь 5");
	    	x = 4;}
	    /* Вывод на экран результата.*/
	    System.out.println("Результат: \n"
	    		+ "x = " + x);
	}
}
