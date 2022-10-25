package it.unibo.generics.graph.api;

import java.util.Set;

public class ResearchNode<N> extends GraphNode<N> {

    private static final int INIT_COUNT = 1;
    private static int counter = INIT_COUNT;

    private int start = 0;
    private int end = 0;
    
    public ResearchNode(N node) {
        super(node);
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setStart() {
        if (start == 0) {
            this.start = counter++;
        }
    }

    public void setEnd() {
        if (end == 0) {
            this.end = counter++;
        }
    }

    public void setEdges(Set<N> edges) {
        super.setEdges(edges);
    }
    
}
