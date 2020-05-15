package srpfacadelab;
import java.util.List;
import java.util.ArrayList;

public class RpgPlayer {

    private final IGameEngine gameEngine;
    private int health;
    private int maxHealth;
    private int armour;
    private List<Item> inventory = new ArrayList<Item>();
    public static final int MAX_CARRYING_CAPACITY = 1000;
    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        carryingCapacity = MAX_CARRYING_CAPACITY;
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

    public List<Item> getInventoryList() {
        return inventory;
    }
}
