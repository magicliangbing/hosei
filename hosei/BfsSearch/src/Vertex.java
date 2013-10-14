import java.util.ArrayList;
/** Í¼µÄ¶¥µã */
public class Vertex {
int key;
String color;
Vertex parent;

ArrayList<Vertex> next = new ArrayList<Vertex>();
public Vertex(int key) {
   this.key = key;
}
}
