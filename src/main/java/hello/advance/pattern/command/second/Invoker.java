package hello.advance.pattern.command.second;

import java.util.Stack;

/**
 * @author karl xie
 * Created on 2020-12-16 18:01
 */
public class Invoker {

    private final Stack<Command> commands;

    public Invoker() {
        commands = new Stack<>();
    }

    public void addCommand(Command command) {
        commands.push(command);
    }

    public void undoCommand() {
        if (!commands.empty()) {
            commands.pop();
        }
    }

    public void execute() {
        while (!commands.empty()) {
            Command command = commands.pop();
            command.execute();
        }
    }
}