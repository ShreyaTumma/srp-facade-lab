package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {

    private final IGameEngine gameEngine;
    private Inventory inventory;
    private Damage damageCalc;

    private int health;
    private int maxHealth;
    private int armour;
    private int damage;
    public static final int MAX_CARRYING_CAPACITY = 1000;
    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new Inventory(this);
        damageCalc = new Damage(this);
        carryingCapacity = MAX_CARRYING_CAPACITY;
        
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public Inventory getInventory(){
        return inventory;
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    public IGameEngine getGameEngine() {
        return gameEngine;
    }

    public List<IEnemy> getEnemies(){
        return gameEngine.getEnemiesNear(this);
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    private void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
