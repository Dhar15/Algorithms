import java.util.*;
public class Dijkstra
{	
	public static int findmin(int n)
	{
		int i,min=0;
		int s[] = new int[20];
		int d[] = new int[20];
		for(i=1;i<=n;i++)
			if(s[i]==0)
			{
				min=i;
				break;
			}
		
		for(i=1;i<=n;i++)
		{
			if(d[i]<d[min] && s[i]==0)
				min=i;
		}
		return min;
	}
	
	public static void dijkstra(int v,int w[][],int s[],int d[],int n)
	{
		int i,j,w1,u;
		int p[] = new int[20];
		
		for(i=1;i<=n;i++)
		{
			s[i] = 0;
			d[i] = 999;
			p[i] = 0;
		}
		d[v] = 0;
		
		for(int k=1;k<=n;k++)
		{
			u=findmin(n);
			s[u]=1;
			for(w1=1;w1<=n;w1++)
			{
				if(w[u][w1]!=999 && s[w1]==0)
				{
					if(d[w1]>d[u] + w[u][w1])
					{
						d[w1] = d[u] + w[u][w1];
						p[w1] = u;
					}
				}
			}
		}
		
		System.out.println("The shortest paths are-\n");
		for(i=1;i<=n;i++)
		{
			if(d[i]==999)
				System.out.println("Sorry,no path exists from" + v + "to" + i + "vertex");
			else
				System.out.println("The path from " + v + " to " + i + " is: " + d[i]);
		}
		
		System.out.println("Shortest group of paths are-\n");
		for(i=1;i<=n;i++)
		{
			if(i!=v && d[i]!=999)
			{
				System.out.print(i);
				j = p[i];
				while(p[j]!=0)
				{
					System.out.println("<------ " + j + " ");
					j = p[j];
				}
				System.out.println("<-----" + v + "\n");
			}
		}
	}
	
	public static void main(String[] args)
	{
		int n,i,j,v;
		int w[][] = new int[50][50];
		int s[] = new int[20];
		int d[] = new int[20];
		Scanner in= new Scanner(System.in);
		System.out.println("Enter the no.of vertices-\n");
		n = in.nextInt();
		System.out.println("Enter the cost matrix-\n");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				w[i][j] = in.nextInt();
		
		System.out.println("Enter the source vertex-\n");
		v = in.nextInt();
		
		Dijkstra d1 = new Dijkstra();
		
		d1.dijkstra(v, w, s, d, n);
	}
}