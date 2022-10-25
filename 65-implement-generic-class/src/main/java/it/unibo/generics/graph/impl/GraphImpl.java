package it.unibo.generics.graph.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.GraphNode;
import it.unibo.generics.graph.api.ResearchNode;

public class GraphImpl<N> implements Graph<N> {

    private Set<GraphNode<N>> nodes = new HashSet<>();

    public void addNode(N elem) {
        if (elem != null) {
            GraphNode<N> node = new GraphNode<>(elem);
            this.nodes.add(node);
        }
    }

    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            for (final var n : this.nodes) {
                if (n.getNode().equals(source)) {
                    n.setNewEdge(target);
                    return;
                }
            }
        }
    }

    public Set<N> nodeSet() {
        Set<N> output = new HashSet<>();
        for (final var n : this.nodes) {
            output.add(n.getNode());
        }
        return output;
    }

    public Set<N> linkedNodes(N node) {
        for (final var n : this.nodes) {
            if (n.getNode().equals(node)) {
                return n.getEdges();
            }
        }
        
        return new HashSet<N>();
    }

    public List<N> getPath(N source, N target) {
        if (source == null || target == null) {
            return new LinkedList<N>();
        }

        Set<ResearchNode<N>> set = new HashSet<>();
        ResearchNode<N> start = null;

        for (final var node : this.nodes) {
            ResearchNode<N> fill = new ResearchNode<N>(node.getNode());
            fill.setEdges(node.getEdges());
            set.add(fill);

            if (fill.getNode().equals(source)) {
                start = fill;
            }
        }

        searchVisit(set, start);
        
        int targetStart = 0;
        int targetEnd = 0;
        for (final var node : set) {
            if (node.getNode().equals(target)) {
                targetStart = node.getStart();
                targetEnd = node.getEnd();
            }
        }

        if (targetStart == 0) {
            return new LinkedList<N>();
        }

        List<N> output = new LinkedList<N>();
        output.add(0, target);

        for (int i = targetStart - 1; i > 0; i--) {
            for (final var node : set) {
                if (node.getStart() == i && node.getEnd() > targetEnd) {
                    output.add(0, node.getNode());
                }
            }
        }

        return output;
    }

    private void searchVisit(Set<ResearchNode<N>> set, ResearchNode<N> node) {
        node.setStart();
        for (final var name : node.getEdges()) {
            for (final var adj : set) {
                if (adj.getNode().equals(name) && adj.getStart() == 0) {
                    searchVisit(set, adj);
                }
            }
        }
        node.setEnd();
    }

}
