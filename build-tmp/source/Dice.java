import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die dieOne;
int roll;
public void setup()
{
	size(910,950);
	noLoop();
}

public void draw()
{
int totalroll=0;

background(0);

 for (int row=10; row<900; row=row+50){
 	for (int column=10; column<900; column=column+50){
		 dieOne= new Die(row,column);
		 dieOne.roll();
		 totalroll=dieOne.numba +totalroll;
		 dieOne.show();
	}
}

fill(255);
textSize(30);
text("total roll = " + totalroll, 350, 935);

}

public void mousePressed()
{
	redraw();
}

class Die //models one single dice cube
{
	int myX;
	int myY;
	int numba;

	Die(int x, int y)
	{
	myX=x;
	myY=y;
	}
	public void roll()
	{
		numba=(int)(Math.random()*6)+1;
		roll=numba;
	}
	public void show()
	{
		fill(255);
		rect(myX,myY,40,40);
		fill(0);
			if (numba==1){
			ellipse(myX+40/2,myY+40/2,2,2);
			}
			if (numba==2){
			ellipse(myX+40/2-5,myY+40/2,2,2);
			ellipse(myX+40/2+5,myY+40/2,2,2);
			}
			if (numba==3){
			ellipse(myX+40/2-7,myY+40/2-3,2,2);
			ellipse(myX+40/2,myY+40/2,2,2);
			ellipse(myX+40/2+7,myY+40/2+3,2,2);
			}
			if (numba==4||numba==5){
			ellipse(myX+40/2-8,myY+40/2-4,2,2);
			ellipse(myX+40/2+8,myY+40/2-4,2,2);
			ellipse(myX+40/2-8,myY+40/2+4,2,2);
			ellipse(myX+40/2+8,myY+40/2+4,2,2);
				if (numba==5){
				ellipse(myX+40/2,myY+40/2,2,2);

				}
			}
			if (numba==6){
			ellipse(myX+40/2-9,myY+40/2-7,2,2);
			ellipse(myX+40/2+9,myY+40/2-7,2,2);
			ellipse(myX+40/2-9,myY+40/2,2,2);
			ellipse(myX+40/2+9,myY+40/2,2,2);
			ellipse(myX+40/2+9,myY+40/2+7,2,2);
			ellipse(myX+40/2-9,myY+40/2+7,2,2);


			}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
