
public class fibonacii {
 
	
	 public static void main (String [] args)
	 {
		 
		 int nth = topDown( 10);
		 System.out.println(nth);
	 }
	 
	 public static int bottomUp ( int n)
	 {
		 int [] fib = new int[n];
		 fib[0] = 0;
		 fib[1] = 1;
		 for ( int i = 2 ; i<n; i++)
		 {
			 fib[i] = fib[i-1]+ fib[i-2];
		 }
	     return fib[n-1];
		 
		 
	 }
	 public static int topDown(int n)
	 {
		 int [] temp = new int [n];
		 temp[0] = 0;
		 temp[1] = 1;
		 for ( int i = 2; i<temp.length;i++)
			 temp[i] = -100;
		 return topDownHelper(n-1,temp);
		 
	 }
	 public static int topDownHelper(int n, int [] temp)
	 {
		 if ( temp[n] >=0)
		 {
			 return temp[n];
		 }
		 else
		 {
			 int a= topDownHelper(n-1,temp)+ topDownHelper(n-2,temp);
			 temp[n] =a;
			 return a;
		 }
		 
		 
	 }
}

