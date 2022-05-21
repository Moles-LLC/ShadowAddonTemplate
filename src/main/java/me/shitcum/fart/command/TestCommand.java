package me.shitcum.fart.command;

import net.shadow.client.feature.command.Command;
import net.shadow.client.feature.command.argument.IntegerArgumentParser;
import net.shadow.client.feature.command.argument.StreamlineArgumentParser;
import net.shadow.client.feature.command.coloring.ArgumentType;
import net.shadow.client.feature.command.coloring.PossibleArgument;
import net.shadow.client.feature.command.coloring.StaticArgumentServer;
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
        validateArgumentsLength(strings, 2, "Put more shit");
        // parse a number for the first argument (how many messages to send)
        StreamlineArgumentParser argParser = new StreamlineArgumentParser(strings);
        int amount = argParser.consumeInt();
        // get the remaining arguments and pack them into a string, put spaces in between them to join them again
        String message = String.join(" ", Arrays.copyOfRange(strings, 1, strings.length));
        for(int i = 0;i<amount;i++) {
            // message is from Utils.Logging, command extends Utils.Logging for ease of use
            message(message);
        }
    }


    @Override
    public PossibleArgument getSuggestionsWithType(int index, String[] args) {
        return StaticArgumentServer.serveFromStatic(index, new PossibleArgument(ArgumentType.STRING, "123456789".split("")), new PossibleArgument(ArgumentType.STRING, "(message)"));
    }
}
