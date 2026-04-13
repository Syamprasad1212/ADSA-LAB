import java.util.*;
public class dfsmatrixx {
     int vertex;
        int matrix[][];
        boolean visited[];
        dfsmatrixx(int vertex){
            this.vertex=vertex;
            matrix=new int[vertex][vertex];
            visited=new boolean[vertex];
        }
        void addEdge(int s,int d){
            matrix[d][s]=1;
            matrix[s][d]=1;
        }
        void dfs(int start){
            visited[start]=true;
            System.out.print(start+" ");
            for(int i=0;i<vertex;i++){
                if(matrix[start][i]==1 &&!visited[i]){
                    dfs(i);
                }
            }
        }
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("enter no of vertices:");
       int v=sc.nextInt();
       dfsmatrixx d=new dfsmatrixx(v);
         System.out.println("enter no of edges:");
         int e=sc.nextInt();
         for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int dd=sc.nextInt();
            d.addEdge(s,dd);
    }
    System.out.println("enter start vertex:");
    int st=sc.nextInt();
    d.dfs(st);
}
}
