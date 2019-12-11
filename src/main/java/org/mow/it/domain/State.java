package org.mow.it.domain;

import lombok.Setter;

@Setter
public abstract class State {

    protected Mower mower;

    public abstract void turnRight();
    public abstract void turnLeft();
    public abstract void advance();

    protected boolean isCoordinateTakenByOtherMower(Point newCoordinate) {
        return Pelouse.getInstance().getMowers().stream()
            .filter(mow -> mow.getPosition().getCoordinate().equals(newCoordinate)).count() > 0;
    }
}
