package fr.li212.codingame.zombies.application.codingame;

import fr.li212.codingame.zombies.application.codingame.io.CodingameTurnInput;
import fr.li212.codingame.zombies.application.codingame.io.CodingameTurnOutput;
import fr.li212.codingame.zombies.ia.PlayTurn;
import fr.li212.codingame.zombies.ia.io.TurnInput;
import fr.li212.codingame.zombies.ia.io.TurnOutput;

import java.util.Scanner;

class Player {
    private static final Scanner IN = new Scanner(System.in);
    private static final TurnInput TURN_INPUT = new CodingameTurnInput(IN);
    private static final TurnOutput TURN_OUTPUT = new CodingameTurnOutput();
    private static final PlayTurn PLAY_TURN = new PlayTurn(TURN_INPUT, TURN_OUTPUT);

    public static void main(String args[]) {
        while (true) {
            PLAY_TURN.play();
        }
    }
}
