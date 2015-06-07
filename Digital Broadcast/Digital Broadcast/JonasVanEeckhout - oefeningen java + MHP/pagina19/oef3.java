import java.lang.*;

public class oef3 {
public static void main(String args[])

	{
		float pi;
  		float number = 0;
  		float j = 1;
	
  		for(int i = 1; i <= 10000; i++){
   			if(i % 2 == 0){
    				number-= 1/j;   
   			}

  		 	else{
    				number+= 1/j;    
   			}

   			j+=2;
  			}
  
  			pi = 4*number;
  			System.out.println(pi);
	}
}