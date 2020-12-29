import cs102.Hangman;
import cs102.IHangmanSetup;
import java.util.ArrayList;

/**
 * This class creates a model for hangman class
 * @author Turgut Alp Edis
 * date: 1/12/20
 */
public class HangmanModel extends Hangman {

    //Properties
    ArrayList<IHangmanView> views;

    //Constructors

    /**
     * This constructor creates new model for hangman game
     * @param setup the IHangmanSetup interface
     */
    public HangmanModel(IHangmanSetup setup) {
        super(setup);
        views = new ArrayList<>();
    }

    //Methods

    /**
     * This method adds new IHangmanView to the array list of views
     * @param view the IHangmanView
     */
    public void addView( IHangmanView view ){
        this.views.add(view);
    }

    /**
     * This method updates current console view of the game
     */
    public void update()
    {
        if ( views != null )
        {
            for ( IHangmanView v : views )
            {
                v.updateView( this );
            }
        }
    }

    @Override
    public int tryThis(char letter){
        int r = super.tryThis( letter );
        this.update();
        return r;
    }

    @Override
    public void initNewGame(){
        super.initNewGame();
        this.update();
    }


}
