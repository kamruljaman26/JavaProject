package socialnetwork;

/**
 * @author kamruljaman
 */
import java.io.File;
import java.util.Scanner;

public class Recommender {

    // Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
    public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
        PQK<Double, K> pqk = new PQKImp<>(k);
        //If Node is found
        if (g.isNode(i)) {
            List<K> l = g.getNodes();
            l.findFirst();
            while (true) {
                K key = l.retrieve();
                if (!g.isEdge(i, key)) {
                    if (i != key) {
                        pqk.enqueue((double)g.deg(key), key);
                    }
                }
                if (l.last()) {
                    break;
                } else {
                    l.findNext();
                }
            }
            return pqk;

        } else {
            return null;
        }
    }

    // Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
    public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
        PQK<Double, K> pqk = new PQKImp<>(k);
        //If Node is found
        List<K> neiList = g.neighb(i);

        List<K> nodeList = g.getNodes();

        if (g.isNode(i)) {
            nodeList.findFirst();
            while (true) { //Loop 1 Start
                int count = 0;
                K neikey = nodeList.retrieve();
                ////////////////////
                List<K> newNeiList = g.neighb(neikey);
                if (!g.isEdge(i, neikey)) {
                    if (neikey != i) {
                        neiList.findFirst();
                        //Loop 2
                        while (true) {
                            K newkey = neiList.retrieve();
                            if (newNeiList.exists(newkey)) {
                                count++;
                            }
                            if (neiList.last()) {
                                break;
                            } else {
                                neiList.findNext();
                            }
                        }
                        //end loop 2

                        if (count > 0) {
                            pqk.enqueue((double)count, neikey);
                        }
                    }
                }
                if (nodeList.last()) {
                    break;
                } else {
                    nodeList.findNext();
                }
            }//Loop 1 End

            if (pqk.length() < k) {
                PQK<Integer, K> pqk2 = new PQKImp<>(k);
                //If Node is found
                if (g.isNode(i)) {
                    List<K> l = g.getNodes();
                    l.findFirst();
                    while (true) {
                        K key = l.retrieve();
                        if (!g.isEdge(i, key)) {
                            if (i != key) {
                                pqk2.enqueue(g.deg(key), key);
                            }
                        }
                        if (l.last()) {
                            break;
                        } else {
                            l.findNext();
                        }
                    }
                    for (int j = pqk.length(); j <= k; j++) {                        
                        pqk.enqueue(0.0, pqk2.serve().second);
                    }
                }
            }

            return pqk;
        } else {
            return null;
        }
    }

    // Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
    public static Graph<Integer> read(String fileName) {
        try {
            Graph<Integer> g = new MGraph<>();
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                g.addNode(i);
                int j = scanner.nextInt();
                g.addNode(j);
                g.addEdge(i, j);
            }
            scanner.close();
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
