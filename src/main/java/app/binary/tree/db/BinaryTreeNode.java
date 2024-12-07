package app.binary.tree.db;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    public BinaryTreeNode(int value){
        this.value = value;
    }
}