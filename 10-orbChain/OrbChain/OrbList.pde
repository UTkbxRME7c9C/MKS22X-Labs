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
  void delete(OrbNode target){
    if (target != null && target != first && target != last){
      target.prev.next = target.next;
      target.next.prev = target.prev;
    }
  }
  OrbNode getNodeAt(int x, int y){
    OrbNode l = first;
    float val;
    while (l != null){
     val = dist(x,y,l.x,l.y);
     if(val < l.radius){
       break; 
     }
     l = l.next; 
    }
    return l;
  }
  /**
  *complete this method
  */
  void add(OrbNode orb){
    OrbNode tmp = first.next;
    first.next = orb;
    orb.prev = first;
    orb.next = tmp;
    tmp.prev = orb; 
  }
  void add(int xcor, OrbNode toBeAdded){
    OrbNode lower = first;
    while (lower != null){
     if (lower.x > xcor){
       break;
     }
     lower = lower.next; 
    }
    if (lower != null){
      OrbNode tmp = lower.prev;
      lower.prev = toBeAdded;
      toBeAdded.next = lower;
      toBeAdded.prev = tmp;
      tmp.next = toBeAdded;
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
