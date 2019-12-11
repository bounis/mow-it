package org.mow.it.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Mower {

    private Position position;
    private State state;

    public void turnRight() {
        this.state.turnRight();
    }

    public void turnLeft() {
        this.state.turnLeft();
    }

    public void advance() {
        this.state.advance();
    }

}
