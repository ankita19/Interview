package Recursion;

import java.util.ArrayList;
import java.util.List;

public class nQueen {
	

    /*
     * Complete the function below.
     */
    static String[] find_all_arrangements(int n) {
        
        List<String> result = new ArrayList<>();
        helper(n,result,new String[n][n],0);
        return result.toArray(new String[n]);

    }
    
    
    static void helper(int n,List<String> result,String[][] chessBoard,int row){
        
        if(row == n)
        {  StringBuilder sb = new StringBuilder();
            for(int i =0 ; i < n ; i++) {
            	for(int j =0 ; j < n ; j++) {
            		if(chessBoard[i][j] !=  "q") {
            			sb.append("_");
            		}else
            		    sb.append("q");
            	}
            	
            	sb.append(",");
            	sb.append("\n");
            	
            }
            System.out.println(sb.toString());
            System.out.println("-----------");
            result.add(sb.toString());
        return;
        }
            
        else{
            
            for(int col = 0; col < n ;col++){
                if(isValid(chessBoard,row,col,n)){
                    chessBoard[row][col] = "q";
                    helper(n,result,chessBoard,row+1);
                    chessBoard[row][col] = "-";
                  
                    
                }
            }
        }    
        
    }
    
    static boolean isValid(String[][] chessBoard,int row,int col, int n){
        
      for(int i = 0; i < n ;i++){
          if(chessBoard[row][i] == "q")
            return false;
      }
    
    for(int i = 0; i < n ;i++){
          if(chessBoard[i][col] == "q")
            return false;
      }
      
      
     int cur_row = row, cur_col = col;
     
     if(row != 0 && col != 0) {
    	 if(chessBoard[row-1][col-1] =="q") return false;
    	 if(col+1<n)
    	 if(chessBoard[row-1][col+1] =="q") return false;	
     }
     
    
	 	
      
      return true;
    
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find_all_arrangements(4);
	}

}
