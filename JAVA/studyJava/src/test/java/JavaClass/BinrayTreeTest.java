package JavaClass;

import javaclass.BinrayTree;
import javaclass.Node;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinrayTreeTest {

    private BinrayTree binrayTree;
    private Node root;
    static int[][] Graph;

    @BeforeEach
    void setup() {
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, null, null);
        Node node1 = new Node(1, node3, node4);
        Node node0 = new Node(0, node1, node2);
        binrayTree = new BinrayTree(node0);
        root = binrayTree.getNode();
    }

    @Test
    @DisplayName("노드 가져왔나?")
    void getNode() {
        Assertions.assertEquals(0, binrayTree.getNode().getValue());
    }

    @Test
    @DisplayName("BFS 테스트")
    void bfs() {
        List<Integer> list = binrayTree.bfs(root);
        Assertions.assertEquals(list, List.of(0, 1, 2, 3, 4));
        Assertions.assertNotSame(list, List.of(0, 1, 2, 3, 5));
    }

    @Test
    @DisplayName("DFS 테스트")
    void dfs() {
        System.out.print("0 1 3 4 2" + "\n");
        binrayTree.dfs(root);
    }

    @Test
    @DisplayName("중위 순회 테스트")
    void middleSearch() {
        System.out.print("3 1 4 0 2" + "\n");
        binrayTree.middleSearch(root);
    }

    @Test
    @DisplayName("후위 순회 테스트")
    void rearSearch() {
        System.out.println("3 4 1 2 0" + "\n");
        binrayTree.rearSearch(root);
    }
}