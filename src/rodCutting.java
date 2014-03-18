import java.util.*;
import java.lang.Object;
public class rodCutting {
	public static final int cost = 1;

	public static void main(String [] args)
	{
		int [] p = {1,5,8,9,10,17,17,20,24,30};
		int max = maxval(p,7);
		System.out.println(max);
		int max2 = topDownMax(p,7);
		System.out.println(max2);
		int max3 = BottomUpMax(p,7);
		System.out.println(max3);
		tupleAll<int[], int[]> test1 = BottomUpMaxTuple(p,7);
		int revenue = test1.xVal()[7];
		int cut = 7;
		int count = 7;
		System.out.println();

		while(cut> 0 && count > 0)
		{
			System.out.println(test1.yval()[count]);

			cut -= test1.yval()[count] ;
			count--;
		}
		System.out.println(revenue);


	}


	public static int maxval (int [] p, int length)
	{
		if (length == 0)
		{
			return 0;
		}
		int max = -1;
		for ( int i = 1; i<= length;i++)
		{
			max = Math.max(p[i-1]+ maxval(p,length - i),max);
		}
		return max;
	}


	public static tupleAll<int[], int[]> BottomUpMaxTuple(int [] p ,int length)
	{
		int [] r = new int[length+1];
		int [] s = new int[length+1];
		r[0] = 0;
		for ( int i = 1;i<= length;i++)
		{
			int max = -100;
			for ( int j = 1 ; j <= i;j++)
			{
				if ( max != (max= Math.max(max, r[i-j] + p[j-1]))) 
				{
					s[i] = j;
				}

			}
			r[i] = max;
		}
		tupleAll<int[], int[]> temp1 = new tupleAll<int[],int[]> ( r,s); 
		return temp1;
	}




	public static int BottomUpMax(int [] p ,int length)
	{
		int [] r = new int[p.length];
		r[0] = 0;
		for ( int i = 1;i<= length;i++)
		{
			int max = -100;
			for ( int j = 1 ; j <= i;j++)
			{
				max = Math.max(max, r[i-j] + p[j-1]) ;
			}
			r[i] = max;
		}
		return r[length];
	}


	public static int topDownMax(int[] P, int length)
	{
		int[] n = new int[P.length];
		for ( int i = 0; i< n.length;i++)
		{
			n[i] = -100;
		}
		return topDownHelper(P, n,length);

	}

	public static int topDownHelper(int[]p , int [] n, int lenght)
	{
		if(lenght == 0)
		{
			return 0;
		}
		if(n[lenght-1] > 0 )
		{
			return n[lenght-1];
		}
		else
		{
			int max = -100;
			for (int i = 1; i<=lenght;i++)
			{
				int tempMax = topDownHelper(p,n,lenght-i)+p[i-1];
				if ( i != lenght)
				{
					tempMax -= cost;
				}
				max = Math.max(max, tempMax);
			}
			
			return max;
		}	  	  
	}
}
