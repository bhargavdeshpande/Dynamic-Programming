import java.util.*;
public class MinCoinChange {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int value = Integer.parseInt(str.split(" ")[0].trim());
		int denomCount = Integer.parseInt(str.split(" ")[1].trim());
		int denomArray[] = new int[denomCount]; 
		String str2 = s.nextLine();
		
		for (int m=0; m<denomCount; m++) {
			denomArray[m] = Integer.parseInt(str2.split(" ")[m].trim());
		}
		
		int[] countArray = new int[value+1];
		countArray[0] =0;
		for (int i=1; i<=value; i++)
			countArray[i] = Integer.MAX_VALUE;
		
		for (int j=0; j<denomCount; j++) {
			for (int i=1; i<=value; i++) {
				if (denomArray[j]<=i) {
					countArray[i] = Math.min(countArray[i], 1+countArray[i-denomArray[j]]);
				}
			}
		}
		System.out.println(countArray[value]);
	}

}
