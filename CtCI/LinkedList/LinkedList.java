public class LinkedList<T1>{
    Node<T1> head;
    public LinkedList(Node<T1> node){
        this.head = node;
    } 
    
    public LinkedList(Array<T1> values){
        Node<T1> current = head;
        for (int i = 0; i < values.length(); i++){
            current = new Node(values[i])
            current = current.next;
        }
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        Node<T1> current = this.head;
        do{
            output.append(current);
            current = current.next;
        } while (current != null);
        return output.toString();
    }
}
