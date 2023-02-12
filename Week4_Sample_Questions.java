public class Week4_Sample_Questions {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {6,7,8,9,10};
		//int s = a.length + b.length;
		int[] mergedArray = new int[a.length+b.length];
		mergedArray = merge(a,b);
		printArray(mergedArray);

		System.out.println();
		int[][] mat = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		printOdd(mat);
		System.out.println();
		printSum(mat);
		System.out.println();
		printFirstLast(mat);
        System.out.println();
        System.out.println(isRagged(mat));
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public static int[] merge(int[] a, int[] b) {
		int[] mergedArray = new int[a.length+b.length];
		int i; 
		for (i = 0; i < a.length; i++) {
			mergedArray[i] = a[i];
		}
		for(int j = 0; j < b.length; j++) {
			mergedArray[i] = b[j];
			i++;
		}
		return mergedArray;
	}
	public static void printOdd(int[][] mat) {
		System.out.println("Printing odd:");
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				if(mat[i][j]%2==1) System.out.print(mat[i][j] + " ");
			}
		}

	} 
	public static void printSum(int[][] mat) {
		int sum;
		for(int i = 0; i < mat.length; i++) {
			sum = 0;
			for(int j = 0; j < mat[i].length; j++) {
				sum += mat[i][j];
				if(sum < 100) {
					System.out.println(sum + " ");
				}
			}
		}
	} 

	public static void printFirstLast(int[][] mat) {
		//print first row
		int row = 0;
		System.out.println("Print first row");
		for(int column = 0; column < mat.length; column++) {
			System.out.print(mat[row][column] + " ");
		}
		//print first column
		System.out.println();
		System.out.println("Print first column");
		int column = 0;
		for(row = 0; row < mat.length; row++) {
			System.out.print(mat[row][column] + " ");
		}

	}
    public static boolean isRagged(int[][] r) {
        if (r.length == 0) {
            // empty array is not ragged
            return false;
        }
        int rowLength = r[0].length;
        for (int i = 1; i < r.length; i++) {
            if (r[i].length != rowLength) {
                // found a row with a different length, so the array is ragged
                return true;
            }
        }
        // all rows have the same length, so the array is not ragged
        return false;
    }    
}