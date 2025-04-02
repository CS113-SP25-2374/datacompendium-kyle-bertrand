package CS113;

import CS113.Interfaces.BinarySearchTreeInterface;

public class BinarySearchTreeKB <E extends Comparable<E>> implements BinarySearchTreeInterface<E> {


        }
    }


        if (node == null) {
        }
        }
        }
        return node;
    }

    @Override
    }

    @Override
    public boolean delete(E value) {
        return false;
    }

    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public E findMin() {
    }

    @Override
    public E findMax() {
    }

    @Override
    public int height() {
        return heightRecursive(root);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
    }

        if (node == null) {
            return "";
        }
        String left = toStringRecursive(node.left);
        String right = toStringRecursive(node.right);
        return left + center + right;
    }

}
