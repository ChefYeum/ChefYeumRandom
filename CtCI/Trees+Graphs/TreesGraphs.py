class Graph:
    def __init__(self, children):
        self.children = children

class Node:
    def __init__(self, val, children = []):
        self.val = val
        self.children = children 

    def __repr__(self):
        pass

class TreesGraphs:
    @staticmethod
    def routeBetweenNodes(startNode: Node, endNode: Node) -> bool:
        # Does not work with graphs with cycles
        if not startNode.children: # where null children or empty children
            return False
        else:
            for c in startNode.children:
                if c is endNode:
                    return True
                else:
                    return TreesGraphs.routeBetweenNodes(c,endNode)

    @staticmethod
    def routeBetweenNodes(startNode: Node, endNode: Node) -> bool:

        queue = [startNode]
        visited: set = set(startNode)

        while queue: # is not empty..
            node: Node = queue.pop(0)
            visited.add(node)

            if node is endNode:
                return True
            else:
                for c in startNode.children:
                    if c not in visited:
                        queue.append(c)
        else:
            return False

    @staticmethod
    def minimalTree