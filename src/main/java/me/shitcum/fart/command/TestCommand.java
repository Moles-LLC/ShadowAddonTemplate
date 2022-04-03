package me.shitcum.fart.command;

import net.shadow.client.feature.command.Command;
import net.shadow.client.feature.command.argument.IntegerArgumentParser;
import net.shadow.client.feature.command.argument.StringArgumentParser;
import net.shadow.client.feature.command.exception.CommandException;

import java.util.Arrays;

public class TestCommand extends Command {
    public TestCommand() {
        // configuration for the command (name, description, list of triggers)
        super("TestAddonCommand", "Test command for the addon", "testAddonCommand", "testAddon");
    }
    @Override
    public void onExecute(String[] strings) throws CommandException {
        // called every time the command is executed
        // we want two argument at least
        validateArgumentsLength(strings, 2);
        // parse a number for the first argument (how many messages to send)
        int amount = new IntegerArgumentParser().parse(strings[0]);
        // get the remaining arguments and pack them into a string, put spaces in between them to join them again
        String message = String.join(" ", Arrays.copyOfRange(strings, 1, strings.length));
        for(int i = 0;i<amount;i++) {
            // message is from Utils.Logging, command extends Utils.Logging for ease of use
            message(message);
        }
    }

    @Override
    public String[] getSuggestions(String fullCommand, String[] args) {
        // optionally return suggestions for the current context here
        if (args.length == 1) { // we're currently selecting the number
            return "123456789".split(""); // return all numbers 1-9
        } else if (args.length == 2) {
            return new String[] {"(message)"};
        }
        return super.getSuggestions(fullCommand, args);
    }
}
