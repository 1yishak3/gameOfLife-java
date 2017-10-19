import java.util.*;
public class Test{
	public static void main(String[] args){
		//test time length.
		long start = System.currentTimeMillis();
		ArrayList<Integer> d = new ArrayList<Integer>();
		int i=0;
		while (i<5555555){
			d.add(i);
			i++;
		}
		long stop = System.currentTimeMillis();
		long e = stop - start;
		System.out.println(e);
	}	
}
