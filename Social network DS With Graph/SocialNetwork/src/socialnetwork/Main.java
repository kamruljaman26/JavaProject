package socialnetwork;

public class Main {

    private static void testPQK() {
        {
            System.out.println("-------------------");
            PQKImp<Integer, String> pq = new PQKImp<Integer, String>(6);

            pq.enqueue(5, "A");
            pq.enqueue(3, "B");
            pq.enqueue(2, "C");
            pq.enqueue(1, "D");
            pq.enqueue(2, "E");
            pq.enqueue(4, "F");
            pq.enqueue(6, "G");
            pq.enqueue(7, "H");
            pq.enqueue(8, "I");
            pq.enqueue(8, "J");
            pq.enqueue(7, "K");
            pq.enqueue(6, "L");
            pq.enqueue(5, "M");
            pq.enqueue(3, "M");
            pq.enqueue(4, "l");
            pq.enqueue(7, "q");
            pq.enqueue(9, "q");
            pq.enqueue(4, "o");

            while (pq.length() > 0) {
                Pair<Integer, String> p = pq.serve();
                System.out.println(p.first + "\t" + p.second);
            }
            System.out.println("-------------------");

        }

        {
            System.out.println("-------------------");
            PQK<Integer, String> pq = new PQKImp<Integer, String>(6);

            pq.enqueue(5, "A");
            pq.enqueue(3, "B");
            pq.enqueue(2, "C");
            pq.enqueue(1, "D");
            pq.enqueue(2, "E");
            pq.enqueue(4, "F");
            pq.enqueue(6, "G");
            pq.enqueue(7, "H");
            pq.enqueue(8, "I");
            pq.enqueue(8, "J");
            pq.enqueue(7, "K");
            pq.enqueue(6, "L");
            pq.enqueue(5, "M");
            pq.enqueue(3, "M");
            pq.enqueue(4, "l");
            pq.enqueue(7, "q");
            pq.enqueue(9, "q");
            pq.enqueue(4, "o");

            pq.serve();
            pq.serve();

            pq.enqueue(4, "o");
            pq.enqueue(10, "z");
            pq.enqueue(10, "c");
            pq.enqueue(11, "b");
            while (pq.length() > 0) {
                Pair<Integer, String> p = pq.serve();
                System.out.println(p.first + "\t" + p.second);
            }
            System.out.println("-------------------");

        }
    }

    private static void testMap() {

        {

            System.out.println("-------------------");
            Map<Integer, Integer> m = new BSTMap<Integer, Integer>();
//			for (int i = 100; i > 0; i--) {
//				
//				m.insert(i % 13, i);
//			}

            m.insert(9, 999);
            m.insert(5, 004);
            m.insert(22, 6540);
            m.insert(3, 60054);
            m.insert(7, 6544);
            m.insert(8, 65454);
            m.insert(6, 5656);
            m.insert(4, 622);
            m.insert(15, 436);
            m.insert(44, 326);
            m.insert(50, 436);
            m.insert(50, 56);
            m.insert(0, 6666);
            m.insert(15, 60);
            m.insert(42, 6067);

            m.remove(8);

            System.out.println("size is -> " + m.size()); // 13
            List<Integer> l = m.getKeys();
            l.findFirst();
            while (true) {
                int k = l.retrieve();
                System.out.println(k);
                if (l.last()) {
                    break;
                } else {
                    l.findNext();
                }
            }
            System.out.println("-------------------");

        }
        {

            System.out.println("-------------------");
            Map<Integer, Integer> m = new BSTMap<Integer, Integer>();
//			for (int i = 100; i > 0; i--) {
//				
//				m.insert(i % 13, i);
//			}

            m.insert(9, 999);
            m.insert(5, 004);
            m.insert(22, 6540);
            m.insert(3, 60054);
            m.insert(7, 6544);
            m.insert(8, 65454);
            m.insert(6, 5656);
            m.insert(4, 622);
            m.insert(15, 436);
            m.insert(44, 326);
            m.insert(50, 436);
            m.insert(50, 56);
            m.insert(0, 6666);
            m.insert(15, 60);
            m.insert(42, 6067);

            m.remove(5);

            System.out.println("size is -> " + m.size()); // 13
            List<Integer> l = m.getKeys();
            l.findFirst();
            while (true) {
                int k = l.retrieve();
                System.out.println(k);
                if (l.last()) {
                    break;
                } else {
                    l.findNext();
                }
            }
            System.out.println("-------------------");

        }

        {

            System.out.println("-------------------");
            Map<Integer, Integer> m = new BSTMap<Integer, Integer>();
//			for (int i = 100; i > 0; i--) {
//				
//				m.insert(i % 13, i);
//			}

            m.insert(9, 999);
            m.insert(5, 004);
            m.insert(22, 6540);
            m.insert(3, 60054);
            m.insert(7, 6544);
            m.insert(8, 65454);
            m.insert(6, 5656);
            m.insert(4, 622);
            m.insert(15, 436);
            m.insert(44, 326);
            m.insert(50, 436);
            m.insert(50, 56);
            m.insert(0, 6666);
            m.insert(15, 60);
            m.insert(42, 6067);
            System.out.println("value of key 22 before update is  " + m.retrieve(22).second);
            m.update(22, 90);
            System.out.println("value of key 22 after update is " + m.retrieve(22).second);

            List<Integer> l = m.getKeys();
            l.findFirst();
            while (true) {
                int k = l.retrieve();
                System.out.println(k);
                if (l.last()) {
                    break;
                } else {
                    l.findNext();
                }
            }
            System.out.println("-------------------");

        }
        {

            System.out.println("-------------------");
            Map<Integer, Integer> m = new BSTMap<Integer, Integer>();
//			for (int i = 100; i > 0; i--) {
//				
//				m.insert(i % 13, i);
//			}

            m.insert(9, 999);
            m.insert(5, 004);
            m.insert(22, 6540);
            m.insert(3, 60054);
            m.insert(7, 6544);
            m.insert(8, 65454);
            m.insert(6, 5656);
            m.insert(4, 622);
            m.insert(15, 436);
            m.insert(44, 326);
            m.insert(50, 436);
            m.insert(50, 56);
            m.insert(0, 6666);
            m.insert(15, 60);
            m.insert(42, 6067);
            m.remove(9);

            List<Integer> l = m.getKeys();
            l.findFirst();
            while (true) {
                int k = l.retrieve();
                System.out.println(k);
                if (l.last()) {
                    break;
                } else {
                    l.findNext();
                }
            }
            System.out.println("-------------------");

        }

    }

    private static void testGraph() {
        {
            System.out.println("-------------------");
            int n = 8;
            Graph<Integer> g = new MGraph<Integer>();

//		
//		for (int i = 0; i < n; i++) {
//			g.addNode(i);
//		}
//
//		for (int i = 0; i < n; i++) {
//			g.addEdge(i, (i + 1) % n);
//		}
            System.out.println("------- Adding nodes -------");
            System.out.println("Add node 5 " + g.addNode(5));
            System.out.println("Add node 4 " + g.addNode(4));
            System.out.println("Add node 3 " + g.addNode(3));
            System.out.println("Add node 2 " + g.addNode(2));
            System.out.println("Add node 1 " + g.addNode(1));
            System.out.println("Add node 1 " + g.addNode(1));
            System.out.println("Add node 5 " + g.addNode(5));
            System.out.println("------- done Adding nodes -------");
            System.out.println();
            System.out.println("------- Check isNode -------");
            System.out.println("node 10 exist " + g.isNode(10));
            System.out.println("node 4 exist " + g.isNode(4));
            System.out.println("node 3 exist " + g.isNode(3));
            System.out.println("node 2 exist " + g.isNode(2));
            System.out.println("node 1 exist " + g.isNode(1));
            System.out.println("node 0 exist " + g.isNode(0));
            System.out.println("------ done Checking  isNode --------");
            System.out.println();
            System.out.println("------ Adding edges --------");
            System.out.println("add edge (5,4) " + g.addEdge(5, 4));
            System.out.println("add edge (5,3) " + g.addEdge(5, 3));
            System.out.println("add edge (5,1) " + g.addEdge(5, 1));
            System.out.println("add edge (4,2) " + g.addEdge(4, 2));
            System.out.println("add edge (4,1) " + g.addEdge(4, 1));
            System.out.println("add edge (3,4) " + g.addEdge(3, 4));
            System.out.println("add edge (3,1) " + g.addEdge(3, 1));
            System.out.println("add edge (3,2) " + g.addEdge(3, 2));
            System.out.println("add edge (2,5) " + g.addEdge(2, 5));
            System.out.println("add edge (2,4) " + g.addEdge(2, 4));
            System.out.println("add edge (2,3) " + g.addEdge(2, 3));
            System.out.println("add edge (2,1) " + g.addEdge(2, 1));
            System.out.println("------ done Adding edges --------");
            System.out.println("Is Edage");
            System.out.println("is edge (2,3) " + g.isEdge(5, 7));

            System.out.println();
            System.out.println("------ retrieve degree of all keys --------");
            System.out.println("degree of key 1 is " + g.deg(1));
            System.out.println("degree of key 2 is " + g.deg(2));
            System.out.println("degree of key 3 is " + g.deg(3));
            System.out.println("degree of key 4 is " + g.deg(4));
            System.out.println("degree of key 5 is " + g.deg(5));
            System.out.println("degree of key 6 is " + g.deg(6));
            System.out.println("------ done --------");
            System.out.println();
            System.out.println("------ print all the keys and their neighbors --------");

            List<Integer> l = g.getNodes();
            l.findFirst();
            while (!l.last()) {
                int i = l.retrieve();
                List<Integer> ni = g.neighb(i);
                if (!ni.empty()) {
                    ni.findFirst();
                    while (true) {
                        int j = ni.retrieve();
                        System.out.println(i + "\t" + j);
                        if (ni.last()) {
                            break;
                        } else {
                            ni.findNext();
                        }
                    }
                }
                if (l.last()) {
                    break;
                } else {
                    l.findNext();
                }

            }
            int i = l.retrieve();
            List<Integer> ni = g.neighb(i);
            if (!ni.empty()) {
                ni.findFirst();
                while (true) {
                    int j = ni.retrieve();
                    System.out.println(i + "\t" + j);
                    if (ni.last()) {
                        break;
                    } else {
                        ni.findNext();
                    }
                }
            }
            System.out.println("------ done printing all the keys and their neighbors --------");

            System.out.println("-------------------");

        }

    }

    private static void testRecommender() {
        System.out.println("-------------------");
        Graph<Integer> g = Recommender.read("src/graph.txt");
        {
            PQK<Double, Integer> top = Recommender.recommendPop(g, 3, 4);
            while (top.length() > 0) {
                Pair<Double, Integer> e = top.serve();
                System.out.println(e.second + "\t" + e.first);
            }
        }
        System.out.println("----------");
        {
            PQK<Double, Integer> top = Recommender.recommendCN(g, 3, 4);
            while (top.length() > 0) {
                Pair<Double, Integer> e = top.serve();
                System.out.println(e.second + "\t" + e.first);
            }
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        testPQK();
        //testMap();
        //testGraph();
        testRecommender();
    }
}
