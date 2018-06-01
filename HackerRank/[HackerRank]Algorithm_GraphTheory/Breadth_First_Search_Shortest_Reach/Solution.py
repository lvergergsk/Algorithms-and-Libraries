#!/bin/python3

import logging, sys
from collections import deque


class AdjacencyMatrix:
    M = []

    def __init__(self, num_of_node):
        self.M = [[False for _ in range(int(num_of_node))] for _ in range(int(num_of_node))]
        logging.debug('Adjacency matrix width: ' + str(len(self.M)))

    # e is tuple, representing edge
    def add_edge(self, u, v):
        logging.debug('Edge: (' + str(u) + ',' + str(v) + ')')
        logging.debug(self.M[0][1])
        self.M[int(u)][int(v)] = True
        self.M[int(v)][int(u)] = True

    def adjacent(self, u, v):
        return self.M[u][v]


if __name__ == "__main__":
    logging.basicConfig(stream=sys.stderr, level=logging.DEBUG)
    logging.disable(logging.DEBUG)

    # q: num of query
    q = int(input().strip())
    for a0 in range(q):
        # n: num of node, m: num of edge
        n, m = input().strip().split(' ')
        n, m = [int(n), int(m)]

        adj = AdjacencyMatrix(n)
        dist = [-1 for _ in range(n)]

        # adding edge
        for a1 in range(m):
            u_str, v_str = input().strip().split(' ')
            adj.add_edge(int(u_str) - 1, int(v_str) - 1)

        # read starting node
        s = int(input().strip())-1
        logging.debug('start = ' + str(s))

        # temporary variable for BFS
        queue = deque()
        visited = [False for _ in range(n)]

        # initialize BFS
        current_node = s
        visited[current_node] = True
        dist[current_node] = 0

        # BFS
        while True:
            for i in range(n):
                if adj.adjacent(current_node, i) and not visited[i]:
                    logging.debug('Current node = '+str(current_node))
                    logging.debug('dist[' + str(i) + '] = ' + str(dist[current_node]) + ' + 6')
                    dist[i] = dist[current_node] + 6
                    queue.append(i)
                    visited[i] = True
            if queue:
                current_node = queue.popleft()
            else:
                break

        for i in range(len(dist)):
            if i != s:
                print(dist[i], end=" ")
        print()
