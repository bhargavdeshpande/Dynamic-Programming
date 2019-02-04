import java.util.*;
public class MinMatrixMultiply {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		String str =s.nextLine();
		int[] scale = new int[n+1];
		for (int m=0; m<scale.length; m++) {
			scale[m]= Integer.parseInt(str.split(" ")[m].trim());
		}
		int[][] m = new int[n+1][n+1];
		int[][] paraCount = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++)
				m[i][i]=0;
		int min=0;
		for (int i=n-1; i>=1; i--) {
			for (int j=i+1; j<=n;j++) {
				m[i][j] = Integer.MAX_VALUE;
				int minK=0;
					for (int k =i; k<=j-1;k++) {
							min = m[i][k]+m[k+1][j]+(scale[i-1]*scale[k]*scale[j]);
							if (min < m[i][j]) {
								m[i][j] = min;
								minK=k;
							}
				}
					paraCount[i][j] = minK; 
			}
		}
		System.out.println(m[1][n]);
		showWithPara(paraCount,1,n);
		System.out.println();
	}
	/**
	 * @param strAll
	 * @param paraCount
	 * @param i
	 * @param j
	 * @return
	 */
	private static void showWithPara(int[][]paraCount,int i,int j) {
		if (i==j)
			System.out.print(i);
		else {
			System.out.print("(");
			showWithPara(paraCount,i,paraCount[i][j]);
			showWithPara(paraCount,paraCount[i][j]+1,j);
			System.out.print(")");
		}
	}

}
