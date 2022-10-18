
class DeleteNodeFromList {

    //Create a node for DDL
    static class Node{
        String data;
        Node prev;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    int size = 0;

    //Initialize head and tail for DDL
    Node head = null;
    Node tail = null;



    //Create addNewNode() method to add a node into DDL
    public void addNewNode(String data) {

        //Creating node
        Node newNode = new Node(data);

        //Checking whether our DDL is empty or not
        if(head == null) {
            //The newNode is pointed by both head or tail
            head = newNode;
            tail = newNode;
            //It is first node so prev will point to null
            head.prev = null;
            //It is also last node so tail's next will point to null
        }
        //Execute when the DDL is not empty
        else {

            //The newly created node will be the last node, so now tail's next will point to that newly created node
            tail.next = newNode;
            //The tail is pointing to the second last node so the newly created node's prev will point to tail
            newNode.prev = tail;
            //The newly created node will become new tail because it will be last node in the DDL
            tail = newNode;
            //The newly created node will be the last node so tail's next will be null
        }
        tail.next = null;
        //Increment the size of DDL
        size++;
    }

    //Create deleteFirstNode() method for deleting first node from DDL
    public void deleteFirstNode(){
        head = head.next;
    }

    //Create deleteLastNode() method for deleting last node from DDL
    public void deleteLastNode(){
        tail = tail.prev;
    }

    //Create deleteNodeAtSpecifiedLocation() method for deleting a node from DDL
    public void deleteNodeAtSpecifiedLocation(int position){

        //Check whether the DDL is empty or not
        if(head == null || position>size) {
            System.out.println("\n" +position +"th position is not available\n");
        }
        //Execute when the Playlist is not empty
        else {
            if(position == 1){

                //Call deleteFirstNode() method to delete first node from the DDL
                deleteFirstNode();

                //Decrement the size of Playlist
                size--;

            }else if(position == size){
                //Call deleteLastNode() method to delete last node from the DDL
                deleteLastNode();

                //Decrement the size of DDL
                size--;

            }else{
                //current node will point to head
                Node current = head;

                //Iterate list till current points to the specified track
                for(int i = 1; i < position; i++){
                    current = current.next;
                }

                //Delete track pointed by current
                current.next.prev = current.prev;
                current.prev.next = current.next;

            }
            System.out.println(position +" Track is deleted successfully from playlist");
        }
    }


    //Create showData() method for displaying data of DDL
    public void showPlaylist() {
//        intialize a new node current that will point to head

        Node current = head;
//Check whether the DDL is empty or not

        if(head == null) {
            //Print a statement and pass the control flow into the main() method
            System.out.println("List is empty");
            return;
        }
        //Print a statement
        System.out.println("track of playlist: ");
        //Iterate the double linked list using while

        while(current != null) {
            //Print the track on that particular node and then increment the pointer for indicating next node
            System.out.print(current.data + "\n");
            current = current.next;
        }

    }

    public static void main(String[] args) {

        DeleteNodeFromList Track = new DeleteNodeFromList();

        //Add nodes into the DDL
        Track.addNewNode("New York");
        Track.addNewNode("Los Angeles");
        Track.addNewNode("Chicago");
        Track.addNewNode("Houston");
        Track.addNewNode("Phoenix");

        //Call showData() method for displaying playlist track
        Track.showPlaylist();

        //Delete Track from the playlist
        Track.deleteNodeAtSpecifiedLocation(2);
        Track.deleteNodeAtSpecifiedLocation(1);
        Track.deleteNodeAtSpecifiedLocation(5);

        //Call showPlaylist() method for displaying Playlist
        Track.showPlaylist();
    }
}