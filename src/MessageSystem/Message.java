package MessageSystem;

/**
 * Created by Zornitsa Petkova on 4/30/15.
 */
public class Message {
  public final String name;
  public final String title;
  public final String body;

  //Constructor
  public Message(String name, String title, String body) {
    this.name = name;
    this.body = body;
    this.title = title;
  }

}
