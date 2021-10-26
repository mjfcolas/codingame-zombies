package fr.li212.codingame.zombies.ia;

import fr.li212.codingame.zombies.ia.entities.ActorGroup;
import fr.li212.codingame.zombies.ia.entities.Coordinate;
import fr.li212.codingame.zombies.ia.entities.Situation;
import fr.li212.codingame.zombies.ia.entities.actors.Human;

public class ComputePosition {
    public Coordinate compute(final Situation situation){
        final ActorGroup<Human> humans = new ActorGroup<>(situation.getHumans());
        return humans.getBarycentre();
    }
}
