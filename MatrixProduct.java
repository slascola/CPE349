
public class MatrixProduct {
	public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
		int[][] product = new int[A.length][B.length];
		
		if ((A.length != A[1].length) || (B.length != B[1].length) || (A.length != B.length) || (A[1].length != B[1].length) || (A.length % 2 != 0) || (B.length % 2 != 0)) {
			System.out.println("IllegalArgumentException: Invalid matrix sizes\n");
			System.exit(0);
			}
		else {
			product = matrixProduct_DAC(A, 1, 1, B, 1, 1, A.length);
			
		}
		return product;
	}
	private static int[][] matrixProduct_DAC(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB, int n) {
		int[][] C = new int[n][n];
		int[][] a1, a2, a3, a4, b1, b2, b3, b4;
		if (n == 1) {
			C[1][1] = A[startRowA][startColA] * B[startRowB][startColB];
		}
		else {
			a1 = partition(A,1); 
			a2 = partition(A, 2);
			a3 = partition(A, 3);
			a4 = partition(A, 4);
			
		 System.out.println("Partition Matrix:");
	        for (int i = 0; i < a1.length; i++) {
	            for (int j = 0; j < a1[0].length; j++) {
	                System.out.print(a1[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println("Partition Matrix:");
	        for (int i = 0; i < a2.length; i++) {
	            for (int j = 0; j < a2[0].length; j++) {
	                System.out.print(a2[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println("Partition Matrix:");
	        for (int i = 0; i < a3.length; i++) {
	            for (int j = 0; j < a3[0].length; j++) {
	                System.out.print(a3[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println("Partition Matrix:");
	        for (int i = 0; i < a4.length; i++) {
	            for (int j = 0; j < a4[0].length; j++) {
	                System.out.print(a4[i][j] + " ");
	            }
	            System.out.println();
	        }
		}
		return C;
	}
	
	private static int[][] partition(int[][] A, int quadrant) {
		int[][] broken = new int[A.length][A.length];
		if (quadrant == 1) {
			for (int i = 0; i < A.length / 2; i++) {
				for (int j = 0; j < A.length / 2; j++) {
					broken[i][j] = A[i][j];
				}
			}
		}
		else if (quadrant == 2) {
			for (int i = 0; i < A.length / 2; i++) {
				for (int j = A.length / 2; j < A.length; j++) {
					broken[i][j] = A[i][j];
				}
			}	
		}
		else if (quadrant == 3) {
			for (int i = A.length / 2; i < A.length; i++) {
				for (int j = 0; j < A.length / 2; j++) {
					broken[i][j] = A[i][j];
				}
			}
		}
		else {
			for (int i = A.length / 2; i < A.length; i++) {
				for (int j = A.length / 2; j < A.length; j++) {
					broken[i][j] = A[i][j];
				}
			}	
		}
		return broken;
	}
	
}

