/*  Вариант 9

    Заполнить двухмерный массив Т[1..n,1..n] последовательными целыми
	числами от 1 до n 52 0, расположенными по спирали, начиная с левого
	верхнего угла и продвигаясь по часовой стрелке                        */

import java.util.Scanner; 
public class zadanie6_4 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Введите число: ");
		int n = input.nextInt();
		int[][] T = new int[n][n];
		int m = 1;
	    if(n % 2 != 0){
	    	T[(n / 2)][(n / 2)] = (n * n);      // если N - нечетное то находим центр матрицы и заполняем его числом N * N
	    }
	    	    
	    for(int i = 0; i < (n / 2); i++){
	    	for(int j = i; j < (n - i); j++){   	// заполнение верхней грани слева направо
	    		T[i][j] = m;
	            m++; }
	    	for(int j = 1; j < (n - i - i); j++){   // заполнение правой грани сверху вниз
	    		T[(j + i)][(n - i) - 1] = m;    
	    		m++; }
	    	for(int j = (n - 2) - i; j >= i; j--){  //заполнение нижней грани справа налево
	    		T[(n - i) - 1][(j)] = m;
	    		m++;}
	    	for(int j = ((n - i) - 2); j > i; j--){ //заполнение левой грани снизу вверх
	    		T[j][i] = m;
	    		m++;}
		    /*for (int x = 0; x < n; x++) {
		    	for (int y = 0; y < n; y++) {
		    		System.out.print(T[x][y]+ "\t");}
		    	System.out.println();*/	
		    //}
	    }
	    for (int x = 0; x < n; x++) {
	    	for (int y = 0; y < n; y++) {
	    		System.out.print(T[x][y]+ "\t");
	    	}
	    	System.out.println();
	    }
	}
}
	    