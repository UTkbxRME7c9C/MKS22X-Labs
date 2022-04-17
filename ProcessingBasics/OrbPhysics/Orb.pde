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
        ellipse(x, y,radius*2, radius*2);
        fill(c);
      }

      void move(){
        x+=xSpeed;
        y+=ySpeed;
        if(y<=radius || y>=height-radius){
          ySpeed=ySpeed*-1;
        }if (x<=radius || x>=width-radius){
          xSpeed=xSpeed*-1;
        }
        if (y<height-radius){
          ySpeed+=1;          
        }
        //Part 4
        //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
        //You don't need a variable for this if every object experiences the same
        //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).

      }
    }
