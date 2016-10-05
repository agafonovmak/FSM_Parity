import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Maxim on 03.10.2016.
 */
public class Main {
    public static void main(String [] args) {
        ArrayList<Command> program = new ArrayList<>();

        program.add(new Command("q0",'0',"q1"));
        program.add(new Command("q0",'1',"q2"));

        program.add(new Command("q1",'0',"q0"));
        program.add(new Command("q1",'1',"q3"));

        program.add(new Command("q2",'0',"q3"));
        program.add(new Command("q2",'1',"q0"));

        program.add(new Command("q3",'0',"q2"));
        program.add(new Command("q3",'1',"q1"));

        String[] acceptStates = {"q2"};

        FSM parity = new FSM(program, "q0",
                new ArrayList<String>(Arrays.asList(acceptStates)));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(parity.runFSM(input)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
