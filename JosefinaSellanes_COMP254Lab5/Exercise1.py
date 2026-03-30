class Node:
    def __init__(self, value, parent=None):
        self.value = value
        self.left = None
        self.right = None
        self.parent = parent


class BinaryTree:
    def __init__(self, root=None):
        self.root = root

    def preorder_next(self, node):
        if node is None:
            return None

        if node.left:
            return node.left

        if node.right:
            return node.right

        while node.parent:
            parent = node.parent
            if parent.right and parent.right != node:
                return parent.right
            node = parent

        return None


if __name__ == "__main__":

    A = Node("A")
    B = Node("B", A)
    C = Node("C", A)
    D = Node("D", B)
    E = Node("E", B)

    A.left = B
    A.right = C
    B.left = D
    B.right = E

    tree = BinaryTree(A)

    node = A
    while node:
        print(node.value)
        node = tree.preorder_next(node)