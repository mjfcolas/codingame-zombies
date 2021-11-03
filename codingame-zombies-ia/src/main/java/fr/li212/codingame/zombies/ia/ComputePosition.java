package fr.li212.codingame.zombies.ia;

import fr.li212.codingame.zombies.ia.entities.Coordinate;
import fr.li212.codingame.zombies.ia.entities.Situation;
import fr.li212.codingame.zombies.ia.entities.actors.Ash;
import fr.li212.codingame.zombies.ia.entities.actors.Zombie;

import java.util.Comparator;

public class ComputePosition {
    public Coordinate compute(final Situation situation) {
        final Ash ash = situation.getAsh();

        final Zombie zombieClosestToMostAtRiskHumanThanCanBeSaved = situation.getHumans().stream()
                .sorted((human1, human2) -> {
                    final Zombie zombieClosestToHuman1 = situation.getZombies().stream().min(Comparator.comparingInt(zc -> human1.getCoordinate().squareDistance(zc.getCoordinate()))).get();
                    final Zombie zombieClosestToHuman2 = situation.getZombies().stream().min(Comparator.comparingInt(zc -> human2.getCoordinate().squareDistance(zc.getCoordinate()))).get();
                    return zombieClosestToHuman1.getCoordinate().squareDistance(human1.getCoordinate()) - zombieClosestToHuman2.getCoordinate().squareDistance(human2.getCoordinate());
                }).filter(human -> {
                    final Zombie closestZombie = situation.getZombies().stream()
                            .sorted(Comparator.comparingInt(z -> human.getCoordinate().squareDistance(z.getCoordinate()))).findFirst().get();
                    double distanceHumanZombie = Math.sqrt(closestZombie.getCoordinate().squareDistance(human.getCoordinate()));
                    double distanceAshZombieInRange = Math.sqrt(closestZombie.getCoordinate().squareDistance(ash.getCoordinate())) - 2000;
                    return distanceHumanZombie / GlobalParameters.ZOMBIE_SPEED > distanceAshZombieInRange / GlobalParameters.ASH_SPEED;
                }).map(human -> situation.getZombies().stream().sorted(Comparator.comparingInt(z -> human.getCoordinate().squareDistance(z.getCoordinate()))).findFirst().get()).findFirst().get();


        return zombieClosestToMostAtRiskHumanThanCanBeSaved.getCoordinate();
    }
}
