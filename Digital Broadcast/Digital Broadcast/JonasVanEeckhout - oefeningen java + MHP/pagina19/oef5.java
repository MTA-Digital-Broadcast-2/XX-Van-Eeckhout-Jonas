import java.lang.*;

public class oef5 {
public static void main(String args[]){
		for(int i=1;i<100;i++){
			int j;
			for(j=2;j<i;j++){
				int a=i%j;
				if(a==0){
					break;
				}
			}
			if(i==j){
				System.out.println("Priemgetal is "+i);
			}
		}
	}
}
