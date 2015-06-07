import java.lang.*;

public class oef7 {
public static void main(String args[]){
		int[] a={12,34,56,78,123,234,99,88};
		int[] b=new int[a.length];
		int c=234;
		
		for(int i=0;i<a.length;i++){
			if(a[i]==c){
				b[i]=a[i];
				System.out.println("Het grootste getal is " + b[i]);
			}
			else{
				a[i]=0;
			}
		}
	}
}