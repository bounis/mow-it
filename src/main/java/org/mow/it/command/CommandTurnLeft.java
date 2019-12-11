package org.mow.it.command;

import org.mow.it.domain.Mower;

public class CommandTurnLeft implements Command {

    private static final CommandTurnLeft commandTurnLeft = new CommandTurnLeft();

    private CommandTurnLeft() {
    }

    public static CommandTurnLeft getInstance() {
        return commandTurnLeft;
    }

    @Override
    public void execute(Mower mower) {
        mower.turnLeft();
    }
}
