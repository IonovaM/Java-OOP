/* Вариант 9
  
	1) В массиве С1, С2, ..., Сn найти произведение чисел, больших 2.						*/

// импорт (для ипользования Scanner'а)	

import java.util.Scanner; 																							
public class zadanie6 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Введите число элементов: ");
		int x = input.nextInt();
		int[] c = new int[x];
		for (int i = 0; i < x; i++) {
			c[i] = ((int)(Math.random() * 6)); //Заполнение массива рандомными элементами
			System.out.print(" " + c[i]);
	    };
	    long R = 1;
		for (int i = 0; i < x; i++) {
			if (c[i] > 2)
				R *= c[i];
	    }
		System.out.println();
		System.out.println("R = " + R);
	}
}
