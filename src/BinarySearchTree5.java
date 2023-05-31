class zad5 {
    int value;
    zad5 left;
    zad5 right;

    public zad5(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinarySearchTree5 {
    zad5 root;

    public BinarySearchTree5() {
        root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new zad5(value);
            return;
        }

        zad5 current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new zad5(value);
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new zad5(value);
                    return;
                }
                current = current.right;
            }
        }
    }

    public boolean search(int value) {
        zad5 current = root;
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
        BinarySearchTree5 bst = new BinarySearchTree5();
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
