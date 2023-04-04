package dfs_深度优先搜索;

import jdk.nashorn.internal.ir.CallNode;

import java.util.Objects;

public class CircularQueue {

    public static final int MAX_SIZE = 100;
    private CNode[] queue;
    private int size = 0;
    private int head = 0;
    private int row = 0;

    public CircularQueue() {
        queue = new CNode[MAX_SIZE];
    }

    void add(CNode newNode) throws Exception {
        if (head == (row +1) % MAX_SIZE){
            throw new Exception("队满!!");
        }else {
            queue[row] = newNode;
            row = (row + 1) % MAX_SIZE;
        }
    }

    void remove() throws Exception {
        if (head == (row + 1) % MAX_SIZE){
            throw new Exception("队中无元素!!");
        }else {
            head = (head + 1) % MAX_SIZE;
        }
    }

    CNode pop() throws Exception {
        if (head == (row + 1) % MAX_SIZE){
            throw new Exception("队中无元素!!");
        }else {
            head = (head + 1) % MAX_SIZE;
            return queue[head];
        }

    }

    static class CNode{
        String data;

        public CNode(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CNode)) return false;
            CNode cNode = (CNode) o;
            return Objects.equals(data, cNode.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

}
