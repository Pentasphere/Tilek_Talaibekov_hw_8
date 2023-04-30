package kg.geeks.game.players;

public abstract class Hero extends kg.geeks.game.players.GameEntity
        implements kg.geeks.game.players.HavingSuperAbility {
    private SuperAbility ability;

    public Hero(int health, int damage,
                String name, SuperAbility ability) {
        super(health, damage, name);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void hit(kg.geeks.game.players.Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }
}

