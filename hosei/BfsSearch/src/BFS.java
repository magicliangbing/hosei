import java.util.LinkedList;
/** 广度优先搜索 */
public class BFS {
public static Vertex[] vertex;
public static Vertex start;
public int num;
public BFS() {
   vertex = new Vertex[6];
   buildGraph();
}
public void BFSearch() {
   // 记录遍历结果
   LinkedList<Vertex> result = new LinkedList<Vertex>();
   // 初始化
   for (int i = 1; i <= num; i++) {
    vertex[i].color = "white";
    vertex[i].parent = null;
   }
   // 遍历的起始节点
   start.color = "gray";
   start.parent = null;
   result.offer(start);
   // 广度遍历的核心
   while (!result.isEmpty()) {
    Vertex u = result.poll();
    for (Vertex v : u.next) {
     if (v.color == "white") {
      v.color = "gray";
      v.parent = u;
      result.offer(v);
     }
    }
    u.color = "black";
    System.out.println(u.key);
   }
}
// 建立图的邻接表
public void buildGraph() {
   Vertex v1 = addVertex(1);
   Vertex v2 = addVertex(2);
   Vertex v3 = addVertex(3);
   Vertex v4 = addVertex(4);
   Vertex v5 = addVertex(5);
  
   addEdge(v1, v2);
   addEdge(v1, v3);
   addEdge(v1, v4);
   addEdge(v2, v4);
   addEdge(v2, v1);
   addEdge(v3, v1);
   addEdge(v4, v2);
   addEdge(v4, v1);
   addEdge(v4, v5);
   addEdge(v5, v4);
}
// 添加顶点
public Vertex addVertex(int key) {
   vertex[key] = new Vertex(key);
   num = num + 1;
   return vertex[key];
}
// 添加边
public void addEdge(Vertex v, Vertex next) {
   v.next.add(next);
}
public static void main(String[] args) {
   BFS b = new BFS();
   start = vertex[4];
   b.BFSearch();
}
}