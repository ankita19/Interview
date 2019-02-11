package array_string.matrix;

public class PrintSpiral {

	public static void printSpiral(int[][] a,  int m,int n) {
		
		
		int round  = 1;
		int rs = 0;
		int re = m-1;
		int cs = 0;
		int ce = n-1; 
		while(rs <= re && cs <=ce) {
		
			
			for(int i = cs ; i <= ce ;i++) {
				System.out.print( " "+a[rs][i]);
				}
			
			rs++;
			
			for(int i = rs ; i <= re ;i++) {
				System.out.print( " "+a[i][ce]);
				}
			
			ce--;
			
			for(int i = ce ; i >= cs ;i--) {
				System.out.print( " "+a[re][i]);
				}
			
			re--;
			
			for(int i = re ; i >= rs ;i--) {
				System.out.print( " "+a[i][cs]);
				}
			cs++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] arr = {{1,2,3,4,5},
	 			{6,7,8,9,10},
	 			{11,2,3,4,15},
	 			{16,2,3,4,20}};
		
		printSpiral(arr,4,5);

		
	}

}
