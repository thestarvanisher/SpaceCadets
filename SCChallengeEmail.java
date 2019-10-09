/*Space Cadets, Challenge 1, 2019
Author: Ivalin Chobanov*/
import java.io.*;
import java.net.*;

public class SCChallengeEmail{

  public static void main(String[] args) throws IOException{

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String id = reader.readLine();
    String address = "https://www.ecs.soton.ac.uk/people/" + id;
    reader.close();
    
    URL url = new URL(address);
    URLConnection connection = null;
    try {
      connection = url.openConnection();
    }
    catch (Exception e){
      System.out.println("Could not open URL!");
      System.exit(0);
    }
    BufferedReader urlReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

    String data;
    try {
      while((data = urlReader.readLine()) != null){
      if(data.contains("property=\"name\"")) break;
      }
      data = data.substring(data.indexOf("property=\"name\""));
      data = data.substring(data.indexOf(">") + 1, data.indexOf("<"));
      System.out.println("Name: " + data);
      urlReader.close();
    }
    catch (Exception e){
      System.out.println("Oops, there was a problem finding information or it doesn't exist!");
      urlReader.close();
      System.exit(0);
    }
  }
}
