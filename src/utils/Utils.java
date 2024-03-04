package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class Utils {
	public static <T> T extraire(List<T> e) {
		int index = (int) (Math.random()*e.size());
		T val=e.get(index);
		e.remove(index);
		return val;
		
	}
	
	
	public static <T> List<T> melanger(List<T> l) {
		ArrayList <T> l2=new ArrayList<T>();
		int size=l.size();
		for (int i = 0; i <size; i++) {
			l2.add(extraire(l));
		}
		return l2;
	}
	
	public static <T> Boolean verifierMelange(List<T> l1, List<T> l2) {
		Boolean res=true;
		for(T t :l1) {
			res = res&&Collections.frequency(l1,t)==Collections.frequency(l2,t);
		}
		return res;
	}
	
	public static <T> List<T> rassembler(List<T> l) {
//		
//	          int taille = l.size();  
//	        
//	          for (int i = 1; i < taille; i++)
//	          { 
//	               T t =l.get(i);  
//	               int j = i-1;  
//	            
//	               while(j >= 0 && !l.get(j).equals(t))  
//	               {
//	                    l.set(j+1, l.get(j));  
//	                    j--;  
//	               }  
//	               l.set(i, t); ; 
//	        }  
//	     
//		return l;
			LinkedList<T> res = (LinkedList<T>) l;

	          int taille = l.size();  
	        
	          for (int i = 1; i < taille; i++)
	          { 
	               T t =l.get(i);  
	               int j = i-1;  
	               res.listIterator(i);
	               while(j >= 0 && !l.get(j).equals(t))  
	               {
	                    res.descendingIterator();  
	                    j--;  
	               }  
	               l.set(i, t); ; 
	        }  
		
	}
	
	public static void verifierRassemblement() {
		
	}
}
