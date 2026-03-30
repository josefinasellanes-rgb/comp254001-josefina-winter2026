class HeapPriorityQueue:
    def __init__(self):
        self.heap = []

    def parent(self, j):
        return (j - 1) // 2

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def upheap(self, j):
        if j == 0:
            return

        p = self.parent(j)

        if self.heap[j] < self.heap[p]:
            self.swap(j, p)
            self.upheap(p) 

    def insert(self, value):
        self.heap.append(value)
        self.upheap(len(self.heap) - 1)


if __name__ == "__main__":
    pq = HeapPriorityQueue()

    values = [5, 3, 8, 1, 2]

    for v in values:
        pq.insert(v)

    print("Heap:", pq.heap)