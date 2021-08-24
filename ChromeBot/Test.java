import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Thread;
import java.util.List;
public class Test{
    public Test(){

    }
    public static void main(String[] args){
        String[] str1 = new String[]{"NRG","MSF","FAZE","TSM","XTRA","BH"};
        ArrayList<String> str2 = new ArrayList<String>();
        str2.add("NRG");
        str2.add("MSF");
        str2.add("FAZE");
        str2.add("TSM");
        str2.add("XTRA");
        str2.add("BH");
        System.out.println(Arrays.deepToString(str1));
        //System.out.println(Arrays.deepToString(str1.toString()));
        System.out.println(str2);
        System.out.println(str2.toString());
    }
}