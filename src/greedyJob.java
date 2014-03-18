
public class greedyJob {

	public static void main (String [] args)
	{


	}

	public static int greedyPick ( int[][] A , int [] []B ,int [] f , int [] s ,int i, int j)
	{
		if ( i== j || j == (i+1))
		{
			return  0 ; 
		}
		else if ( A[i][j]  > 0)
		{
			return A[i][j];
		}
		else
		{
			A[i][j] = 0 ;
			for ( int k = i +1 ; k<j; k++)
			{
				if( f[i] <f[k] && f[i] <= s[k] && f[k]<=s[j])
				{
					int temp = greedyPick ( A,B,f,s,i,k) + greedyPick(A,B,f,s,k,j) + 1 ;
					if ( temp > A[i][j])
					{
						A[i][j] = temp;
						B[i][j] = k;
					}
				}
			}
		}
		return A[i][j];
	}


}
