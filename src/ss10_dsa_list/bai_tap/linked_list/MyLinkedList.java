package ss10_dsa_list.bai_tap.linked_list;

import javax.xml.soap.Node;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(Node head, int numNodes) {
        this.head = head;
        this.numNodes = numNodes;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }


}
