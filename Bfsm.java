import java.util.*;
public class Bfsm {
    int vertex;
    ArrayList<ArrayList<Integer>> adjList;
    boolean visited[];
    Bfsm(int vertex){
        this.vertex=vertex;
        adjList=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            adjList.add(new ArrayList<>());
        }
        visited=new boolean[vertex];
    }
    void addEdge(int s,int d){
        adjList.get(s).add(d);
        adjList.get(d).add(s)   ;
    }
    void bfs(int start){
        Queue<Integer>q=new LinkedList<>();
        visited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int node=q.poll();
            System.out.print(node+" ");
            for(Integer neighbor : adjList.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.add(neighbor);
                }
            }
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of vertices:");
        int v = sc.nextInt();
        Bfsm b=new Bfsm(v);
        System.out.println("enter no of edges:");
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            System.out.println("enter edge");
            int s = sc.nextInt();
            int d = sc.nextInt();
            b.addEdge(s,d);
        }
        System.out.println("enter start vertex:");
        int start = sc.nextInt();
        b.bfs(start);
    }
}

