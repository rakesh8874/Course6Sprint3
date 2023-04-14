import java.util.*;
import java.io.*;

class Result{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        //int t=in.nextInt();
       // for(int i=0;i<t;i++){
           // int a = 0;//in.nextInt();
          //  int b = 2;//in.nextInt();
          //  int n = 10;//in.nextInt();
//            for(int j = 0; j<n;j++){
//                a = a+b;
//                System.out.print(a+" ");
//                b = b*2;
//            }
           // System.out.println();
//        Set<Integer> set = new LinkedHashSet<>();
//            set.add(12);
//            set.add(9);
//            set.add(15);
//            set.add(17);
//            set.add(8);
//            set.add(11);
//        System.out.println(set);
   TreeMap<Integer,String> map = new TreeMap<>();
   map.put(12,"Avengers");
   map.put(9,"InfinityWar");
   map.put(14,"Thor");
   map.put(18,"Hulk");
   map.put(13,"SpiderMan");
   for(Integer key:map.keySet()) {
        System.out.print(key+" ");
   }
        for (String value : map.values()) {
            System.out.print(value + " ");
        }
//        System.out.println(map.higherKey(12));
//        System.out.println(map.firstEntry());
//        for(Map.Entry<Integer,String> check:map.entrySet()){
//            System.out.println(check.getKey()+" "+check.getValue());
//        }
//        Iterator <Integer> iterator = map.keySet().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
      //  in.close();
    }
//}
