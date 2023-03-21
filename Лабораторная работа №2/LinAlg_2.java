/* Составить программу, вычисляющую значения переменной по заданной формуле. 
 * Предусмотреть задание значений переменных, используемых в формуле, 
 * если они не определены. Вывести на экран формулы, по которым выполняется расчет, 
 * значения исходных и промежуточных переменных и результат.*/

// Вариант 9
/* X1 = Z1 / P ;    где P = ( Z1^2 + Z2^2 ) / Z1 * Z2 . 
 * X2 = Z2 / P ;
 * X3 = Z3 / P ;                                       */

// импорт (для ипользования Scanner'а)
import java.util.Scanner;

public class LinAlg_2 {
	public static void main(String args[]) {
	       double X1, X2, X3;
	       // Создание объекта Scanner
	       Scanner input = new Scanner (System.in);
	       // Считывание с консоли
	       System.out.print("Задайте Z1 = ");
	       double Z1 = input.nextDouble();
	       System.out.print("Задайте Z2 = ");
	       double Z2 = input.nextDouble();
	       System.out.print("Задайте Z3 = ");
	       double Z3 = input.nextDouble();
	       // Подсчет значения P
	       double P = (Math.pow(Z1, 2) + Math.pow(Z2, 2)) / (Z1 * Z2);
	       X1 = Z1 / P ;
	       X2 = Z2 / P ;
	       X3 = Z3 / P ;
	       /* Вывод на экран формулы, по которой выполняется расчет значений,
	        * исходных и промежуточных переменных и результата.*/
	       System.out.println("Значения промежуточных переменных: P = " + P);
	       System.out.println("Формула, по которой выполняется расчет значений: \n"
	       		+ "               X1 = Z1 / P \n"
	       		+ "	       X2 = Z2 / P \n"
	       		+ "	       X3 = Z3 / P ");
	       System.out.println("X1 = " + X1);
	       System.out.println("X2 = " + X2);
	       System.out.println("X3 = " + X3);
	}
}
