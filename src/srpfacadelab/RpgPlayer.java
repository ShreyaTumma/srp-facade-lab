package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {

    private final IGameEngine gameEngine;
    private final Inventory inventory;
    private final DamageCalc damageCalc;

    private int health;
    private int maxHealth;
    private int armour;

    public static final int MAX_CARRYING_CAPACITY = 1000;
    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.inventory = new Inventory(this);
        this.damageCalc = new DamageCalc(this);
        carryingCapacity = MAX_CARRYING_CAPACITY;
        
    }

    public void useItem(Item item) {
        inventory.useItem(item);
    }

    public boolean pickUpItem(Item item) {
        return inventory.pickUpItem(item);
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        return inventory.checkIfItemExistsInInventory(item);
    }

    public int calculateInventoryWeight() {
        return inventory.getInventoryWeight();
    }

    public void calculateStats(){
        inventory.calculateStats();
    }
    
    public void takeDamage(int damage){
        damageCalc.takeDamage(damage);
    }

    //getters and setters for player
    public List<Item> getInventory(){
        return inventory.getInventory();
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
