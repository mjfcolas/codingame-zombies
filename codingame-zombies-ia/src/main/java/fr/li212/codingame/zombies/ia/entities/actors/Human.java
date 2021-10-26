package fr.li212.codingame.zombies.ia.entities.actors;

import fr.li212.codingame.zombies.ia.entities.Coordinate;

public class Human {
    private final Coordinate coordinate;

    public Human(final Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
