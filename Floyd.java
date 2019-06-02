import java.util.*;
public class Floyd
{
	public static void floyd(int a[][],int n)
	{
		int i,j,k;
		int d[][] = new int[20][20];
		
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				d[i][j] = a[i][j];
		
		for(k=1;k<=n;k++)
		{
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					d[i][j] = min(d[i][j],d[i][k] + d[k][j]);
				}
			}
		}
		
		System.out.println("The resultant matrix is-\n");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print(d[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	static int min(int a,int b)
	{
		return (a<b)?a:b ;
	}
	
	public static void main(String[] args)
	{
		int n,i,j;
		int a[][] = new int[20][20];
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no.of nodes-\n");
		n = s.nextInt();
		System.out.println("Enter the cost matrix-\n");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				a[i][j] = s.nextInt();
		
		floyd(a,n);
	}
}