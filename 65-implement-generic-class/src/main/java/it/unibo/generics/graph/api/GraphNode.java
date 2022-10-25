package it.unibo.generics.graph.api;

import java.util.HashSet;
import java.util.Set;

public class GraphNode<N> {
    private N node;
    private Set<N> edges = new HashSet<>();

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

    public boolean equals(GraphNode<N> n) {
        return this.node.equals(n.getNode());
    }

    protected void setEdges(Set<N> edges) {
        this.edges = edges;
    }
}
