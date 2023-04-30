package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Warrior extends kg.geeks.game.players.Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, name, kg.geeks.game.players.SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(kg.geeks.game.players.Boss boss, kg.geeks.game.players.Hero[] heroes) {
        int coefficient = RPG_Game.random.nextInt(5) + 2;
        boss.setHealth(boss.getHealth() - coefficient * this.getDamage());
        System.out.println("Warrior hits critically: " + coefficient * this.getDamage());
    }
}

