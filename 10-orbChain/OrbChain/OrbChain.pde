final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
final static int ADDEND = 0;
final static int INSERT = 1;
final static int DEL = 2;
static int CLICKMODE = ADDEND;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (CLICKMODE == 0) orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
  if (CLICKMODE == 1) orbs.add(mouseX, new OrbNode(mouseX,mouseY,0,0,30));
}
void keyPressed(){
  switch(key){
    case '1':
      SPRING_CONSTANT = SPRING_CONSTANT*1.05;
      break;
    case '2':
      SPRING_CONSTANT = SPRING_CONSTANT*0.95;
      break;
    case '3':
      SPRING_DAMPEN = SPRING_DAMPEN*1.05;
      break;
    case '4':
      SPRING_DAMPEN = SPRING_DAMPEN*0.95;
      break;
    case '5':
      SPRING_LENGTH = SPRING_LENGTH*1.05;
      break;
    case '6':
      SPRING_LENGTH = SPRING_LENGTH*0.95;
      break;
    case '7':
      GRAVITY = GRAVITY*1.05;
      break;
    case '8':
      GRAVITY = GRAVITY*0.95;
      break;
    case 32:
      if (CLICKMODE == 2){
         CLICKMODE = 0; 
      }else{CLICKMODE++;}
      
  }
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("SPRING_CONSTANT="+SPRING_CONSTANT,20, 20);
  text("SPRING_DAMPEN="+SPRING_DAMPEN,20, 40);
  text("SPRING_LENGTH="+SPRING_LENGTH,20, 60);
  text("GRAVITY="+GRAVITY,20, 80);
  text("CLICKMODE="+CLICKMODE,20, 100);

}
