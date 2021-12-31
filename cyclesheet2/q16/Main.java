import java.io.*;
import java.util.*;

class Marks {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Map<String, Object> res = new HashMap<String, Object>();
        TreeMap<String,ArrayList<String>> map=new TreeMap<String,ArrayList<String>>();   
        try{
            BufferedReader br=new BufferedReader(new FileReader("file.txt"));
            String l;
            try{
            while((l = br.readLine()) != null ){
                String[] val = l.split("\\(");
                String sen = val[0];
                String parts = val[1];
                parts = parts.replace(")","");
                sen = sen.replace("?", "");
                String[] senn = sen.split(" ");
                String[] partss = parts.split(" ");
                for(int i = 0; i<senn.length;i++){
                    if(map.containsKey(partss[i])){
                        map.get(partss[i]).add(senn[i]);
                    }else{
                        map.put(partss[i],new ArrayList<String>());
                        map.get(partss[i]).add(senn[i]);
                    }
                }
            }
            String  in = sc.nextLine(); 
            String  ph  = sc.nextLine();
            String[] inpt = in.split(" ");
            String[] part= ph.split(" ");
            ArrayList<ArrayList<String> > ragged = new ArrayList<>();
            for(int i = 0 ; i< inpt.length; i++){
                ArrayList<String> a = new ArrayList<>();
                for (Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
                    for(int j = 0 ; j< entry.getValue().size();j++){
                        if(inpt[i].equals(entry.getValue().get(j))){
                            a.add(entry.getKey());
                            break;
                        }
                    }
                }
                if(a.size()!=0){
                    ragged.add(a);
                }
            }
            for (int i = 0; i < ragged.size(); i++) {
                for (int j = 0; j < ragged.get(i).size(); j++) {
                    System.out.print(ragged.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println(map);
            for(int i = 0 ; i< inpt.length; i++){
                boolean flag = false;
                for(int j = 0 ; j<map.get(part[i]).size();j++){
                    if(inpt[i].equals(map.get(part[i]).get(j))){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    System.out.println("Input tags not valid");
                    break;
                }
                if(i== inpt.length-1 && flag == true){
                    System.out.println("Input is acceptable");
                }
            }
            
}catch(IOException e){};
        }
        catch(FileNotFoundException e){}
        
    }
}
