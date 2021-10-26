package fr.li212.codingame.zombies.application.codingame.io;

import fr.li212.codingame.zombies.ia.entities.Coordinate;
import fr.li212.codingame.zombies.ia.io.TurnOutput;

public class CodingameTurnOutput implements TurnOutput {
    @Override
    public void output(final Coordinate coordinate) {
        System.out.println(coordinate.getX() + " " + coordinate.getY());
    }
}
