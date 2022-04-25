    public class Orb{
      float x,y;
      float xSpeed,ySpeed;
      float radius;
      color c;

      public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
        x = x_;
        y = y_;
        xSpeed = xSpeed_;
        ySpeed = ySpeed_;
        radius = radius_;
        //random color... why not.
        c = color(random(255),random(255),random(255));
      }


      void display(){
        fill(c);
        ellipse(x, y,radius*2, radius*2);
      }

      void move(){
        x+=xSpeed;
        y+=ySpeed;
        //if(y<=radius || y>=height-radius){
        //  ySpeed=ySpeed*-1;
        //}if (x<=radius || x>=width-radius){
        //  xSpeed=xSpeed*-1;
        //}
        //if (y<height-radius){
        //  ySpeed+=1;          
        //}
      }
      void attract(Orb b){
          float distance = dist(x, y, b.x,b.y);
          b.xSpeed += 50 * ((x-b.x)/(distance * distance));
          b.ySpeed += 50 * ((y-b.y)/(distance * distance));

      }
    }
