import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.NumberFormat;
import javax.swing.border.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Newsfeed extends JFrame {
    JButton button1, button2, jbutton;
    JLabel labelS, label1, label2, label3, label4;
    JTextField textFieldEvent, textFieldMessage, textFieldFileName, textFieldAuthor, textFieldCaption, textField5;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton eventR, messageR, photoR, divideNums;
    JSlider howManyTimes;
    JTextArea textArea1;
    JTextArea textArea2;

    // ArrayList to store posts
    private ArrayList<Post> posts;

    
    public static void main(String[] args) {
        new Newsfeed();
    }

    public Newsfeed() {

        posts = new ArrayList<>();         // Initialize the ArrayList
        
        //Post posttest = new Post("123");
        
        //posttest.display(); 
        
        //posts.get(0).display();
        
        
        //String astring = "asdf";

        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Third Frame");
        
        //gui

        JPanel thePanel = new JPanel(); 
        eventR = new JRadioButton("   Event      ");
        messageR = new JRadioButton("   Message     ");
        photoR = new JRadioButton("   Photo       ");
 
        ButtonGroup operation = new ButtonGroup();
        operation.add(eventR);
        operation.add(messageR);
        operation.add(photoR);
        JPanel operPanel = new JPanel();
        Border operBorder = BorderFactory.createTitledBorder("Post");
        operPanel.setBorder(operBorder);
        operPanel.add(eventR);
        operPanel.add(messageR);
        operPanel.add(photoR);

        eventR.setSelected(true);

        thePanel.add(operPanel);

        labelS = new JLabel("Author");
        thePanel.add(labelS);
        textFieldAuthor = new JTextField("", 25);
        thePanel.add(textFieldAuthor);

        JPanel eventPanel = new JPanel();
        label2 = new JLabel("Event Type");
        textFieldEvent = new JTextField("", 25);
        eventPanel.add(label2);
        eventPanel.add(textFieldEvent);
        thePanel.add(eventPanel);

        JPanel messagePanel = new JPanel();
        label1 = new JLabel("message");
        textFieldMessage = new JTextField("", 25);
        messagePanel.add(label1);
        messagePanel.add(textFieldMessage);
        thePanel.add(messagePanel);

        JPanel photoPanel = new JPanel();
        label3 = new JLabel("file name");
        textFieldFileName = new JTextField("", 10);
        photoPanel.add(label3);
        photoPanel.add(textFieldFileName);
        label4 = new JLabel("caption");
        textFieldCaption = new JTextField("", 10);
        photoPanel.add(label4);
        photoPanel.add(textFieldCaption);
        thePanel.add(photoPanel);
        // end of GUI
         // default
        messagePanel.setVisible(false);
        eventPanel.setVisible(true);
        photoPanel.setVisible(false);
        

        // ActionListener for addNums radio button
        eventR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (eventR.isSelected()) {
                    messagePanel.setVisible(false);
                    eventPanel.setVisible(true);
                    photoPanel.setVisible(false);
                }
            }
        });

        // ActionListener for subtractNums radio button
        messageR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (messageR.isSelected()) {
                    messagePanel.setVisible(true);
                    eventPanel.setVisible(false);
                    photoPanel.setVisible(false);
                }
            }
        });

        // ActionListener for multNums radio button (Photo Panel)
        photoR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (photoR.isSelected()) {
                    messagePanel.setVisible(false);
                    eventPanel.setVisible(false);
                    photoPanel.setVisible(true);
                }
            }
        });
        
        //gui

        button1 = new JButton("submit");
        thePanel.add(button1);

        button2 = new JButton("show");
        thePanel.add(button2);
        //posts.display(); 
        
        button1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                ArrayList<String> list = new ArrayList<String>();
            // Check which radio button is selected and create a corresponding post
            if (eventR.isSelected()) {
                EventsPost eventPoster = new EventsPost(textFieldEvent.getText(), textFieldAuthor.getText());
                posts.add(eventPoster);

                                     
                
            } else if (messageR.isSelected()) {

                MessagePost messagePoster = new MessagePost(textFieldAuthor.getText(), textFieldMessage.getText());
                posts.add(messagePoster);
            
            } else if (photoR.isSelected()) {
            
                PhotoPost photoPoster = new PhotoPost(textFieldAuthor.getText(), textFieldFileName.getText(), textFieldCaption.getText());
                posts.add(photoPoster);
            
                
            
            }
            //JOptionPane.showMessageDialog(null, "Hello, "  + posts ); //posts.get(0));                

            textFieldEvent.setText("");
            textFieldAuthor.setText("");
            textFieldFileName.setText("");
            textFieldMessage.setText("");
            textFieldCaption.setText("");
                                            
                                            
       
            
            
            
            // Clear text fields after submission
            
        
           }
        });
        

        textArea1 = new JTextArea(15, 20);
        //textArea2 = new JTextArea(15, 20);

        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            textArea1.setVisible(true);
            textArea1.setVisible(true);

            // Display posts in textArea2
            for (Post post : posts) {
                textArea1.append(post.getTimeStamp()+ "\n"+ post.displayString() + "\n");

            }
            }
        });
        thePanel.add(scrollbar1);
        thePanel.add(textArea1); 
        this.add(thePanel);
        this.setVisible(true);
        //textField.requestFocus();
    }


 
}

