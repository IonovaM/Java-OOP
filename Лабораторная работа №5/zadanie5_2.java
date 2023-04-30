/*	
	Вариант 9
	
    Z = ( Z1 / M - Z2 * P ) / Z1 ;
	M изменяется от 2 до -6 с шагом -1; 
	z1,z2,P-произвольно      				*/

// импорт (для ипользования Scanner'а)

import java.util.Scanner;

public class zadanie5_2 {

	public static void main(String[] args) {
		// Создание объекта Scanner
	    Scanner input = new Scanner (System.in);
	    // Считывание с консоли
	    System.out.print("Задайте Z1 = ");
	    double Z1 = input.nextDouble();
	    System.out.print("Задайте Z2 = ");
	    double Z2 = input.nextDouble();
	    System.out.print("Задайте P = ");
	    double P = input.nextDouble();
		int M = 2; 
		int count = 0;
		while (M >= -6) {
			if (M == 0) {
				double Z = ( Z1 / 1 - Z2 * P ) / Z1 ;
				System.out.println("M = " + M + " Результат: Z = " + Z);
				M--;
			}
			else {
				double Z = ( Z1 / M - Z2 * P ) / Z1 ;
				System.out.println("M = " + M + " Результат: Z = " + Z);
			    M--; 
			}
			
		    count++;
		}
		System.out.println("количество повторений цикла = " + count);
	}
}
