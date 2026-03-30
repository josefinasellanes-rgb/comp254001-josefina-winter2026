class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def compute_height(node):
    if node is None:
        return -1 

    left_h = compute_height(node.left)
    right_h = compute_height(node.right)

    height = 1 + max(left_h, right_h)

    print(f"Node {node.value} → Height {height}")

    return height


if __name__ == "__main__":

    A = Node("A")
    B = Node("B")
    C = Node("C")
    D = Node("D")
    E = Node("E")

    A.left = B
    A.right = C
    B.left = D
    B.right = E

    compute_height(A)