package org.mow.it.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Position {

    private Point coordinate;
    private Orientation orientation;


    public static Position createPosition(String positonLine) {
        String regex = " ";
        String[] strings = positonLine.split(regex);
        return new Position
                (new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])), Orientation.fromValue(strings[2]));
    }

    @Override
    public String toString() {
        return coordinate.getAbsciss() + " "
                + coordinate.getOrdinate() + " "
                + orientation.getAcrony();
    }
}
