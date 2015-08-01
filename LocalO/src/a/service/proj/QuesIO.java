package a.service.proj;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;

public class QuesIO {

  
  public static Integer addQues(String ques,String category) throws ClientProtocolException, IOException{
  
    Integer id = QuesManager.addQuesWithCategory(ques, category);
    return id;
  }
  
  public static String getQues(String ques)
  {
    if(QuesManager.getQues(ques)==true)
      return QuesManager.Questions.get(ques).toString();
    else
      return "Question NOT Present";
  }
  
  public static String removeQues(String ques)
  {
    if(QuesManager.getQues(ques)==true)
    {
      String removed = QuesManager.Questions.get(ques).toString();
      QuesManager.Questions.remove(ques);
      return removed;
    }
    else
      return "Question NOT Present";
  }
  
  public static String getQuesForCategory(String category)
  {
    ArrayList<String> ar = QuesManager.Categories.get(category);
    if(ar==null){
      return "Category not found";
    }
    StringBuffer strbuf = new StringBuffer();
    
    for(String s :ar)
    {
      strbuf.append(s.concat("\n"));
    }
    return strbuf.toString();
  }
  
  public static String changeCategoryForQues(String ques,String oldcategory,String newcategory)
  {
    if(!QuesManager.Categories.containsKey(oldcategory))
    {
      return "Category does not exist";
    }
    else
    {
      ArrayList<String> ar = QuesManager.Categories.get(oldcategory);
      
      int i=0;
      for(i=0;i<ar.size();i++)
      {
        if(ar.get(i).equalsIgnoreCase(ques))
        {
          break;
        }
      }
      if(i<ar.size())
      {
        ar.remove(i);
      }
      // ASSUMING YOU WILL ALWAYS CHANGE THE CATEGORY TO A NEW CATEOGIRY WHICH DOES NOT EXIST.. else add that logic
      ArrayList<String> t = new ArrayList<String>();
      t.add(ques);
      QuesManager.Categories.put(newcategory, t);
      
      return "Changed Category";
    }
    
  }
  
}
