package org.mow.it.command;

import org.mow.it.domain.Mower;

public class CommandAdvance implements Command {

    private static final CommandAdvance commandAdvance = new CommandAdvance();

    private CommandAdvance() {
    }

    public static Command getInstance() {
        return commandAdvance;
    }

    @Override
    public void execute(Mower mower) {
        mower.advance();
    }
}
