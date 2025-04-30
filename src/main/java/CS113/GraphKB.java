package CS113;

import CS113.Interfaces.GraphInterface;
import CS113.Interfaces.ListInterface;

import java.util.List;

public class GraphKB implements GraphInterface {
    class Edge{
        String fromNode;
        String toNode;


        public Edge(String from, String to) {
            fromNode = from;
            toNode = to;
        }
    }


    ListInterface<String> nodes = new ArrayListKB<>();
    ListInterface<Edge> edges = new ArrayListKB<>();
    @Override
    public void addNode(String node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(String node1, String node2, boolean directed) {
        if(!nodes.contains(node1) || !nodes.contains(node2)){
            return;
        }
        Edge edge = new Edge(node1, node2);
        if(!edges.contains(edge)){
            edges.add(edge);
        }
        if(!directed){
            edge = new Edge(node2, node1);
            if(!edges.contains(edge)){
                edges.add(edge);
            }
        }
    }

    @Override
    public ListInterface<String> getNeighbors(String node) {
        ListInterface<String> neighbors = new ArrayListKB<>();
        for(int i = 0; i < edges.size(); i++){
            if(edges.get(i).fromNode.equals(node)){
                neighbors.add(edges.get(i).toNode);
            }
        }

        return neighbors;
    }

    @Override
    public void printGraph() {
        int n = nodes.size();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                String first = nodes.get(i);
                String second = nodes.get(j);
                ListInterface<String> neighbors = getNeighbors(first);
                if(!neighbors.contains(second)){
                    System.out.print("1");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.print("\n");
        }
    }
}
