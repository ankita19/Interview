package array_string.matrix;

public class PathSumInMatrix {

	public int pathCountWithSum(int[][] a , int targetSum, int m , int n) {
		if(m == 0 && n == 0 )
		{	if(targetSum == 0) 
			   return 1;
		else
			return 0;
		}	
		if(m == 0 || n==0) {
			if(m==0) {
				return pathCountWithSum(a,targetSum-a[m][n],0,n-1);
			}else {
				return pathCountWithSum(a,targetSum-a[m][n],m-1,0);
			}
		}	
		
		int t1 = pathCountWithSum(a,targetSum-a[m][n],m,n-1);
		int t2 = pathCountWithSum(a,targetSum-a[m][n],m-1,n);
		
		
		return  t1+t2 ;
		
		
	}
	
	
	public static void main(String[] args) {
		int[][] a = { {0,2,2},
				      {1,2,2},
				      {1,2,7}
				
			};
		
		int[][] a1 = { {0,2},
			      {7,2},
			     
			
		};
		
		PathSumInMatrix obj = new PathSumInMatrix();
		
		System.out.println(obj.pathCountWithSum(a,13,2,2));

	}

}


