package app.binary.tree.db;


import app.binary.tree.constant.db.DbConstant.DbBinaryTree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = DbBinaryTree.TABLE_NAME)
public class BinaryTreeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbBinaryTree.ID, nullable = false)
    private Long id;

    @Column(name = DbBinaryTree.NUMBERS, nullable = false)
    private String inputNumbers; // Comma-separated numbers

    @Lob
    @Column(name = DbBinaryTree.TREE_STRUCTURE)
    private String treeStructure; // Serialized JSON representation of the tree
}