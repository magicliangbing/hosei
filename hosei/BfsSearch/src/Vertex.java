import java.util.ArrayList;
/** ͼ�Ķ��� */
public class Vertex {
int key;
String color;
Vertex parent;

ArrayList<Vertex> next = new ArrayList<Vertex>();
public Vertex(int key) {
   this.key = key;
}
}
