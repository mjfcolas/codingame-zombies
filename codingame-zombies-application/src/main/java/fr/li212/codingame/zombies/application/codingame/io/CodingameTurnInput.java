package fr.li212.codingame.zombies.application.codingame.io;

import fr.li212.codingame.zombies.ia.entities.Coordinate;
import fr.li212.codingame.zombies.ia.entities.Situation;
import fr.li212.codingame.zombies.ia.entities.actors.Ash;
import fr.li212.codingame.zombies.ia.entities.actors.Human;
import fr.li212.codingame.zombies.ia.entities.actors.Zombie;
import fr.li212.codingame.zombies.ia.io.TurnInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodingameTurnInput implements TurnInput {

    private final Scanner in;

    public CodingameTurnInput(final Scanner in) {
        this.in = in;
    }

    @Override
    public Situation get() {
        final Ash ash = new Ash(new Coordinate(in.nextInt(), in.nextInt()));
        final List<Human> humans = new ArrayList<>();
        final List<Zombie> zombies = new ArrayList<>();
        int humanCount = in.nextInt();
        for (int i = 0; i < humanCount; i++) {
            int humanId = in.nextInt();
            humans.add(new Human(new Coordinate(in.nextInt(), in.nextInt())));
        }
        int zombieCount = in.nextInt();
        for (int i = 0; i < zombieCount; i++) {
            int zombieId = in.nextInt();
            zombies.add(new Zombie(
                    new Coordinate(in.nextInt(), in.nextInt()),
                    new Coordinate(in.nextInt(), in.nextInt())));
        }

        return new Situation(ash, humans, zombies);
    }
}
