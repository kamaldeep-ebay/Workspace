package a.service.proj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QuesManager {
// TO DO 
  // USE SINGLETON for this manager  and add more methods here and less in QuesIO
  static volatile HashMap<String, DataModelQues> Questions = new HashMap<String, DataModelQues>();
  static volatile HashMap<String, ArrayList<String>> Categories = new HashMap<String, ArrayList<String>>();
  
  public static Integer addQuesWithCategory(String ques,String category)
  {
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(100);
    
    // convert id to any relevant type
    //String id = String.valueOf(randomInt);  
    DataModelQues dm = new DataModelQues(ques, randomInt, category);
    
    Questions.put(ques,dm);
    
    if(Categories.containsKey(category))
    {
      ArrayList<String> t = Categories.get(category);
      t.add(ques);
      Categories.put(category, t);
    }
    else
    {
      ArrayList<String> newar = new ArrayList<String>();
      newar.add(ques);
      Categories.put(category, newar);
    }
    
    return randomInt; 
  }
  
  public static boolean getQues(String ques)
  {
    return (Questions.containsKey(ques));
  }
  
}
