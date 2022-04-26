     ArrayList<Orb>orbList;
    Orb center;
    boolean bg = true;
    byte mode = 0;
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
        if (mode == 1){
          mode = 0;
        } else {mode = 1;}
       }
    }
    void draw() {
      if (bg) background(255);
      center.display();
      for (Orb o : orbList) {
        o.move();
        if (mode == 0){
         o.gravity(); 
        } else if (mode == 1){
           center.attract(o);          
        }
        o.display();
      }
      fill(0);       
      if (mode == 0){
        text("GRAVITY",20, 20);
      } else{text("ORBIT",20, 20);}
      text(frameRate, 20 ,40);
      }
    
