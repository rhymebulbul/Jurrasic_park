package game.gamemode;

import edu.monash.fit2099.engine.*;
import game.Floor;
import game.Player;
import game.Wall;
import game.actor.dinosaur.Brachiosaur;
import game.actor.dinosaur.Stegosaur;
import game.vegetation.Bush;
import game.vegetation.Dirt;
import game.vegetation.Lake;
import game.vegetation.Tree;

import java.util.Arrays;
import java.util.List;

/**
 * Just your regular freeplay game
 */
public class Sandbox {
    public static void sandboxRun(){
        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Bush(), new Lake());

        List<String> map = Arrays.asList(
                "................................................................................",
                ".......................................................~~~~~~...................",
                ".....#######.............................................~~~~~..................",
                ".....#_____#.............*******...........................~~~~~~~~~............",
                ".....#_____#................***..................................~~~~...........",
                ".....###.###....................................................................",
                "................................................................................",
                "......................................+++.......................................",
                ".......................................++++..........~~~~.......................",
                "...................................+++++...............~~~......................",
                ".....................................++++++.....................................",
                "......................................+++.......................................",
                ".....................................+++....................~...................",
                "................................................................................",
                "............+++.................................................................",
                ".............+++++..............................................................",
                "...............++........................................+++++..................",
                ".............+++....................................++++++++....................",
                "............+++.......................................+++.......................",
                "................................................................................",
                ".........................................................................++.....",
                "...........................***..........................................++.++...",
                ".........................*******.........................................++++...",
                "............................*******.......................................++....",
                "................................................................................");

        List<String> secondMap = Arrays.asList(
                "................................................................................",
                "................................................................................",
                "................................................................................",
                ".........................*******................................................",
                "............................***.................................................",
                "................................................................................",
                "................................................................................",
                "......................................+++.......................................",
                ".......................................++++.....................................",
                "...................................+++++........................................",
                ".....................................++++++.....................................",
                "......................................+++.......................................",
                ".....................................+++........................................",
                "................................................................................",
                "............+++.................................................................",
                ".............+++++..............................................................",
                "...............++........................................+++++..................",
                ".............+++....................................++++++++....................",
                "............+++.......................................+++.......................",
                "................................................................................",
                ".........................................................................++.....",
                "...........................***..........................................++.++...",
                ".........................*******.........................................++++...",
                "............................*******.......................................++....",
                "................................................................................");

        GameMap gameMap = new GameMap(groundFactory, map);
        GameMap secondGameMap = new GameMap(groundFactory, secondMap);


        world.addGameMap(gameMap);
        world.addGameMap(secondGameMap);

        Actor player = new Player("Player", '@', 100);
        world.addPlayer(player, gameMap.at(9, 4));

        // Place a pair of stegosaurs in the middle of the map
        gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur"));
        gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur"));

        gameMap.at(36, 16).addActor(new Brachiosaur("Brachiosaur", "M"));
        gameMap.at(38, 18).addActor(new Brachiosaur("Brachiosaur", "F"));
        gameMap.at(31, 20).addActor(new Brachiosaur("Brachiosaur", "M"));
        gameMap.at(37, 21).addActor(new Brachiosaur("Brachiosaur", "F"));

        world.run();
    }
}

