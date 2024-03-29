import java.util.ArrayList;


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
