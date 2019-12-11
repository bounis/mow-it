package org.mow.it.domain;

public class EastState extends State {

    private static final EastState eastState = new EastState();
    private EastState() {
    }

    public static EastState getInstance() {
        return eastState;
    }

    @Override
    public void turnRight() {
        mower.getPosition().setOrientation(Orientation.SOUTH);
        SouthState southState = SouthState.getInstance();
        southState.setMower(mower);
        mower.setState(southState);
    }

    @Override
    public void turnLeft() {
        this.mower.getPosition().setOrientation(Orientation.NORTH);
        NorthState northState = NorthState.getInstance();
        northState.setMower(mower);
        mower.setState(northState);
    }

    @Override
    public void advance() {

        int previousAbsciss = mower.getPosition().getCoordinate().getAbsciss();
        int newAbsciss = previousAbsciss + 1;

        Point newCoordinate = new Point(newAbsciss,
            mower.getPosition().getCoordinate().getOrdinate());

        if (canAdvance(newCoordinate)) {
            mower.getPosition().getCoordinate().setAbsciss(newAbsciss);
        }
    }

    private boolean canAdvance(Point newCoordinate) {
        return !isCoordinateTakenByOtherMower(newCoordinate) &&
            newCoordinate.getAbsciss() <= Pelouse.getInstance().getUpperCornerCoordinate().getAbsciss();
    }
}
