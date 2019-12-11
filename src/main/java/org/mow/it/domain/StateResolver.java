package org.mow.it.domain;

import org.mow.it.exception.UnknownOrientationException;

public class StateResolver {

    public static State resolve(Orientation orientation) {
        switch (orientation) {
            case EAST:
                return EastState.getInstance();
            case WEST:
                return WestState.getInstance();
            case NORTH:
                return NorthState.getInstance();
            case SOUTH:
                return SouthState.getInstance();
        }
        throw new UnknownOrientationException("unknown orientation provided");
    }
}
