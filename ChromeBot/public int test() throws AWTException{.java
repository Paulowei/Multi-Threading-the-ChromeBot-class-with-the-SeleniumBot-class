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
public void translate(int a,int b){
    if(this.translated==false){
    this.x=this.x+a;
    this.y=this.y+b;
    this.translated=true;
    }
}
public static void main(String[] args){
    ChromeBot1 Dinosaur=new ChromeBot1(300,308,50,50);
    ChromeBot1 Button=new ChromeBot1(321,257,50,50);
    ChromeBot1 Modulator=new ChromeBot1(227,175,50,50);
    /*while(true){
        try{
    ChromeBot1 Button=new ChromeBot1(135,380,50,50);
    Button.jump();
        }catch(AWTException E){
        System.err.println(E.toString());}
    }*/
    Dinosaur.thresh=1860000000;
    Dinosaur.thresh_=100000000;
    Modulator.thresh=50000;
    Button.thresh=1400000; 
    Dinosaur.isDino=true;
    Modulator.isDino=false;
    Button.init();    
    while(true){            
        try{   
            //https://tech25s.com/how-to-tell-when-someone-was-last-on-snapchat/
            boolean state = Modulator.jump();
            Button.restart(state);
            if(state==true){
                Dinosaur.jump();
            }  
            if(state==false){
                Dinosaur.scale();
            }
        }   
        catch(AWTException e){
        e.printStackTrace();
         System.out.println("Sum of the pixel color components is exceedingly beyond the threshold");
        }     
    }
}
@Override
    public void run(){
        ChromeBot1 Dinosaur=new ChromeBot1(185,282,50,50);
        ChromeBot1 Button=new ChromeBot1(318,264,50,50);
        ChromeBot1 Modulator=new ChromeBot1(153,240,50,50);
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
                //https://tech25s.com/how-to-tell-when-someone-was-last-on-snapchat/
                boolean state = Modulator.jump();
                Button.restart(state);
                if(state==true){
                    Dinosaur.jump();
                }  
                if(state==false){
                    Dinosaur.scale();
                }
            } 
            catch(AWTException e){
            e.printStackTrace();
        }     
        }
    }