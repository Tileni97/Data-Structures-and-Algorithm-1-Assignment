class DeleteNodeFromList {

    //Create a node class to store data and next node address
    static class Node{
        String data;
        Node prev;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    int size = 0;

    //Initialize head and tail of the list
    Node head = null;
    Node tail = null;


    //Create addNewNode() method to add new node to the list at the end of the list
    public void addNewNode(String data) {

        //Creating a new node and assigning data to it
        Node newNode = new Node(data);

        //Checking whether the list is empty or not
        if(head == null) {
            //The newNode is pointed by both head or tail
            head = newNode;
            tail = newNode;
            //It is first node so prev will point to null
            head.prev = null;
            //It is also last node so next will point to null
        }
        //Execute when the list is not empty
        else {
            //The newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's prev will point to tail
            newNode.prev = tail;
            //newNode will become new tail of the list
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }

        tail.next = null;
        //Increment the size of the list by 1
        size++;
    }

    //Create deleteFirstNode() method to delete first node of the list
    public void deleteFirstNode(){
        head = head.next;
    }

    //Create deleteLastNode() method to delete last node of the list
    public void deleteLastNode(){
        tail = tail.prev;
    }

    //Create deleteNodeAtSpecifiedLocation() method to delete node at specified location
    public void deleteNodeAtSpecifiedLocation(int position){

        //Check whether the list is empty or not
        if(head == null || position>size) {
            System.out.println("\n" +position +"th position is not available\n");
        }
        //Execute when the list is not empty
        else {
            if(position == 1){

                //Call deleteFirstNode() method to delete first node of the list
                deleteFirstNode();

                //Decrement the size of Playlist
                size--;

            }else if(position == size){
                //Call deleteLastNode() method to delete last node of the list
                deleteLastNode();

                //Decrement the size of Playlist
                size--;

            }else{
                //current node will point to head
                Node current = head;

                //Iterate list till current points to position
                for(int i = 1; i < position; i++){
                    current = current.next;
                }

                //Delete track from the list by pointing current's prev to current's next
                current.next.prev = current.prev;
                current.prev.next = current.next;

            }
            System.out.println(position +" Track is deleted successfully from playlist"); //Display message
        }
    }


    //Create showData() method for displaying data of the list
    public void showPlaylist() {
//        initialise a new node current that will point to head

        Node current = head;
//Check whether the list is empty or not

        if(head == null) {
            //Print a statement and return from the method if the list is empty
            System.out.println("List is empty");
            return;
        }
        //Print a statement if the list is not empty and return from the method
        System.out.println("track of playlist: ");
        //Iterate the list till current points to null

        while(current != null) {
            //Print the data of the current node and point current to next node of the list
            System.out.print(current.data + "\n");
            current = current.next;
        }

    }

    public static void main(String[] args) {
//        Create a new object of DeleteNodeFromList class
        DeleteNodeFromList Track = new DeleteNodeFromList();

        //Add nodes to the list by calling addNewNode() method of DeleteNodeFromList class
        Track.addNewNode("Monalisa - Lil Nas X");
        Track.addNewNode("Dynamite - BTS");
        Track.addNewNode("Blinding Lights - The Weeknd");
        Track.addNewNode("The Box - Roddy Ricch");
        Track.addNewNode("Savage - Megan Thee Stallion");

        //Call showData() method of DeleteNodeFromList class to display data of the list
        Track.showPlaylist();

        //Delete Track from the playlist by calling deleteNodeAtSpecifiedLocation() method of DeleteNodeFromList class
        Track.deleteNodeAtSpecifiedLocation(2);
        Track.deleteNodeAtSpecifiedLocation(1);
        Track.deleteNodeAtSpecifiedLocation(5);

        //Call showPlaylist() method for displaying Playlist after deleting Track
        Track.showPlaylist();
    }
}