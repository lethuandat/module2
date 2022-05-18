package ss10_dsa_list.bai_tap.linked_list;

public class MyLinkedList<T> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, T element) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(T e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(T e) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public T remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        Object data;
        if (index == 0) {
            data = temp.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        numNodes--;
        return (T) data;
    }

    public boolean remove(T e) {
        if (head.data.equals(e)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(e)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public int size() {
        return numNodes;
    }

    public T clone() {
        if (numNodes == 0) {
            throw new NullPointerException();
        }
        MyLinkedList<T> temp = new MyLinkedList<T>();
        Node tempNode = head;
        temp.addFirst((T) tempNode.data);
        tempNode = tempNode.next;
        while (tempNode != null) {
            temp.addLast((T) tempNode.data);
            tempNode = tempNode.next;
        }
        return (T) temp;
    }

    public boolean contains(T o) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        if (temp.data.equals(o)) {
            return true;
        }
        return false;
    }

    public int indexOf(T o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public T get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (T) temp.data;
    }

    public T getFirst() {
        return (T) head;
    }

    public T getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (T) temp;
    }

    public void clear() {
        head = null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
