import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;

public class Launcher {

    public static void main(String[] args) {
        ArrayList<Command> command = new ArrayList<Command>();
        command.add(new Quit());
        command.add(new Fibo());
        command.add(new Freq());
        command.add(new Predict());
        Scanner sc = new Scanner(System.in);
        boolean finish = false;
        boolean found = false;
        while(!finish) {
            System.out.println("Input :");
            String input = sc.nextLine();
            for (int i = 0; i < command.size(); i++){
                if (command.get(i).name().equals(input)){
                    finish = command.get(i).run(sc);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Unknown command");
            }
        }
    }
}