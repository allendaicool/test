
public class findLonestCP {
	public static void main (String [] args)
	{
		String A =   "character"; //ACCGGTCGAGTGCGCGGAAGCCGGCCGAA
		String B = "character"; // GTCGTTCGGAATGCCGTTGCTCTGTAAA
        String C = reverseAstring(B);
        System.out.println(B);
        System.out.println(C);
		int[][] memory = new int[A.length()][B.length()];

		for (int i = 0;i<memory.length;i++)
		{
			for ( int j = 0;j<memory[0].length;j++)
			{
				memory[i][j] = -100000;
			}
		}

		char [][] Character = new char [A.length()][B.length()];
		System.out.println(A.length());
		System.out.println(B.length() );
		String store = "";
		int len = findLCS (  A ,  C, memory,Character, A.length()-1 ,  C.length()-1);
		System.out.println(len);
		printout(Character,store,A,C,A.length()-1,C.length()-1);
	}
	public static String reverseAstring (String temp)
	{
		if (temp.length() == 1)
		{
			return temp ;
		}
		String LeftTemp = temp.substring(0,temp.length()/2);
		String RightTemp = temp.substring(temp.length()/2);
		String merger1 = reverseAstring(LeftTemp);
		String merger2 = reverseAstring(RightTemp);
		String newVersion = merger2+merger1;
		return newVersion;

	}

	public static void printout (char[][] let, String same, String A , String B,int i,int j)
	{
		if (i == -1|| j==-1)
		{
			return;
		}
		if( let[i][j] =='A' )
		{
			printout(let,same,A,B,i-1,j-1);
			same +=  A.substring(i, i+1)   ;   
			System.out.println(A.substring(i, i+1) );
			return;
		}
		else if( let[i][j] == 'U')
		{
			printout(let,same,A,B,i-1,j);	
		}
		else
		{
			printout(let,same,A,B,i,j-1);	

		}

	}

	public static int  findLCS ( String A , String B,int [][] memory,char [][] Character,int i , int j)
	{
		if (i==-1|| j ==-1)
		{
			//System.out.println("infinite Break");

			return 0;
		}
		if ( memory[i][j] >=0 )
		{
			return memory[i][j];
		}
		if (A.substring(i, i+1).equals(B.substring(j, j+1)))
		{
			int val =  findLCS(A,B,memory,Character,i-1,j-1)+1;
			memory[i][j] = val;
			Character[i][j] = 'A';
			//System.out.println("infinite XXXXXX");

			return val;

		}
		else 
		{
			//System.out.println("infinite loop");
			int comp = -1;
			int comp2 = -1 ; 

			comp = findLCS(A,B,memory,Character,i-1,j);
			comp2= findLCS(A,B,memory,Character,i,j-1);
			if( comp >comp2)
			{
				Character [i][j] = 'U';
				memory[i][j]  = comp;
				return comp;
			}
			else
			{
				memory[i][j]  = comp2;
				Character [i][j] = 'L';
				return comp2;
			}
		}
	}
}
