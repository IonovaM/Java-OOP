/* Вариант 9

	2) Из данного массива чисел Х1, ... , Хn исключить последнее положительное
число. Оставшиеся числа переписать в массив Z1, ... , Z(n-1).   					*/
						
import java.util.Scanner; 
public class zadanie6_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Введите число элементов: ");
		int y = input.nextInt();
		int[] x = new int[y];
		for (int i = 0; i < y; i++) {
			x[i] = ((int)(Math.random() * 12) - 6); //Заполнение массива рандомными элементами
			System.out.print(" " + x[i]);
	    };
	    int max = 0;
		for (int i = y-1; i >= 0; i--) {
	    	for (int j = y-1; j >= 0; j--) {
	    		int R = x[i] * x[j];
	    		if (x[i] > 0) {
	    			if (max < i){	    
	    				max = i; }
	    		}
	    	}
		}
		System.out.println();
		System.out.println("последнее положительное число = " + x[max]);
		
		int[] z = new int[y - 1];
		for (int i = 0, j = 0; i < x.length; i++) {
		    if (i != max) {
		        z[j++] = x[i];
		    }
		}
		for (int j = 0; j < y-1; j++) {
			System.out.print(" " + z[j]);
	    };
	}
}
