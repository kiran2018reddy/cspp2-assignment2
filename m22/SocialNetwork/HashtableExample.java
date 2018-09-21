import java.util.*;
class HashtableExample{
 public static void main(String args[]){

  //Declaring a Hashtable
  Hashtable<String,String[]> hm;

  //Initialising the hastable
  hm=new Hashtable<String,String[]>();

  String[] arr ={"Bryant","Dyne"};

  	//Adding values
	hm.put("John",arr);

  for(Map.Entry m:hm.entrySet()){
   System.out.println(m.getKey()+" "+m.getValue());
  }
 }
}