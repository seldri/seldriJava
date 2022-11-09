import java.util.Scanner;

public class Allgemein {
	public static void main(String[] args) {

		
		int[] a = new int[4];
		
		a[1] = 12;
		a[2] = 11;
		a[0] = a[1] - a[2];
		a[2] *= 2;
		
		int i = 3;
		
		while(i >= 0) {
			System.out.println(a[i]);
			i--;
		}
	}
}