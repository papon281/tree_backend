package app.binary.tree.service;

import app.binary.tree.db.BinaryTreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {
    public BinaryTreeNode buildTree(List<Integer> numbers) {
        BinaryTreeNode root = null;
        for (int number : numbers) {
            root = insert(root, number);
        }
        return root;
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    public String serializeTree(BinaryTreeNode root) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(root);
    }
}
