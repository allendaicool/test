
public class optimalBinary {
	public static void main (String [] args)
	{

		int n = 5 ;
		double [] p = {-1.5,0.15,0.1,0.05,0.1,0.2};
		double [] q = { 0.05,0.1,0.05,0.05,0.05,0.1};
		int [][] root  =  new int [n][n];
		double [][] e = new double[n+2][n+1]; 
		double [][] w = new double [n+2][n+1];
		System.out.println( e[0].length);

		for (int i = 1 ; i<=e[0].length;i++)
		{
			e[i][i-1] = q[i-1];
			w[i][i-1] = q[i-1];
		}
		for ( int l = 1 ; l <n+1 ; l++)
		{
			for ( int i = 1;i<=n-l+1;i++)
			{ 
				int  j = i+l-1;

				w[i][j] = w[i][j-1] + p[j] + q[j];
				//System.out.println("out A " + q[j]);

				//System.out.println("out    " + w[i][j]);

				e[i][j] = 10000000;

				for ( int loop = i ; loop<= j; loop++)
				{
					double temp = e[i][loop-1] + e[loop+1][j] +w[i][j];
					if( temp<e[i][j])
					{
						e[i][j] = temp;
						root[i-1][j-1] = loop;
						//System.out.println("in " +temp);
					}					
				}
			}
		}
		System.out.println( e[1][5]);
		System.out.println( );
		System.out.println( root[2][4]);
		
		printout(root);

	}
	public static  void printout(int [][] root) 
	{
		System.out.println("k" + root[0][root[0].length-1]+ "is the root");
		// System.out.println()
		herlper ( root,0,root[0][root[0].length-1]-2,"left","k"+ root[0][root[0].length-1]);
		herlper( root, root[0][root[0].length-1], root[0].length-1,"right","k"+ root[0][root[0].length-1]);
	}

	public static void herlper ( int[] [] root,int i, int j, String Childtype,String parent)
	{

		if ( i>j)
		{
			System.out.println("d"+(j+1)+"is th" +  Childtype + "child of"  + parent);	
			return;
		}

		else
		{
			System.out.println("k" + root[i][j] + "is the " + Childtype + "child of" + parent);	
			herlper (  root, i,  root[i][j] -2 , "left"   , "k"+root[i][j]  );
			herlper( root, root[i][j]  ,  j, "right" ,  "k"+root[i][j]);
			return;
		}

	}
}
