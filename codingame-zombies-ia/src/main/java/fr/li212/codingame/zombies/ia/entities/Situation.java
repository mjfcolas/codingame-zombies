package fr.li212.codingame.zombies.ia.entities;

import fr.li212.codingame.zombies.ia.entities.actors.Ash;
import fr.li212.codingame.zombies.ia.entities.actors.Human;
import fr.li212.codingame.zombies.ia.entities.actors.Zombie;

import java.util.Collection;

public class Situation {
    private final Ash ash;
    private final Collection<Human> humans;
    private final Collection<Zombie> zombies;

    public Situation(final Ash ash, final Collection<Human> humans, final Collection<Zombie> zombies) {
        this.ash = ash;
        this.humans = humans;
        this.zombies = zombies;
    }

    public Ash getAsh() {
        return ash;
    }

    public Collection<Zombie> getZombies() {
        return zombies;
    }

    public Collection<Human> getHumans() {
        return humans;
    }
}
