package Question4_2;

import java.util.LinkedList;

/**
 * 给定有向图，设计一个算法，找出两个结点之间是否存在一条路径。(广度优先遍历的具体实现还不是很理解，需要手动实现一遍)
 * 注：可以选择广度或深度优先遍历。深度优先实现比较简单，只需要简单的递归。
 */
public class Question {
	/**
	 * 枚举的状态，这种写法比较好，比直接命名整型常量好
	 */
	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

	/**
	 * 目前的示例采用的是广度优先搜索（其实也可以用深度优先搜索）
	 * @param g
	 * @param start 起始节点
	 * @param end 终止节点
	 * @return
	 */
    public static boolean search(Graph g,Node start,Node end) {  
        LinkedList<Node> q = new LinkedList<Node>();
        for (Node u : g.getNodes()) {
			// 标记这个节点没有访问过
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while(!q.isEmpty()) {
			// 也即 dequeue()
            u = q.removeFirst();
            if (u != null) {
	            for (Node v : u.getAdjacent()) {
	                if (v.state == State.Unvisited) {
	                    if (v == end) {
	                        return true;
	                    } else {
	                        v.state = State.Visiting;
	                        q.add(v);
	                    }
	                }
	            }
	            u.state = State.Visited;
            }
        }
        return false;
    }
}
