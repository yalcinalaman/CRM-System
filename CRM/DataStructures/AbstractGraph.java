package DataStructures;
public abstract class AbstractGraph implements Graph{

    private int numV;
    private boolean directed;

    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph
     * @param numV The number of vertices
     * @param directed The directed flag
     */
    public AbstractGraph(int numV, boolean directed){
        this.numV = numV;
        this.directed = directed;
    }

    /**
     * Return the number of vertices
     * @return the number of vertices
     */
    public int getNumV(){
        return numV;
    }

    /**
     * Return whether this is a directed graph
     * @return true if this is a directed graph
     */
    public boolean isDirected(){
        return directed;
    }
}
