class TestArray{

 public static void main(String[] args){

	int i = 10;
	
	int[] myArray = {2, 5, 7, 8};
	printArray(myArray);

	myMethod_int(i);
	System.out.println("i in main after the method call: "+i);

	//passing an array to a method
	myMethod_array(myArray);
	System.out.println("myArray after the method call: "+myArray[0]);
	printArray(myArray);

	System.out.println();
	System.out.println("------------ 2D array------------");

	//2D array
	int[][] aa = {
		{10, 5, 3, 20},
		{20, 11, 30, 50, 100, 200},
		{25, 30}
		};

	int[][] bb = new int[3][4];

	print2DArray(aa);
	System.out.println();
	System.out.println("Another 2D array");
	print2DArray(bb);

	int[][] cc = new int[5][];
	//System.out.println(cc[0][1]);
	//cc[0][0] = new int[1];
	for(int k = 0; k<cc.length; k++){
		cc[k] = new int[k+1];
	}

	System.out.println();
	System.out.println("Diagonal 2D array ");
	print2DArray(cc);
	}

	
	public static void printArray(int[] arr){
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void print2DArray(int[][] arr){
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col]+ " ");
			}
			System.out.println();
		}
	}

	public static void myMethod_int(int a){
		a += 3; 
		System.out.println("The value of a within the method is :"+a);
	}

	public static void myMethod_array(int[] b){
		b[0] = b[0] + 10;
	}	

}