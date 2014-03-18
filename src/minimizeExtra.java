
public class minimizeExtra {
	public static void main (String [] args)
	{
		int [] word = { 3,4,5,6};
		int [] c = new int[word.length];
		for ( int i = 0 ; i< c.length;i++)
		{
			c[i]  = -100;
		}
		int [] p = new int [ word.length];
		int max = 12;
		int [][] extras = new int [word.length][word.length] ;
		for ( int i = 0 ;i < extras.length;i++)
		{
			extras[i][i] = max - word[i];
			for ( int j=i+1;j<extras[0].length;j++)
			{
				extras[i][j] = extras[i][j-1]-1-word[j];  			  
			}
		}
		int [][] cl = new int [word.length][word.length];
		for (int i = 0;i<cl.length;i++)
		{
			for (int  j = i ;j<cl[0].length;j++)
			{
				if  (extras[i][j]<0)
				{
					cl[i][j] = Integer.MAX_VALUE;
				}
				else if ( j==word.length-1)
				{
					cl[i][j] = 0;
				}
				else
				{
					cl[i][j] = (int)Math.pow((double)extras[i][j], (double)3);
				}
			}
		}
		int min = findMin ( cl,word ,c, p,c.length-1);
		System.out.println(min);
		for ( int i =0 ;i<p.length;i++)
		{
			System.out.println(p[i]);
		}
		printout ( p ,  word.length-1, word);
	}

	public static int findMin ( int [][] cl, int []word ,int [] c,int[] p,int index)
	{
		if ( index == -1)
		{
			return 0 ;
		}
		else if ( c[index] >=0  )
		{
			return c[index];
		}
		else
		{
			c[index] = Integer.MAX_VALUE;
			for (int i = 0 ; i <=index ; i++)
			{
				int temp;
				if (cl[i][index] == Integer.MAX_VALUE )
				{
					temp  =  cl[i][index];
				}
				else
				{
					temp  = findMin(cl,word,c,p,i-1) + cl[i][index];

				}

				if  ( temp < c[index])
				{
					c[index] = temp;
					p[index] = i ;
				}
			}
			return c[index];
		}

	}

	public static void printout (int[] p , int start,int [] c)
	{
		if ( p[start] == 0)
		{
			for (int i = 0 ; i<= start;i++)
			{
				System.out.print(c[i]+" ");
			}
			System.out.println();
		}
		else
		{
			printout(p,p[start]-1,c);
			for (int i = p[start] ; i<=start;i++ )
			{
				System.out.print(c[i]+" ");
			}
			System.out.println();

		}


	}
}
