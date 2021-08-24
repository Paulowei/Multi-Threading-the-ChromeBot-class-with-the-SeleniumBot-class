package ChromeBot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.geom.*;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
public class ChromeBot1 extends Thread implements Runnable{
    public int x;
    public int y;
    public int width;
    public int height;
    public int thresh;
    public int thresh_;
    public Robot robot;
    public Rectangle rect;
    public boolean isDino;
    public boolean isTranslated = false;
    //Unparametized Constructor
    public ChromeBot1(){
        this(0,0,0,0);
        System.out.println("ChromeBot created");
    }

    public ChromeBot1(int x1,int y1,int width1,int height1){
        try{
            robot=new Robot();

        } catch (AWTException e){
            e.printStackTrace();
        }
        x=x1;
        y=y1;
        width=width1;
        height=height1; 
        rect=new Rectangle(x,y,width,height);
    }
    public boolean jump() throws AWTException{
        int sum=0;
        int width2;
        int height2;
        Color c;
        robot.keyPress(KeyEvent.VK_DOWN);
        //robot.mouseWheel(-6);
        BufferedImage image=robot.createScreenCapture(rect);
        width2 = image.getWidth();
        height2 = image.getHeight();
        for(int i=0;i<width2;i+=1){
            for(int j=0;j<height2;j+=1){
                c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
                }
            }
        //System.out.println(this.toString() + sum);
        if(sum<=thresh&&isDino==true ){
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_DOWN);
        }//"Sum of the pixel color components is exceedingly beyond the threshold"
        if( sum>=2000000){throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
        }  
        if(isDino==false){
            if(sum>=thresh){
                return true;
            }else{     
            return false;
            }
        }
        else{
            return false;
        }
    }         
    public int  scale() throws AWTException{
        int width;    
        int height;  
        int sum= 0;  
        Color c;
        robot.keyPress(KeyEvent.VK_DOWN);
        //robot.mouseWheel(-6);
        BufferedImage image=robot.createScreenCapture(rect);
        width=image.getWidth();
         height=image.getHeight();
        for(int i=0;i<width;i+=1){
            for(int j=0;j<height;j+=1){
                c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
            }
        }
        //System.out.println(this.toString() + sum);
        if(sum>=thresh_){
            robot.delay(80);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.delay(200);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_DOWN);
        }
        if( sum>=2000000) {throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
        }
        return sum;
    }
    public int restart(boolean state) throws AWTException{
        int width2;
        int height2;
        int sum2=0;
        Color c;
        BufferedImage image=robot.createScreenCapture(rect);
        width2 =  image.getWidth();
        height2 = image.getHeight();
        for(int i=0;i<width2;i+=1){
            for(int j=0;j<height2;j+=1){
                c=new Color(image.getRGB(i,j));
                sum2+=c.getRed();
                sum2+=c.getBlue();
                sum2+=c.getGreen();
                }
        }
        //System.out.println(this.toString() + sum2);
        if((state==true&&sum2<=thresh)||(state==false&&sum2>=thresh_)){
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.mouseMove(x+width/2,y+height/2);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(x+80,y+80);
        }
        if(sum2>=2000000){throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
                }
        return sum2;
    }//Button postion initialisation method();
    public void init(){
        robot.mouseMove(x+width/2,y+height/2);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.mouseMove(x+80,y+80);

    }
    //public test method(non-static);
    public int test() throws AWTException{
        int width;
        int height;
        int sum=0;
        Color c;
        BufferedImage image=robot.createScreenCapture(rect);
        width =  image.getWidth();
        height = image.getHeight();
        for(int i=0;i<width;i+=1){
            for(int j=0;j<height;j+=1){
                c=new Color(image.getRGB(i,j));
                sum+=c.getRed();
                sum+=c.getBlue();
                sum+=c.getGreen();
                }
        }
        //System.out.println(this.toString() + sum2);
        if(sum>=2000000){throw new AWTException("Sum of the pixel color components is exceedingly beyond the threshold"); 
                }
        System.out.println(sum);
        return sum;
    }
    public void translate(int a,int b,boolean state){
        if(state ==false){
        if(this.isTranslated==false){
        this.x=a;
        this.y=b;
        this.isTranslated = true;
        }
        }
        else{
        this.x=a;
        this.y=b;
        }
    }
    //ChromeBot position translation method(non-static);
    public void relTranslate(int a,int b,boolean state){
        if(state ==false){
            if(this.isTranslated==false){
            this.x=this.x+a;
            this.y=this.y+b;
            this.isTranslated = true;
            }
        }
        else{
        this.x=this.x+a;
        this.y=this.y+b;
        }
    }
    //Overriding the run() method() of the Thread class;
    //The run() method() is also encapsulated in the Runnable interface;
    public static void main(String[] args){
        //ChromeBot1 Dinosaur=new ChromeBot1(185,282,50,50);
        //ChromeBot1 Button=new ChromeBot1(318,264,50,50);
        //ChromeBot1 Modulator=new ChromeBot1(153,240,50,50);
        //ChromeBot1 Dinosaur = new ChromeBot1(165,280,50,50);
        //ChromeBot1 Button = new ChromeBot1();
        //ChromeBot1 Modulator=new ChromeBot1(153,240,50,50);
        ChromeBot1 Dinosaur = new ChromeBot1(226,218,50,50);
        ChromeBot1 Button = new ChromeBot1(332,202,50,50);
        ChromeBot1 Modulator=new ChromeBot1(229,193,50,50);
        Dinosaur.thresh = 1800000;
        Dinosaur.thresh_=100000;  
        Modulator.thresh=50000;
        Button.thresh=1600000; 
        Button.thresh_=300000;
        Dinosaur.isDino=true;
        Modulator.isDino=false;
        Button.init();  
        while(true){       
            try{   
                boolean state = Modulator.jump();
                //Button.test();
                if(state==true){
                    Dinosaur.jump();
                    Button.restart(state);
                }  
                if(state==false){
                    Dinosaur.scale();
                    Button.restart(state);
                }
            } 
            catch(AWTException E){
            E.printStackTrace();
        }     
        }
    }
        
    //public static void main() function;
    @Override 
    public void run(){
        ChromeBot1 Dinosaur=new ChromeBot1(140,385,50,50);
        ChromeBot1 Button=new ChromeBot1(286,370,50,50);
        ChromeBot1 Modulator=new ChromeBot1(160,280,50,50);
        //ChromeBot1 Dinosaur=new ChromeBot1(300,308,50,50);
        //ChromeBot1 Button=new ChromeBot1(321,257,50,50);
        //ChromeBot1 Modulator=new ChromeBot1(227,175,50,50);
        /*while(true){
            try{
        ChromeBot1 Button=new ChromeBot1(135,380,50,50);
        Button.jump();
            }catch(AWTException E){
            System.err.println(E.toString());}
        }*/
        //Dinosaur.thresh=1860000;
        //Dinosaur.thresh_=100000;
        //Modulator.thresh=50000;
        //Button.thresh=1400000; 
        Dinosaur.thresh=1800000;
        Dinosaur.thresh_=25000;
        Modulator.thresh=50000;
        Button.thresh=1600000; 
        Button.thresh_=100000;
        Dinosaur.isDino=true;
        Modulator.isDino=false;
        Button.init();    
        while(true){            
            try{
                //Dinosaur.jump();
                boolean state = Modulator.jump();
                Button.restart(state);
                //Modulator.test();
                //Button.test();
                //Dinosaur.test();
                if(state==true){
                    Dinosaur.jump();
                    //Button.restart(state);
                }
                if(state ==false){
                    Dinosaur.scale();
                    //Button.restart(state);
                }
            }   
            catch(AWTException e){
            System.err.println(e.toString());
            }    
        }
    }
}                                                                