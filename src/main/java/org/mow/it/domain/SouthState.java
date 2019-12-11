package org.mow.it.domain;

public class SouthState extends State {

    private static final SouthState southState = new SouthState();

    private SouthState() {
    }

    public static SouthState getInstance() {
        return southState;
    }

    @Override
    public void turnRight() {
        mower.getPosition().setOrientation(Orientation.WEST);
        WestState westState = WestState.getInstance();
        westState.setMower(mower);
        mower.setState(westState);

    }

    @Override
    public void turnLeft() {
        mower.getPosition().setOrientation(Orientation.EAST);
        EastState eastState = EastState.getInstance();
        eastState.setMower(mower);
        mower.setState(eastState);
    }

    @Override
    public void advance() {
        int previousOrdinate = mower.getPosition().getCoordinate().getOrdinate();
        int newOrdinate = previousOrdinate - 1;

        Point newCoordinate = new Point(mower.getPosition().getCoordinate().getAbsciss(),
            newOrdinate);

        if (canAdvance(newCoordinate)) {
            mower.getPosition().getCoordinate().setOrdinate(newOrdinate);
        }
    }

    private boolean canAdvance(Point newCoordinate) {
        return !isCoordinateTakenByOtherMower(newCoordinate) &&
            newCoordinate.getOrdinate() >= Pelouse.getInstance().getLowerCornerCoordinate().getOrdinate();
    }
}
