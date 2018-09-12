/**
 * Created by haonantian on 12/2/16.
 */
public class PQ2<T> { // PQ2 class generates priority queues used to store passengers waiting st bus stops
    private Node firstNode;
    private int numberOfEntries;

    public PQ2(){
        firstNode = null;
        numberOfEntries = 0;
    }
    public int getNumberOfEntries(){
        return numberOfEntries;
    }
    public Node getFirstNode(){
        return firstNode;
    }
    public Node getNodeAt(int number){
        Node currentNode = firstNode;
        int counter = 0;
        while (currentNode != null && counter != number){
            currentNode = currentNode.getNext();
            counter ++;
        }
        return currentNode;
    }
    public boolean isEmpty(){
        if (firstNode==null){
            return true;
        } else {
            return false;
        }
    }
    public void add(T newObject){
        if (isEmpty()){
            Node newNode = new Node(newObject);
            firstNode = newNode;
            numberOfEntries ++;
        } else{
            Node currentNode = getNodeAt(numberOfEntries-1);
            Node newNode = new Node(newObject);
            currentNode.setNext(newNode);
            numberOfEntries ++;
        }
    }
    public T remove(){
        if (isEmpty()){
            return null;
        } else {
            Node currentNode = firstNode;
            Object result = currentNode.getData();
            firstNode = currentNode.getNext();
            currentNode.setNext(null);
            numberOfEntries --;
            return (T) result;
        }
    }
}
