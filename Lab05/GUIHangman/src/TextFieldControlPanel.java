import cs102.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class creates TextFieldControlPanel object
 * It control textField object on the top of the game
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class TextFieldControlPanel extends JPanel implements ActionListener 
{
   //Properties
   JTextField text;
   Hangman hangman;
   
   //Constructors
   
   /**
    * This constructor creates a textfieldcontrolpanel object with instance of hangman object
    * @param hangman the hangman object
    */
   public TextFieldControlPanel( Hangman hangman )
   {
      //Storing the hangman object in this class locally
      this.hangman = hangman;
      //Creating textField with length of 10
      text = new JTextField(15);
      //Adds text field into the panel
      add(text);
      //Adds the action listener
      text.addActionListener(this);
   }
   
   //Methods
   
   @Override
   public void actionPerformed( ActionEvent e )
   {
      String str = text.getText();
      
      //tryThis for all characters
      for (int i = 0; i < str.length(); i++)
      {
         hangman.tryThis(str.charAt(i));
      }
      
      //Changing the text field to an empty one after trials
      text.setText("");
   }
   
}