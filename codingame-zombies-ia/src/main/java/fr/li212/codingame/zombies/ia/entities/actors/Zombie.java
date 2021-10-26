package fr.li212.codingame.zombies.ia.entities.actors;

import fr.li212.codingame.zombies.ia.entities.Coordinate;

public class Zombie implements Actor {
    private final Coordinate coordinate;
    private final Coordinate nextCoordinates;

    public Zombie(final Coordinate coordinate, final Coordinate nextCoordinates) {
        this.coordinate = coordinate;
        this.nextCoordinates = nextCoordinates;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Coordinate getNextCoordinates() {
        return nextCoordinates;
    }
}
