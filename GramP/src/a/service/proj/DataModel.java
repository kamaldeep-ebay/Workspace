package a.service.proj;

public class DataModel {
  
  String rssi;
  Integer pos_x;
  Integer pos_y;
  String imsi;
  Long time;
  
  public DataModel(String rssi,
  Integer pos_x,
  Integer pos_y,
  String imsi,
  Long time){
    
	   this.rssi=rssi;
	   this.pos_x=pos_x;
	   this.pos_x=pos_x;
	   this.pos_y=pos_y;
	   this.time=time;
  }
  
  @Override
  public String toString()
  {
    return "rssi:"+rssi+"\npos_x:"+pos_x+"\npos_y:"+pos_y;
  }
}
