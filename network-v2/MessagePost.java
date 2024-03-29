import java.util.ArrayList;

public class MessagePost extends CommentedPost {
    private String message; // an arbitrarily long, multi-line message

    public MessagePost(String author, String text) {
        super(author);
        message = text;
    }

    public String getText()
    {
        return message;
    }

    public void display()
    {
        super.display();
        System.out.println(message);
    }
    public String displayString() {
        return "" + "author: " + author + "\n Message: " + message;
    }
}