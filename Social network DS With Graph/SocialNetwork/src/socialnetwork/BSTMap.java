package socialnetwork;

/**
 * BSTMap is a (Key,Value) Pair Data Structure. We can store data with a unique
 * key to identify them easily.
 *
 * @author @param <K>
 * @param <T>
 */
public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {

    public BSTNode<K, T> root; // Do not change this

    public BSTMap() {
        root = null;
    }

    /**
     * Return total number for node.
     *
     * @return
     */
    @Override
    public int size() {

        return nodeSize(root);
    }

    /**
     * Calculate total number of nude.
     *
     * @param node
     * @return
     */
    private int nodeSize(BSTNode<K, T> node) {
        if (node == null) {
            return 0;
        } else {
            return (nodeSize(node.left) + 1 + nodeSize(node.right));
        }
    }

    /**
     * BSTMap is full or not!
     *
     * @return
     */
    @Override
    public boolean full() {
        return false;
    }

    /**
     * Delete all node.
     */
    @Override
    public void clear() {
        root = null;
    }

    /**
     * Remove and add new Node
     *
     * @param k
     * @param e
     * @return
     */
    @Override
    public boolean update(K k, T e) {
        remove(k);
        return insert(k, e);
    }

    /**
     * Insert new data.
     *
     * @param k
     * @param e
     * @return
     */
    @Override
    public boolean insert(K k, T e) {
        if (root == null) {
            root = new BSTNode<>(k, e);
            return true;
        } else {
            if (findkey(k)) {
                return false;
            } else {
                root = insertNode(root, k, e);
                return true;
            }
        }
    }

    /**
     * Recursive function to insert an key into BST
     *
     * @param node
     * @param key
     * @param data
     * @return
     */
    private BSTNode<K, T> insertNode(BSTNode<K, T> node, K key, T data) {
        // if the root is null, create a new node an return it
        if (node == null) {
            return new BSTNode<>(key, data);
        }
        Integer kKey = (Integer) node.key;
        Integer nKey = (Integer) key;
        // if given key is less than the root node,
        // recur for left subtree
        if (nKey < kKey) {
            node.left = insertNode(node.left, key, data);
        } // else recur for right subtree
        else {
            node.right = insertNode(node.right, key, data);
        }

        return node;
    }

    /**
     * If map is empty then return true.
     *
     * @return
     */
    private boolean empty() {
        return root == null;
    }

    /**
     * Find Given Key is found then return true.
     *
     * @param key
     * @return
     */
    private boolean findkey(K key) {
        BSTNode<K, T> node = root;

        if (node == null) {
            return false;
        }

        while (node != null) {
            K nKey = (K) node.key;
            K kKey = (K) key;
            try {
                if (nKey == kKey) {
                    return true;
                } else if (nKey.compareTo(kKey) == 1) {

                    node = node.left;
                } else {
                    node = node.right;
                }
            } catch (Exception e) {
                System.err.println("Null Pointer Exception");
            }

        }
        return false;
    }

    /**
     * Find key, If found then remove the key and node.
     *
     * @param k
     * @return
     */
    @Override
    public boolean remove(K k) {
        Boolean removed = false;
        BSTNode<K, T> p;
        p = remove_aux(k, root, removed);//Not change
        root = p;
        return removed;
    }

    /**
     * Recursively find and delete key and data.
     *
     * @param key
     * @param p
     * @param flag
     * @return
     */
    private BSTNode<K, T> remove_aux(K key, BSTNode<K, T> p, Boolean flag) {
        BSTNode<K, T> q, child = null;
        if (p == null) {
            return null;
        }
        Integer pKey = (Integer) p.key;
        Integer nKey = (Integer) key;
        if (nKey < pKey) {
            p.left = remove_aux(key, p.left, flag); //go left
        } else if (nKey > pKey) {
            p.right = remove_aux(key, p.right, flag); //go right
        } else {
            flag = true;
            if (p.left != null && p.right != null) { //two children
                q = find_min(p.right);
                p.key = q.key;
                p.data = q.data;
                p.right = remove_aux(q.key, p.right, flag);
            } else {
                if (p.right == null) //one child
                {
                    child = p.left;
                } else if (p.left == null) //one child
                {
                    child = p.right;
                }
                return child;
            }
        }
        return p;
    }

    /**
     * Find the node with minimum value
     *
     * @param p
     * @return
     */
    private BSTNode<K, T> find_min(BSTNode<K, T> p) {
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * Find key and return status and data.
     *
     * @param k
     * @return
     */
    @Override
    public Pair<Boolean, T> retrieve(K k) {
        if (findkey(k)) {
            BSTNode<K, T> node = root;

            while (node != null) {
                Integer nKey = (Integer) node.key;
                Integer kKey = (Integer) k;
                if (nKey == kKey) {
                    return new Pair<>(true, node.data);
                } else if (nKey > kKey) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

        }
        return new Pair<>(false, null);
    }

    /**
     * Find Given Key is found then return true.
     *
     * @param key
     * @return
     */
    private boolean findPair(K key) {
        BSTNode<K, T> node = root;

        if (node == null) {
            return false;
        }

        while (node != null) {
            K nKey = (K) node.key;
            K kKey = (K) key;
            if (nKey == kKey) {
                return true;
                // } else if (nKey > kKey) {
            } else if (nKey.compareTo(kKey) == 1) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    /**
     * Create Node List.
     *
     * @return
     */
    @Override
    public List<K> getKeys() {
        List<K> list = new LinkedList<>();
        return createList(list, root);
    }

    /**
     * Create Node List : This one is recursive part.
     *
     * @param list
     * @param node
     * @return
     */
    private List<K> createList(List<K> list, BSTNode<K, T> node) {
        if (node == null) {
            return list;
        } else {
            createList(list, node.left);
            list.insert(node.key);
            createList(list, node.right);
        }
        return list;
    }

}
