import java.util.*;
public class Subsets
{
	private static int d;
	private static int count=0;
	private static int x[] = new int[20];
	private static int w[] = new int[20];
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n,sum=0,i;
		System.out.println("Enter the no. of elements-");
		n = s.nextInt();
		System.out.println("Enter the elements in ascending order-\n");
		for(i=0;i<n;i++)
			w[i] = s.nextInt();
		System.out.println("Enter the value of d-");
		d = s.nextInt();
		
		for(i=0;i<n;i++)
			sum += w[i];
		
		if(sum<d)
		{
			System.out.println("No solution");
			return;
		}
		subset(0,0,sum);
		if(count==0)
		{
			System.out.println("No solution");
			return;
		}
	}
	
	public static void subset(int cs,int k,int r)
	{
		int i;
		x[k]=1;
		if(cs+w[k] == d)
		{
			System.out.println("\nSubset " + (++count));
			for(i=0;i<=k;i++)
				if(x[i]==1)
					System.out.println(w[i] + " ");
		}
		else if(cs+w[k]+w[k+1] <=d)
			subset((cs+w[k]),k+1,r-w[k]);
		
		if(cs+r-w[k] >= d && cs+w[k]<=d)
		{
			x[k]=0;
			subset(cs,k+1,r-w[k]);
		}
	}
}