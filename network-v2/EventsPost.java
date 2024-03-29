import java.util.ArrayList;

/**
 * This class stores information about a post in a social network news feed. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class EventsPost extends Post{
    private String eventType;

    public EventsPost(String eventtype, String author) {
        super(author);
        eventType = eventtype;
    }

    // getter methods
    public String getEventType() {
        return eventType;
    }

    public void display() {
        super.display();
        System.out.println();
        System.out.println("The event type is " + eventType);
    }
    public String displayString() {
        return "" + "author: " + author + "\n event type: " + eventType;
    }


}