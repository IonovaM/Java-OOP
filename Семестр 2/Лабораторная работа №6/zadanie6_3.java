/* Вариант 9

	3) Найти сумму положительных элементов последовательности D1, ... , Dn ,
расположенных до первого нулевого элемента, заменить этой суммой минимальный элемент массива.						*/



import java.util.Scanner;
import java.util.Scanner; 
public class zadanie6_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Введите число элементов: ");
		int y = input.nextInt();
		int[] d = new int[y];
		for (int i = 0; i < y; i++) {
			d[i] = ((int)(Math.random() * 12) - 6); //Заполнение массива рандомными элементами
			System.out.println("d[" + i + "] = " + d[i]);
	    };
	    int min = 0;
	    int sum = 0;
	    boolean flag = false;
		for (int i = 0; i < y; i++) {
			if (d[i] == 0) {
				flag = true;}
	    	if ((d[i] > 0) && (flag == false)){
	    		sum += d[i]; }
	    	if (d[i] < d[min]) {
    			min = i; }
		}
		System.out.println("минимальный элемент массива = " + d[min] + ", индекс = " + min);
		System.out.println("сумма = " + sum);
		for (int i = 0; i < y; i++) {
			d[min] = sum;
    		System.out.println("d[" + i + "] = " + d[i]);
		}
	}

}
