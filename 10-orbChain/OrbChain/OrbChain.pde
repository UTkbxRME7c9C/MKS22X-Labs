final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
}
void keyPressed(){
  switch(key){
    case '1':
      SPRING_CONSTANT = SPRING_CONSTANT*1.1;
      break;
    case '2':
      SPRING_CONSTANT = SPRING_CONSTANT*0.9;
      break;
    case '3':
      SPRING_DAMPEN = SPRING_DAMPEN*1.1;
      break;
    case '4':
      SPRING_DAMPEN = SPRING_DAMPEN*0.9;
      break;
    case '5':
      SPRING_LENGTH = SPRING_LENGTH*1.1;
      break;
    case '6':
      SPRING_LENGTH = SPRING_LENGTH*0.9;
      break;
    case '7':
      GRAVITY = GRAVITY*1.1;
      break;
    case '8':
      GRAVITY = GRAVITY*0.9;
      break;
  }
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
   text("SPRING_LENGTH="+SPRING_LENGTH,20, 20);
  text("SPRING_DAMPEN="+SPRING_DAMPEN,20, 40);
  text("SPRING_CONSTANT="+SPRING_CONSTANT,20, 60);
  text("GRAVITY="+GRAVITY,20, 80);

}
