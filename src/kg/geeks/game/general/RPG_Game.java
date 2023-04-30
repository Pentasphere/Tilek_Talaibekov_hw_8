package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame() {
        kg.geeks.game.players.Boss boss = new kg.geeks.game.players.Boss(1000, 50, "Usama");
        kg.geeks.game.players.Warrior warrior = new kg.geeks.game.players.Warrior(290, 10, "Arthur");
        kg.geeks.game.players.Medic doc = new kg.geeks.game.players.Medic(250, 5, 15, "Zarlyk");
        kg.geeks.game.players.Magic magic = new kg.geeks.game.players.Magic(280, 15, "Merlin");
        kg.geeks.game.players.Berserk berserk = new kg.geeks.game.players.Berserk(270, 10, "Gats");
        kg.geeks.game.players.Medic assistant = new kg.geeks.game.players.Medic(270, 5, 5, "Strange");
        kg.geeks.game.players.Thour thour = new kg.geeks.game.players.Thour(290, 20, "Thunder");
        kg.geeks.game.players.Hero[] heroes = {warrior, doc, magic, berserk, assistant, thour};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(kg.geeks.game.players.Boss boss, kg.geeks.game.players.Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameFinished(kg.geeks.game.players.Boss boss, kg.geeks.game.players.Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(kg.geeks.game.players.Boss boss, kg.geeks.game.players.Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 &&
                    boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].hit(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }
}
