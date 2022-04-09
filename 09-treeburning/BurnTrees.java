public class BurnTrees{
  private int[][]map;
  private int ticks;
  private Frontier burns;
  private static final int SPACE = 0;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;

  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    if (burns.size() > 0){
      return false;
    }
    return true;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    int oldsize = burns.size();
    for (int i = 0;i<oldsize;i++){
      int[] temp = burns.remove();
      map[temp[0]][temp[1]] = ASH;
      if (temp[0]>0 && map[temp[0]-1][temp[1]] == TREE){
        int[] a = {temp[0]-1,temp[1]};
        burns.add(a);
        map[temp[0]-1][temp[1]] = FIRE;
      }if (temp[0]<map.length-1 && map[temp[0]+1][temp[1]] == TREE){
        int[] a = {temp[0]+1,temp[1]};
        burns.add(a);     
        map[temp[0]+1][temp[1]] = FIRE;
      }if (temp[1]>0 && map[temp[0]][temp[1]-1] == TREE){
        int[] a = {temp[0],temp[1]-1};
        burns.add(a);
        map[temp[0]][temp[1]-1] = FIRE;
      }if (temp[1]<map[0].length-1 && map[temp[0]][temp[1]+1] == TREE){
        int[] a = {temp[0],temp[1]+1};
        burns.add(a);
        map[temp[0]][temp[1]+1] = FIRE;
      }
    }
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    burns = new Frontier();
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] a = {i, 0};
        burns.add(a);
      }
    }
  }


  public static double runmulti(int width, int height, double density){
    BurnTrees one = new BurnTrees(width, height, density);
    BurnTrees two = new BurnTrees(width, height, density);
    BurnTrees three = new BurnTrees(width, height, density);
    BurnTrees four = new BurnTrees(width, height, density);
    BurnTrees five = new BurnTrees(width, height, density);
    BurnTrees six = new BurnTrees(width, height, density);
    BurnTrees seven = new BurnTrees(width, height, density);
    BurnTrees eight = new BurnTrees(width, height, density);
    BurnTrees nine = new BurnTrees(width, height, density);
    BurnTrees ten = new BurnTrees(width, height, density);
    double avg = (double)(one.run() + two.run() + three.run() + four.run() + five.run() + six.run() + seven.run() + eight.run() + nine.run() + ten.run());
    return avg/10;
  }
  public static void main(String[]args){
    int WIDTH = 500;
    int HEIGHT = 500;
    int DELAY = 50;
    double DENSITY = .6;
    if(args.length > 1){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      DENSITY = Double.parseDouble(args[2]);
    }
    if(args.length > 3){
      DELAY = Integer.parseInt(args[3]);
    }
    System.out.println("## Table for max burn time on different size (60% density, length==width)\n");
    System.out.println("Size (length) | Tick 1 | Tick 2 | Tick 3 | Tick 4 | Tick 5 | Avg Tick");
    System.out.println("--- | --- | --- | --- | --- | --- | ---");
    for (int i = 100 ; i < 1600;i+=100){
      BurnTrees one = new BurnTrees(i, i, 0.6);
      BurnTrees two = new BurnTrees(i, i, 0.6);
      BurnTrees three = new BurnTrees(i, i, 0.6);
      BurnTrees four = new BurnTrees(i, i, 0.6);
      BurnTrees five = new BurnTrees(i, i, 0.6);
      int a = one.run();
      int b = two.run();
      int c = three.run();
      int d = four.run();
      int e = five.run();
      double avg = (double)(a+b+c+d+e);
      System.out.println("Size "+i+" | "+a+" | "+b+" | "+c+" | "+d+" | "+e+" | "+ (avg/5));
    }
    System.out.println("\n## Table for densities 5% to 95% (5% intervals)\n");
    System.out.println("Density | Avg. Ticks");
    System.out.println("--- | ---");
    for (double i = 0.05 ; i < 1;i+=0.05){
      System.out.println("Density " + Math.round(i*100) + "% | " + runmulti(WIDTH, HEIGHT, i));
    }
    System.out.println("\n## Table for densities 55% to 65% (near maximum)\n");
    System.out.println("Density | Avg. Ticks");
    System.out.println("--- | ---");
    for (double i = 0.55 ; i < 0.66;i+=0.01){
      System.out.println("Density " + Math.round(i*100) + "% | " + runmulti(WIDTH, HEIGHT, i));
    }
  }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
