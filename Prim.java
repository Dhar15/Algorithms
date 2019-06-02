import java.util.*;
public class Prim
{
	public static void main(String[] args)
	{
		int min=0,a=0,b=0,u=0,v=0,i,j,source,n;
		int ne = 1;
		int min_cost = 0;
		int cost[][] = new int[20][20];
		int visited[] = new int[20];
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no.of vertices-\n");
		n = s.nextInt();
		
		System.out.println("Enter the cost matrix-\n");
		for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
				cost[i][j] = s.nextInt();
		
		for(i=1;i<=n;i++)
			visited[i] = 0;
		
		System.out.println("Enter the source node-");
		source = s.nextInt();
		visited[source] = 1;
		System.out.println("Minimum cost spanning tree is-\n");
		while(ne<n)
		{
			min = 999;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(cost[i][j]<min)
						if(visited[i]==0)
							continue;
						else
						{
							min = cost[i][j];
							a = u = i;
							b = v = j;
						}
				}
			}
			
			if(visited[u]==0 || visited[v]==0)
			{
				ne++;
				System.out.println("\nEdge: " + ne + "\t" + a + "->" + b + "= " + min + "\n");
				min_cost += min;
				visited[b] = 1;
			}
			cost[a][b] = cost[b][a] = 999;
		}
		System.out.println("\nMinimum cost= " + min_cost + "\n");
	}
}