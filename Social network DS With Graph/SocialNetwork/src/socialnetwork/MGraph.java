package socialnetwork;

/**
 * To reprehend Graph We store Graph with (key,Value) Pair.
 * Key is vertex, Value is number of edge.
 * @author 
 * @param <K>
 */
public class MGraph<K extends Comparable<K>> implements Graph<K> {

    public Map<K, List<K>> adj; // Do not change this

    public MGraph() {
        adj = new BSTMap<>();
    }

    /**
     * Add new Node
     *
     * @param i
     * @return
     */
    @Override
    public boolean addNode(K i) {
        if (isNode(i)) {
            return false;
        } else {
            adj.insert(i, new LinkedList<>());
            return true;
        }
    }

    /**
     * Find given node if found return true.
     * @param i
     * @return
     */
    @Override
    public boolean isNode(K i) {
        return adj.getKeys().exists(i);
    }

    /**
     * Add edge in a specific vertex.
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean addEdge(K i, K j) {
        if (isNode(i) && isNode(j)) {
            List<K> listi = adj.retrieve(i).second;
            List<K> listj = adj.retrieve(j).second;
            if (!listi.exists(j) && !listj.exists(i)) {
                listi.insert(j);
                listj.insert(i);
                adj.update(i, listi);
                adj.update(j, listj);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Find if have edge between two node.
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean isEdge(K i, K j) {
        if (isNode(i) && isNode(j)) {
            List<K> listi = adj.retrieve(i).second;
            List<K> listj = adj.retrieve(j).second;
            return listi.exists(j) && listj.exists(i);
        }else{
            return false;
        }
    }

    /**
     * Return list of connected node 
     * @param i
     * @return
     */
    @Override
    public List<K> neighb(K i) {
        return adj.retrieve(i).second;
    }

    /**
     * Return number of edges are connected with specific node.
     * @param i
     * @return
     */
    @Override
    public int deg(K i) {
        if(isNode(i)){
            return adj.retrieve(i).second.size();
        }else{
            return -1;
        }
    }

    /**
     * Return all node list.
     * @return
     */
    @Override
    public List<K> getNodes() {
        return adj.getKeys();
    }
    
}
