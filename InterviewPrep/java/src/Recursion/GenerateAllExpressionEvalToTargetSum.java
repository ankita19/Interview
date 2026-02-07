package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//2+4*3""4



/*
 * if(i==0)
 * 		currExpValueSofar = num
 * else{
 * 		//for +
 * 	  currExpValueSofar =  currExpValueSofar + num
 * 
 *  //for *
 *  if(lastOperator == "+")
 *  	(currExpValueSofar - lastOperand + lastOperand*num)
 *  else
 *   currExpValueSofar*num
 *   
 *   //""
 *   if(lastOperator == "+")
 *  	(currExpValueSofar - lastOperand + lastOperand*10+num)
 *  else if(lastOperator == "*")
 *  	long val = (lastOperand !=0) ? (currExpValueSofar/lastOperand)*10+num : num;
 *  else
 *  	currExpValueSofar*10+num
 * }
 * 
 * 
 * //cover + case
				generateExphelper(str,i+1,"+",num,currExpSoFar+"+"+num,currExpValue+num,target,result);
				
				//cover * case	
				//if(lastOperator.equals("+")) {
					generateExphelper(str,i+1,"*",lastOperand*num,currExpSoFar+"*"+num, (currExpValue - lastOperand + lastOperand*num),target,result);
				//}else {
					//generateExphelper(str,i+1,"*",num,currExpSoFar+"*"+num, (currExpValue*num),target,result);
				//}
				
				//cover case for ""
				if(lastOperator.equals("+")) {	
				generateExphelper(str,i+1,"\"\"",num,currExpSoFar+"\"\""+num,(currExpValue - lastOperand + lastOperand*10+num),target,result);
				}else if(lastOperator.equals("*")) {	
					generateExphelper(str,i+1,"\"\"",num,currExpSoFar+"\"\""+num,((currExpValue/lastOperand)*10+num),target,result);	
				}else{
					generateExphelper(str,i+1,"\"\"",num,currExpSoFar+"\"\""+num,(currExpValue*10+num),target,result);
				}
 * 
 * */



public class GenerateAllExpressionEvalToTargetSum {
	
	public String[] generateExpression(String str, int target) throws Exception{
		
		if(str == null || str.length() == 0)  throw new Exception("Invalid input" + str);
		List<String> result = new ArrayList<>();
		
		generateExphelper(str,0,"",0,"",0,target,result);
		
		return result.toArray(new String[0]);
		
	}
	
	
	public void generateExphelper(String str,int j,String lastOperator,long lastOperand,String currExpSoFar,long currExpValue,long target,List<String> result) {

		if(j == str.length() )  {
			if(currExpValue == target)
				result.add(currExpSoFar);
			return;
		}
		
		for(int i = j ; i < str.length(); i++) {
			String cur= str.substring(j, i + 1);
            long num = Long.parseLong(cur);

			
			if(i==0) {
				generateExphelper(str,i+1,lastOperator,num,currExpSoFar+num,num,target,result);
			}else {
				if(currExpSoFar.trim().length()!=0) 
				{
					
				generateExphelper(str,i+1,"+",num,currExpSoFar+"+"+num,currExpValue+num,target,result);
				generateExphelper(str,i+1,"*",lastOperand*num,currExpSoFar+"*"+num, (currExpValue - lastOperand + lastOperand*num),target,result);
				
				//cover case for ""
				if(lastOperator.equals("+")) {
				generateExphelper(str,i+1,"\"\"",(currExpValue - lastOperand + (lastOperand*10+num)),currExpSoFar+num,(currExpValue - lastOperand + (lastOperand*10+num)),target,result);
				}else if(lastOperator.equals("*")) {
					long val = (lastOperand !=0) ?((currExpValue/lastOperand)*(lastOperand*10+num)) : num;
					generateExphelper(str,i+1,"\"\"",val,currExpSoFar+num,val,target,result);	
				}else {
					generateExphelper(str,i+1,"\"\"",currExpValue*10+num,currExpSoFar+num,currExpValue*10+num,target,result);
				}
				
			}
			}
		}
	}
	
	
	static void generate_all_expressions(String s,long target,String p,ArrayList<String> out,int pos,long eval,long mult) {
        if (pos == s.length()) {
            if (eval == target) {
                out.add(p);
            }
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            String cur_ = s.substring(pos, i + 1);
            long cur = Long.parseLong(cur_);
            if (pos == 0) {
                generate_all_expressions(s, target, p+cur_, out, i+1, cur, cur);
            } else {
                generate_all_expressions(s, target, p+"+"+cur_, out, i+1, eval+cur, cur);
                generate_all_expressions(s, target, p+"*"+cur_, out, i+1, eval - mult + mult * cur, mult * cur);
            }
        }
    }
    
    static String[] generate_all_expressions(String s, long target) {
        ArrayList<String> ret = new ArrayList<>();
        generate_all_expressions(s, target, "", ret, 0, 0, 0);
        return ret.toArray(new String[ret.size()]);
    }



	public static void main(String[] args) throws Exception {
	GenerateAllExpressionEvalToTargetSum eval = new GenerateAllExpressionEvalToTargetSum();
	
	System.out.println(Arrays.toString(eval.generateExpression("204", 4)));
	
	System.out.println(Arrays.toString(eval.generate_all_expressions("234", 4)));

	}

}
