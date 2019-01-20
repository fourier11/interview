package Question4_2;

class Node {
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    public Question.State state;
    public Node(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new Node[adjacentLength];
    }
    /**
     * 这里限制了一个结点最多指向30个相邻结点，
     * @param x
     */
    public void addAdjacent(Node x) {
        if (adjacentCount < 30) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }
}
