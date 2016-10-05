/**
 * Created by Maxim on 03.10.2016.
 */
public class Command {

    private String initialState;
    private char observedSymbol;
    private String finalState;

    public Command(String initialState, char observedSymbol,
                   String finalState){
        this.initialState = initialState;
        this.observedSymbol = observedSymbol;
        this.finalState = finalState;
    }

    public boolean isObservedSymbolEqual(char symbol){
        return observedSymbol==symbol;
    }

    public boolean isInitialStateEqual(String state){
        return initialState.equals(state);
    }

    public String getFinalState(){
        return finalState;
    }
}
