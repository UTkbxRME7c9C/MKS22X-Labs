public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    if (init.length == 3 && init[0].length == 3)
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    if (x == 0 || x == img.width-1) return color(0);
    if (y == 0 || y == img.height-1) return color(0);
    float r = 0;
    float g = 0;
    float b = 0;
    for (int i=0;i<=2;i++){
       for (int j=0;j<=2;j++){
          color t = img.get((x-1)+j,(y-1)+i);
          r += (kernel[i][j])*(red(t));
          g += (kernel[i][j])*(green(t));
          b += (kernel[i][j])*(blue(t));

       }
    }
    if (r < 0) r = 0;
    if (r > 255) r = 255;
    if (g < 0) g = 0;
    if (g > 255) g = 255;
    if (b < 0) b = 0;
    if (b > 255) b = 255;
    return color(r,g,b);
  }

  /**You must write this method that applies the kernel to the source,
  *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.height; i++){
       for(int j = 0; j < source.width; j++){
          destination.set(j, i, calcNewColor(source,j,i)); 
       }
    }
  }

}
