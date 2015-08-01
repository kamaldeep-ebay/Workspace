package a.service.proj;

public class DataModelQues {
  
  String question;
  Integer id;
  String category;
  
  public DataModelQues(String question,Integer id,String category){
    
    this.question=question;
    this.id=id;
    this.category=category;
  }
  
  @Override
  public String toString()
  {
    return "Question:"+question+"\nId:"+id+"\nCategory:"+category;
    
  }
}
