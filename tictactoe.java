/*
 * Given a 3*3 grid initially all the spaces are blank 
 * the problem is to make three consective marks (Horizontally or vertically or diagonally) of crosses(X)
 * under the condition that after each turn of player computer plays its turn of Noughts(0)
 */

import java.util.*;
public class tictactoe {
	
	//checks the max layer
	public static void put0(int[][] arr) {
		int[] val=new int[9];
		int alpha=Integer.MAX_VALUE;
		boolean flag=true;
		for(int i=0;i<val.length;i++) {
			val[i]=Integer.MIN_VALUE;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]==-1) {
					arr[i][j]=0;
					int temp=checkPosition(arr,alpha);
					if(flag) {
						alpha=temp;
						flag=false;
					}
					alpha=alpha>temp?alpha:temp;
					/*if(flag) {
						temp=alpha;
						flag=false;
					}
					else if(!flag && temp>alpha) {
						alpha=temp;
					}*/
					arr[i][j]=-1;
					val[i*3+j]=temp;
				}
			}
		}
		
		int position=0;
		int value=val[0];
		for(int i=1;i<val.length;i++) {
			if(val[i]>value) {
				value=val[i];
				position=i;
			}
		}
		int row=position/3;
		int col=position-row*3;
		arr[row][col]=0;
	}
	
	//this for finding the best option in min layer
	public static int checkPosition(int[][] arr,int alpha) {
		int min=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]==-1) {
					arr[i][j]=1;
					//System.out.println("this is inside min "+i+" "+j+" ");
					int cal=calculate(arr,0);
					//System.out.println("this is inside min val "+cal);
					min=min>cal?cal:min;
					if(alpha!=Integer.MAX_VALUE && alpha>=min) {
						arr[i][j]=-1;
						return min;
					}
					arr[i][j]=-1;
					
				}
			}
		}
		return min;
	}
	
	
	//evaluates the  position and return its value
	public static int calculate(int[][] arr,int num) {
		 int knotWin=0;
		 int crossWin=0;
		 
		 //checking rows
		 for(int i=0;i<arr.length;i++) {
			 boolean one=false;
			 boolean zero=false;
			 int countZero=0;
			 int countOne=0;
			 for(int j=0;j<arr.length;j++) {
				 if(arr[i][j]==1) {
					 countOne++;
					 one=true;
				 }
				 else if(arr[i][j]==0) {
					 countZero++;
					 zero=true;
				 }
			 }
			// System.out.println("this is inside row "+i+" "+countOne+" "+countZero);
			 if(countOne==3) {
				 return -(Integer.MAX_VALUE);
			 }
			 else if(countZero==3) {
				 return Integer.MAX_VALUE;
			 }
			 if(one && !zero) crossWin++;
			 else if(zero && !one) knotWin++;
		 }
		 
		 //checking columms
		 for(int i=0;i<arr.length;i++) {
			 boolean one=false;
			 boolean zero=false;
			 int countZero=0;
			 int countOne=0;

			 for(int j=0;j<arr.length;j++) {
				 if(arr[j][i]==1) {
					 countOne++;
					 one=true;
				 }
				 else if(arr[j][i]==0) {
					 countZero++;
					 zero=true;
				 }
			 }
		//	 System.out.println("this is inside column "+i+" "+countOne+" "+countZero);
			 if(countOne==3) {
				 return -(Integer.MAX_VALUE);
			 }
			 else if(countZero==3) {
				 return Integer.MAX_VALUE;
			 }
			 if(one && !zero) crossWin++;
			 else if(zero && !one) knotWin++;
		 }
		 
		 //checking diagonals
		 boolean one=false;
		 boolean zero=false;
		 int countZero=0;
		 int countOne=0;


		 for(int i=0;i<arr.length;i++) {
			 if(arr[i][i]==1) {
				 countOne++;
				 one=true;
			 }
			 else if(arr[i][i]==0) {
				 countZero++;
				 zero=true;
			 }
		 }
		 
		 if(countOne==3) {
			 return -(Integer.MAX_VALUE);
		 }
		 else if(countZero==3) {
			 return Integer.MAX_VALUE;
		 }
		 if(one && !zero) crossWin++;
		 else if(zero && !one) knotWin++;
		 one=false;
		 zero=false;
		 countZero=0;
		 countOne=0;


		 for(int i=0;i<arr.length;i++) {
			 for(int j=0;j<arr.length;j++) {
				 if(i+j==2) {
					 if(arr[i][j]==1) {
						 countOne++;
						 one=true;
					 }
					 else if(arr[i][j]==0) {
						 countZero++;
						 zero=true;
					 }
				 }
			 }
		 }
		// System.out.println("this is inside diagonal  "+countOne+" "+countZero);
		 if(one && !zero) crossWin++;
		 else if(zero && !one) knotWin++;
		 if(countOne==3) {
			 return -(Integer.MAX_VALUE);
		 }
		 else if(countZero==3) {
			 return Integer.MAX_VALUE;
		 }
		// System.out.println("Wins:  "+knotWin+" "+crossWin);
		 return knotWin-crossWin;
	}
	
	//check for win cases
	public static boolean check(int[][] arr,int num) {
		//check row and column
		
		for (int i = 0; i < arr.length; i++) {
				if((arr[i][0]==num && arr[i][1]==num && arr[i][2]==num)|| (arr[0][i]==num && arr[1][i]==num && arr[2][i]==num)) {
					return true;
				}
			}
		//diagonal check
		if((arr[0][0]==num && arr[1][1]==num && arr[2][2]==num) || (arr[0][2]==num && arr[1][1]==num &&arr[2][0]==num) ) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] arr=new int[3][3];
		
		for (int[] is : arr) {
			for (int i = 0; i < is.length; i++) {
				is[i]=-1;
			}
		}
		print(arr);
	
		Scanner sc=new Scanner(System.in);
		Random rn=new Random();
		
		while(empty(arr)) {
			//asking user to enter the position
			System.out.println("Enter your move");
			System.out.println("Enter x index");
			int x=sc.nextInt();
			System.out.println("Enter y index");
			int y=sc.nextInt();
			
			//if position entered by user is blank then insert 1
			if(arr[x][y]==-1) {
				arr[x][y]=1;
			}
			
			if(!empty(arr)) {
				print(arr);
				System.out.println("Tie");
				return;
			}
			//check whether user has won or not
			if(check(arr,1)) {
				print(arr);
				System.out.println("You won");
				return;
			}
			print(arr);
			//computer's chance
			put0(arr);
			
			System.out.println();
			System.out.println("Computer turn");
			//check whether computer won or not 
			if(check(arr,0)) {
				print(arr);
				System.out.println("Computer won");
				return;
			}
			print(arr);
		}
		
		System.out.println("Tie");
		return;
		
	}
	
	
	

	//function to print the array in form cross and knot
	public static void print(int[][] arr) {
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2>=0?is2==1?"X\t":"O\t":"_\t");
			}
			System.out.println();
		}/*
		System.out.println();
		System.out.println();
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}
			System.out.println();}
		*/
	}
	
	//check whether the array is completely fill or not
	public static boolean empty(int[][] arr) {
		for (int[] is : arr) 
			for (int is2 : is)	if(is2==-1) return true;
		return false;
	}


}
