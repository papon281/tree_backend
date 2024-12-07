package app.binary.tree.constant.db;

public class DbConstant {
    private DbConstant() {

    }

    public static class DbCommon {
        public static final String ID = "id";

        DbCommon() {
        }
    }

    public static class DbBinaryTree extends DbCommon {
        public static final String TABLE_NAME = "tree";
        public static final String NUMBERS = "numbers";
        public static final String TREE_STRUCTURE = "tree_structure";
    }

    public static class DbBinaryTreeNode extends DbCommon {
        public static final String TABLE_NAME = "node";
        public static final String NUMBERS = "numbers";
        public static final String TREE_STRUCTURE = "tree_structure";
    }
}