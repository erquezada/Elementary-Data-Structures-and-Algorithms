import java.io.File;
import java.io.FileWriter;


class PlanetLinkedList{
    private Planet head;

    PlanetLinkedList(){}

    PlanetLinkedList(Planet initial){
        head=initial;
    }
    PlanetLinkedList(String n, long d, int m){
        head = new Planet(n, d, m);
    }
    void insert(Planet insertee, int pos){
        if(pos == 0) {
          insertee.next = head;
          head = insertee;
        } else {
            Planet initial = head;
            int i = 0;
            while(initial!=null) {
                if(i==pos -1) {
                    Planet prev = initial.next;
                    initial.next = insertee;
                    insertee.next = prev;
                    break;
                }
                initial = initial.next;
                i++;
            }
        }
    }
    void remove(int pos) {
      if (head == null) return; // if list is empty, return
  
      if (pos == 0) { // if removing the head node
          head = head.next; // set the next node as the new head
          return;
      }
  
      Planet current = head;
      Planet prev = null;
      int i = 0;
  
      while (current != null && i < pos) { // iterate until the node at the specified position is reached
          prev = current;
          current = current.next;
          i++;
      }
  
      if (current == null) return; // if position is invalid, return
  
      prev.next = current.next; // remove the node at the specified position
  }  
    int countNodes(){
        int count = 0; // counter to count number of planets
        Planet initial = head; // initialize new planet to be head of list
        while(initial != null) {
            initial = initial.next; // update node
            count++; // update counter
        }
        return count; // return count
    }
    void printLL(){
        Planet initial = head; // initialize new planet to be head of list
        while (initial != null) { // while there is a planet in the list iterate through list
            System.out.println(initial.toString()); // print list
            initial = initial.next; // update node
            System.out.println("*******"); // print separator
        }
    }
    void swap(int pos1, int pos2) {
      int countLength = countNodes();
      // if the positions are out of bounds
      if (pos1 < 0 || pos1 >= countLength || pos2 < 0 || pos2 >= countLength || pos1 == pos2) {
          return;
      }
  
      // Find the nodes to be swapped
      Planet temp1 = head, prev1 = null;
      for (int i = 0; i < pos1 && temp1 != null; i++) {
          prev1 = temp1;
          temp1 = temp1.next;
      }
      Planet temp2 = head, prev2 = null;
      for (int i = 0; i < pos2 && temp2 != null; i++) {
          prev2 = temp2;
          temp2 = temp2.next;
      }
  
      // If either node is null, return
      if (temp1 == null || temp2 == null) {
          return;
      }
  
      // Perform the swap
      Planet next1 = temp1.next, next2 = temp2.next;
      temp1.next = next2;
      temp2.next = next1;
      if (prev1 != null) {
          prev1.next = temp2;
      } else {
          head = temp2;
      }
      if (prev2 != null) {
          prev2.next = temp1;
      } else {
          head = temp1;
      }
  }
    void search (String n){
        // Write your code here.
        Planet initial = head;  // initialize new planet to be head of list
        while (initial != null) { // while there is a planet in the list iterate through list
            if(initial.getName().equalsIgnoreCase(n)) { // if string is a match
                return;
            }
            initial = initial.next; // update node
        }
    }
    void search(long d){
        // Write your code here.
        Planet initial = head;  // initialize new planet to be head of list
        while (initial != null) { // while there is a planet in the list iterate through list
            if(head.getDiameter()==d) { // if diameter is a match print it
                System.out.println(d);
                return;
            }
            initial = initial.next; // update node
        }
    }
    void writeLinkedListToFile(String filename) {
        // Write your code here.
        try{
            File readFile = new File(filename); // read file
            FileWriter fileWriter = new FileWriter(readFile); // write to output file

            Planet temp = head;  // initialize new planet to be head of list
            while(temp != null) { // while there is a planet in the list iterate through list
                // write required data to output file
                fileWriter.write(temp.getName() + "\n");
                fileWriter.write(temp.getDiameter() + "\n");
                fileWriter.write(temp.getMoon() + "\n");
                temp = temp.next;
                fileWriter.flush();
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}