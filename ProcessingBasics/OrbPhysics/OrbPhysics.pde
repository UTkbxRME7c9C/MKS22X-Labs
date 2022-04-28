     ArrayList<Orb>orbList;
    Orb center;
    boolean bg = true;
    byte mode = 0;
    boolean grav = true;
    final int BOUNCE = 0;
    final int ORBIT = 1;
    final int SPRING = 2;
    final float SPRING_CONSTANT = 0.015;
    final float SPRING_DAMPEN = 0.995;
    final float SPRING_LENGTH = 50.0;
    final float GRAV = 20.0;
    void setup() {
      size(1000, 800);
      orbList = new ArrayList<Orb>();
      center = new Orb(width/2,height/2,0,0,10);
    }
    void mouseClicked() {
      Orb a = new Orb((float)mouseX, (float)mouseY,5, 0, 20);
      orbList.add(a);
    }
    void keyPressed(){
        println(key);
       if(key == 8){
         orbList.clear();
       }
       if (key == 'b' || key == 'B'){
          if (bg){
            bg = false; 
          }else {bg = true;}
       }
       if (key == ' '){
        if (mode == SPRING){
          mode = BOUNCE;
        } else {mode++;}
       }
       if (key == 'g'){
         if (grav) {
           grav = false;
         } else{grav = true;}
       }
    }
    void draw() {
      if (bg) background(255);
      center.display();
      for (Orb o : orbList) {
        o.move();
        if (mode == BOUNCE){
         o.bounce(); 
        } else if (mode == ORBIT){
           center.attract(o);          
        } else if (mode == SPRING){
           center.attractSpring(o);
        }
        o.display();
      }
      fill(0);       
      if (mode == BOUNCE){
        text("BOUNCE",20, 20);
      } else if (mode == ORBIT){
        text("ORBIT",20, 20);
      } else if (mode == SPRING){
        text("SPRING",20, 20);
      }
      text(frameRate, 20 ,40);
      }
    
