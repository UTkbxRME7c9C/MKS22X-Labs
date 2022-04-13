
int x,y;
int MODE;
void setup(){
         size(800,800);
         MODE = 3;
         x = width/2;
         y = height/2;
}
void draw(){
         background(255);
         x = change(x);
         y = change(y);
         avatar(x,y);
         avatar(mouseX,mouseY);
         
}
int change(int value){
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
         wrap back around to the other end of the screen.
  */

  switch(MODE){
   case 1:
     return (int)random(width);
   case 2:
     return value+(int)random(-2,2);
   case 3:
      if (value>=width){
        return 0;
      } return value+1;
   default:
     return width/2;
  }
}
void avatar(int x, int y){
  //your code here
  ellipseMode(CORNER);
  fill(173,255,47);
  ellipse(x,y,80,100);
  fill(200);
  ellipse(x+20,y+20,15,15);
  ellipse(x+45,y+20,15,15);
  noFill();
  arc(x+15, y+20, 50, 50, 0.5, 2);
  fill(100);
  triangle(x+30, y+40, x+38, y+50, x+46, y+40);

} 

void mouseClicked() {
  if (MODE == 3) {
    MODE = 1;
  } else {
    MODE++;
  }
}
