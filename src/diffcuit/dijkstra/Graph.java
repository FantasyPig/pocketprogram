package diffcuit.dijkstra;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

    //邻接表
    private LinkedList<Edge> adj[];
    //顶点个数
    private int v;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sid, int eid, int w) {
        this.adj[sid].add(new Edge(sid, eid, w));
    }

    private class Edge {
        private int sid;
        private int eid;
        private int w;
        public Edge(int sid, int eid, int w) {
            this.sid = sid;
            this.eid = eid;
            this.w = w;
        }
    }

    private class Vertex implements Comparable<Vertex> {

        public int id;//顶点编号
        public int dist;//从起始点到这个顶点的距离
        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex o) {
            if (o.dist > this.dist) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public void dijkstra(int s,int t) {//从顶点s到顶点t的最短路径
        int[] predecessor = new int[this.v];//用来还原最短路径
        Vertex[] vertexs = new Vertex[this.v];//记录起始顶点到这个顶点的距离
        for (int i = 0; i < v; ++i) {
            vertexs[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue<Vertex> queue = new PriorityQueue<>();//小顶堆
        boolean inQueue[] = new boolean[this.v];
        queue.add(vertexs[s]);
        vertexs[0].dist = 0;
        inQueue[s] = true;
        while(!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            if (minVertex.id == t) {
                break;
            }
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {

            }
        }
    }


}
