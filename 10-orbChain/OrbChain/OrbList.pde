public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
  *complete this method
  */
  void add(OrbNode orb){
    OrbNode tmp;
   if (mouseX < width/2){
    tmp = first.next;
    first.next = orb;
    orb.prev = first;
    orb.next = tmp;
    tmp.prev = orb; 
   } else{
    tmp = last.prev;
    last.prev = orb;
    orb.next = last;
    orb.prev = tmp;
    tmp.next = orb;
   }
  }

  /**
  *complete this method
  *process all nodes by running move.
  */
  void processAll() {
    OrbNode current = first;
    while (current != null){
      current.move();
      current = current.next; 
    }
  }
  /**
  *complete this method
  *Display all nodes by running their display().
  */
  void display() {
    OrbNode current = first;
    while (current != null){
      current.display();
      current = current.next; 
    }
  }
}
