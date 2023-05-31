class zad26 {
    int value;
    zad26 left;
    zad26 right;

    public zad26(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinarySearchTree26 {
    zad26 root;

    public BinarySearchTree26() {
        root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new zad26(value);
            return;
        }

        zad26 current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new zad26(value);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new zad26(value);
                    return;
                }
                current = current.right;
            }
        }
    }

    public boolean search(int value) {
        zad26 current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree26 bst = new BinarySearchTree26();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        boolean searchResult = bst.search(100);
        System.out.println("Search for value 40: " + searchResult);
    }
}
