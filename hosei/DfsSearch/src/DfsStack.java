import java.util.Stack;
public class DfsStack{
  private int  M= 8;
//1------5
//|      |
//2--4   6----8
//|      |   
//3------7
  private int matrix[][] ={
    {0, 1, 0, 0, 1, 0, 0, 0},
    {1, 0, 1, 1, 0, 0, 0, 0},
    {0, 1, 0, 0, 0, 0, 1, 0},
    {0, 1, 0, 0, 0, 0, 0, 0}, 
    {1, 0, 0, 0, 0, 1, 0, 0},
    {0, 0, 0, 0, 1, 0, 1, 1},
    {0, 0, 1, 0, 0, 1, 0, 0},
    {0, 0, 0, 0, 0, 1, 0, 0}
  };
   private boolean visited[];
   public DfsStack(){
      visited=new boolean[M+1];
   }
  private void DFS(){
   visited[1] = true;
   Stack< Integer> s=new Stack< Integer>();
   System.out.print("1 ");
   s.push(1);
   while(!s.empty()){
    int top = s.peek();
    int i=0;
   for(i = 1; i <= M; ++i){
    if(!visited[i] && matrix[top - 1][i - 1 ] == 1)
    {
     visited[i] = true;
     s.push(i);
     System.out.print(i+" ");
     break;
    }
   }
   if( i == M + 1){
    s.pop();
   }
  }
}
 public static void main(String args[]){ 
   new DfsStack().DFS();
  }
 }