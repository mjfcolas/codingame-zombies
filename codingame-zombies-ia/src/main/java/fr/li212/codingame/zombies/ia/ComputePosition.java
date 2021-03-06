package fr.li212.codingame.zombies.ia;

import fr.li212.codingame.zombies.ia.entities.Coordinate;
import fr.li212.codingame.zombies.ia.entities.Situation;
import fr.li212.codingame.zombies.ia.entities.actors.Ash;
import fr.li212.codingame.zombies.ia.entities.actors.Human;
import fr.li212.codingame.zombies.ia.entities.actors.Zombie;

import java.util.Comparator;
import java.util.Optional;

public class ComputePosition {
    public Coordinate compute(final Situation situation) {
        final Ash ash = situation.getAsh();

        final Human mostAtRiskHumanThanCanBeSaved = situation.getHumans().stream()
                .sorted((human1, human2) -> {
                    final Zombie zombieClosestToHuman1 = situation.getZombies().stream().min(Comparator.comparingInt(zc -> human1.getCoordinate().squareDistance(zc.getCoordinate()))).get();
                    final Zombie zombieClosestToHuman2 = situation.getZombies().stream().min(Comparator.comparingInt(zc -> human2.getCoordinate().squareDistance(zc.getCoordinate()))).get();
                    return zombieClosestToHuman1.getCoordinate().squareDistance(human1.getCoordinate()) - zombieClosestToHuman2.getCoordinate().squareDistance(human2.getCoordinate());
                }).filter(human -> {
                    final Zombie closestZombie = situation.getZombies().stream().min(Comparator.comparingInt(z -> human.getCoordinate().squareDistance(z.getCoordinate()))).get();
                    double distanceHumanZombie = Math.sqrt(closestZombie.getCoordinate().squareDistance(human.getCoordinate()));
                    double distanceAshZombieInRange = Math.sqrt(closestZombie.getCoordinate().squareDistance(ash.getCoordinate())) - 2000;
                    return distanceHumanZombie / GlobalParameters.ZOMBIE_SPEED > distanceAshZombieInRange / GlobalParameters.ASH_SPEED;
                }).findFirst().orElseThrow(() -> new IllegalStateException("No humans left to be saved"));

        final Optional<Zombie> zombieClosestToMostAtRiskHumanThanCanBeSaved = situation.getZombies().stream()
                .min(Comparator.comparingInt(z -> mostAtRiskHumanThanCanBeSaved.getCoordinate().squareDistance(z.getCoordinate())));
        return zombieClosestToMostAtRiskHumanThanCanBeSaved.orElseThrow(() -> new IllegalStateException("No zombies left")).getCoordinate();
    }
}
