package it.unibo.generics.graph.api;

import java.util.Set;

public class GraphNode<N> {
    private N node;
    private Set<N> edges;

    public GraphNode(N node) {
        this.node = node;
    }

    public N getNode() {
        return this.node;
    }

    public Set<N> getEdges() {
        return edges;
    }

    public void setNewEdge(N target) {
        edges.add(target);
    }
}
