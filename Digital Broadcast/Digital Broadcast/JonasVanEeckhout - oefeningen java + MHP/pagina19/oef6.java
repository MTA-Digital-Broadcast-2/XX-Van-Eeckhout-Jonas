import java.lang.*;

public class oef6 {
public static void main(String args[]){
		int[] a={12,34,56,78,123,234,99,88};
		int b=234;
		
		for(int i=0;i<a.length;i++){
			if(a[i]==b){
				System.out.println("Het grootste getal is " + a[i]);
				break;
			}
		}
	}
}