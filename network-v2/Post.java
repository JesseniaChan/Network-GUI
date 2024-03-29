import java.util.ArrayList;

public class Post {
    protected String author; // Changed from username to author
    private long timestamp;
    private String filename; // the name of the image file
    private String caption; // a one line image caption


    public Post(String author) {
        this.author = author;
        timestamp = System.currentTimeMillis();
    }

    public long getTimeStamp() {
        return timestamp;
    }

    public String getAuthor() {
        return author;
    }

      public String getImageFile() {
        return filename;
    }

    public String getCaption() {
        return caption;
    }
    
    // Changed access modifier from private to protected
    public void display() {
        System.out.println(author); // Changed from username to author
        System.out.print(timeString(timestamp));
    }

    public String displayString() {
        return "" + "author: " + author + "\ntime: " + timestamp;
    }
    
    
    
    private String timeString(long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time; // time passed in milliseconds
        long seconds = pastMillis / 1000;
        long minutes = seconds / 60;
        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }
    

    public void inputData(String x) {
        author.equals(x);
    }
}

