package org.mow.it.domain;

import java.util.ArrayList;
import java.util.List;


public class Pelouse {

    private static Pelouse pelouse;

    private Point upperCornerCoordinate;
    private Point lowerCornerCoordinate;
    private List<Mower> mowers = new ArrayList<>();

    private Pelouse() {
    }


    public static Pelouse getInstance() {
        return pelouse;
    }

    public static void createPelouseIfNotExist(String pelouseCoordinateLine) {
        if (pelouse == null) {
            String regex = " ";
            String[] upperCr = pelouseCoordinateLine.split(regex);
            pelouse = new Pelouse(new Point(Integer.parseInt(upperCr[0]), Integer.parseInt(upperCr[1])));
        }
    }


    public Pelouse(Point upperCornerCoordinate) {
        this.upperCornerCoordinate = upperCornerCoordinate;
        this.lowerCornerCoordinate = new Point(0,0);
    }

    public Point getUpperCornerCoordinate() {
        return upperCornerCoordinate;
    }

    public Point getLowerCornerCoordinate() {
        return lowerCornerCoordinate;
    }

    public void addMower(Mower mower) {
        mowers.add(mower);
    }

    public List<Mower> getMowers() {
        return mowers;
    }
}
