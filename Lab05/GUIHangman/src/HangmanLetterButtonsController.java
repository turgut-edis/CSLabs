import javax.swing.*;
import java.awt.event.*;


/**
 * This class creates HangmanLetterButtonsController object with implementing
 * ActionListener and it controls letter buttons when one of them is clicked
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class HangmanLetterButtonsController implements ActionListener
{
   //Properties
   HangmanModel model;
   
   //Constructors
   
   /**
    * This constructor creates controller object with an instance of HangmanModel object
    * @param model the HangmanModel object
    */
   public HangmanLetterButtonsController( HangmanModel model )
   {
      this.model = model;
   }
   
   //Methods
   
   @Override
   public void actionPerformed( ActionEvent e )
   {
      JButton button = (JButton) e.getSource();
      model.tryThis( button.getText().charAt(0) );
      button.setEnabled( false );
   }
}