package fr.li212.codingame.zombies.ia.entities.actors;

import fr.li212.codingame.zombies.ia.entities.Coordinate;

public class Ash implements Actor {
    private final Coordinate coordinate;

    public Ash(final Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
