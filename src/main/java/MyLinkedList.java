public class MyLinkedList {
    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }

    }

    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode pop() {
        INode  tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = null;
        return tempNode;
    }

    public INode search(INode myNode){
        INode tempNode = head;
        while (tempNode.getNext()!=myNode){
            tempNode=tempNode.getNext();
        }
        return tempNode.getNext();
    }

    public void remove(INode removeNode) {
        INode myTempNode = head;
        while (myTempNode.getNext() != removeNode) {
            myTempNode = myTempNode.getNext();
        }
        INode myTempNode2 = myTempNode;
        myTempNode2 = myTempNode.getNext().getNext();
        myTempNode.setNext(myTempNode2);
    }

    public void getSize(INode head) {
        int nodeCount = 0;
        INode temp = head;
        while (temp != null) {
            nodeCount++;
            temp = temp.getNext();
        }
        System.out.println("Size: " + nodeCount);
    }

    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }
}
