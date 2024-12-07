package app.binary.tree;

import app.binary.tree.db.BinaryTreeNode;
import app.binary.tree.service.TreeService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeServiceTest {
    private final TreeService treeService = new TreeService();

    @Test
    void testBuildTree() {
        List<Integer> numbers = List.of(5, 3, 7, 2, 4, 6, 8);
        BinaryTreeNode root = treeService.buildTree(numbers);
        assertNotNull(root);
        assertEquals(5, root.getValue());
    }

    @Test
    void testSerializeTree() throws Exception {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeft(new BinaryTreeNode(3));
        root.setRight(new BinaryTreeNode(7));

        String serializedTree = treeService.serializeTree(root);
        assertTrue(serializedTree.contains("\"value\":5"));
    }
}
