package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.GraphNode;

public class GraphImpl<N> implements Graph<N> {

    private Set<GraphNode<N>> nodes;

    public void addNode(N elem) {
        if (elem != null) {
            GraphNode<N> node = new GraphNode<>(elem);
            this.nodes.add(node);
        }
    }

    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            for (final var n : this.nodes) {
                if (n.getNode().equals(source) && this.nodes.contains(target)) {
                    n.setNewEdge(target);
                    return;
                }
            }
        }
    }

    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        return null;
    }

    public Set<N> linkedNodes(N node) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        return null;
    }
}
