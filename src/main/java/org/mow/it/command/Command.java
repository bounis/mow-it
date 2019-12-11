package org.mow.it.command;

import org.mow.it.domain.Mower;

@FunctionalInterface
public interface Command {

    void execute(Mower mower);
}
