import java.util.ArrayList;

/**
 * Created by Maxim on 03.10.2016.
 */
public class FSM {

    private ArrayList<Command> program;
    private ArrayList<String> acceptStates;
    private String initialState;

    private String currentState;

    public FSM(ArrayList<Command> program,
               String initialState, ArrayList<String> acceptStates){

        this.program = new ArrayList<>(program);

        this.acceptStates = acceptStates;

        this.initialState = initialState;
    }

    private String getNextState(char observedSymbol){
        for(Command command:program){
            if(command.isObservedSymbolEqual(observedSymbol)&&
                    command.isInitialStateEqual(currentState)){
                return command.getFinalState();
            }
        }
        //Ошибочное состояние. Если в программе нет команды с таким обозреваемым символом и таким начальным состоянием
        return "";
    }

    public boolean runFSM(String input){

        currentState = initialState;

        for(int i=0;i<input.length();i++){
            currentState = getNextState(input.charAt(i));

            if(currentState.isEmpty()){
                return false;
            }
        }

        return acceptStates.contains(currentState);
    }
}
