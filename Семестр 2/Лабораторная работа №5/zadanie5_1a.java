/*	
	Вариант 9
	
    R = K1 * Z1^2 - B * Z2 / ( K - Z3 ) ;
  
	a) В изменяется от 10 до 1 с шагом -1 
		z1,z2,z3,k,K1-произвольно
			
	б) K1 изменяется от 1 до 10 с шагом 1
		В изменяется от 10 до 1 с шагом -1
		z1,z2,z3,k- произвольно				*/

// импорт (для ипользования Scanner'а)

import java.util.Scanner;

public class zadanie5_1a {
	public static void main(String[] args) {
		// Создание объекта Scanner
	    Scanner input = new Scanner (System.in);
	    // Считывание с консоли
	    System.out.print("Задайте Z1 = ");
	    double Z1 = input.nextDouble();
	    System.out.print("Задайте Z2 = ");
	    double Z2 = input.nextDouble();
	    System.out.print("Задайте Z3 = ");
	    double Z3 = input.nextDouble();
	    System.out.print("Задайте K1 = ");
	    double K1 = input.nextDouble();
	    System.out.print("Задайте K = ");
	    double K = input.nextDouble();
	    int count = 0;
	    for (int B = 10; B >= 1; B--) {
	    	double R = (K1 * Math.pow(Z1, 2) - B * Z2) / (K - Z3) ;
	    	count++;
	    	System.out.println("B = " + B + "   Результат: R = " + R);
	    }	
	    System.out.println("количество повторений цикла = " + count);
	}
}
