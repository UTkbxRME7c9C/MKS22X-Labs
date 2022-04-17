    ArrayList<Orb>orbList;
    void setup() {
      size(1000, 700);
      orbList = new ArrayList<Orb>();
    }
    void mouseClicked() {
      Orb a = new Orb((float)mouseX, (float)mouseY,random(-3.0,3.0), random(-3.0,3.0), random(20,70));
      orbList.add(a);
    }
    void draw() {
      background(255);
      for (Orb o : orbList) {
        o.move();
        o.display();
      }
      fill(0);
      text(frameRate,20,20);
      text(orbList.size(),20,40);
      if (orbList.size() >= 1){
        text(orbList.get(orbList.size()-1).ySpeed, 20, 50);  
        text(orbList.get(orbList.size()-1).y, 20, 60);        
      }
    }
