package fr.li212.codingame.zombies.ia;

import fr.li212.codingame.zombies.ia.entities.Coordinate;
import fr.li212.codingame.zombies.ia.entities.Situation;
import fr.li212.codingame.zombies.ia.io.TurnInput;
import fr.li212.codingame.zombies.ia.io.TurnOutput;

public class PlayTurn {
    private final TurnInput turnInput;
    private final TurnOutput turnOutput;

    public PlayTurn(final TurnInput turnInput, final TurnOutput turnOutput) {
        this.turnInput = turnInput;
        this.turnOutput = turnOutput;
    }

    public void play(){
        final Situation situation = turnInput.get();
        turnOutput.output(new Coordinate(0,0));
    }
}
