
public class nqueens {

	public static void print(int[][] arr) {
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=new int[8][8];
		System.out.println(solve(arr,0));
		System.out.println("Answer ");
		
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2==1?"Q\t":"-\t");
			}
			System.out.println();
		}
	}

	private static boolean solve(int[][] arr,int i) {
		//print(arr);
		if(i>=arr.length) return true;
		for(int k=0;k<arr.length;k++) {
			if(checkPosition(arr,i,k)) {
				arr[i][k]=1;
				System.out.println("checked position "+i+" "+k);
				print(arr);
				if(solve(arr,i+1)) {
					return true;
				}
				else {
					System.out.println("backtrack from --> "+i+" "+k);
					arr[i][k]=0;
				}
			}
		}
		return false;
	}

	private static boolean checkPosition(int[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		//checking row
		for (int j2 = 0; j2 < arr.length; j2++) {
			if(arr[i][j2]==1) return false;
		}
		//checking column
		for (int j2 = 0; j2 < arr.length; j2++) {
			if(arr[j2][j]==1) return false;
		}
		
		//diagonal in 1st quadrant
		for(int i1=i-1,j1=j-1;i1>=0 && j1>=0;i1--,j1--) {
			if(arr[i1][j1]==1) return false;
		}
		//diagonal in 2nd quadrant
		for(int i1=i-1,j1=j+1;i1>=0 && j1<arr.length;i1--,j1++) {
			if(arr[i1][j1]==1) return false;
		}
		//diagonal in 3rd quadrant
		for(int i1=i+1,j1=j-1;i1<arr.length && j1>=0;i1++,j1--) {
			if(arr[i1][j1]==1) return false;
		}
		//diagonal in 4th quadrant
		for(int i1=i+1,j1=j+1;i1<arr.length && j1<arr.length;i1++,j1++) {
			if(arr[i1][j1]==1) return false;
		}
		
		return true;
	}

}
