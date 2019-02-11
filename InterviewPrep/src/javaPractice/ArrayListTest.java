package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ArrayListTest {

	public class Dog{
		
		Dog(String name){
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		String name;
		
	}
	
	public void foo(Dog someDog) {
	    someDog.setName("Max");     // AAA
	    someDog = new Dog("Fifi");  // BBB
	    someDog.setName("Rowlf"); // CCC
	    
	    System.out.println(someDog.getName());
	}
	
	
	
	
	public static void remove_dups(ArrayList<String> list,int n) {		
		Set<String> unqList = new TreeSet<String>(list);
		list.clear();
		list.addAll(unqList);
		n=20;
	}
	
	public static void update_list(String[] str) {
		
		str[0] = "test";
	}
	
	public static void main(String[] args) {
		
		ArrayListTest test = new ArrayListTest();
		Dog myDog = test.new Dog("Rover");
		System.out.println(myDog.getName());
		
		test.foo(myDog);
		
		System.out.println(myDog.getName());
		
		
     ArrayList<String> list = new ArrayList<String>();
     
     String[] str =  {"one","two"};
     
     update_list(str);
     System.out.println(Arrays.toString(str));
     
     int n=10;
     
     list.add("one");
     list.add("two");
     list.add("two");
     
     remove_dups(list,n);
     
     for(String string : list) {
    	 System.out.println(string);
     }
     
     ArrayList<String> list2; 
     //= new ArrayList<String>(list);
     
    list2=list;
    
     list2.add("three"); 
     
     for(String string : list2) {
    	 System.out.println("list 2-"+string);
     }
     
     for(String string : list) {
    	 System.out.println("list 1-"+string);
     }
	}

}
