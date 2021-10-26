package fr.li212.codingame.zombies.ia.entities;

import fr.li212.codingame.zombies.ia.entities.actors.Actor;

import java.util.Collection;

public class ActorGroup<T extends Actor> {
    private final Collection<T> actors;

    public ActorGroup(final Collection<T> actors) {
        this.actors = actors;
    }

    public Coordinate getBarycentre() {
        final int baryX = actors.stream().map(actor -> actor.getCoordinate().getX()).reduce(0, Integer::sum) / actors.size();
        final int baryY = actors.stream().map(actor -> actor.getCoordinate().getY()).reduce(0, Integer::sum) / actors.size();
        return new Coordinate(baryX, baryY);
    }
}
