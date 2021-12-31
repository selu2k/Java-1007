import java.io.*;
import java.util.Map.*;
import java.util.*;

class Marks{
    public static void main(String[] args){
        Map<String, Object> res = new HashMap<String, Object>();
        try{
            BufferedReader br=new BufferedReader(new FileReader("file.txt"));
            String l;
            try{
            while((l = br.readLine()) != null ){
                String[] val = l.split(",");
                Map<String, Integer> temp = new HashMap<String, Integer>();
                for(int i = 1 ; i< val.length-1;i=i+2){
                    temp.put(val[i],Integer.parseInt(val[i+1]));
                }
                res.put(val[0],temp);
            }}catch(IOException e){};
        }
        catch(FileNotFoundException e){}
        System.out.println(res);
        
    }
}