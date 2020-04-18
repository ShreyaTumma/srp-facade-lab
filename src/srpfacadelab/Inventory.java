package srpfacadelab;
import java.util.List;
import java.util.ArrayList;

public class Inventory {

    private List<Item> inventory;
    private RpgPlayer player;
    private int inventoryWeight;

    //initialize inventory for each player
    public Inventory(RpgPlayer player) {
        inventory = new ArrayList<Item>();
        this.player = player;
    }
    
    public List<Item> getInventory(){
        return inventory;
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getEnemies();
            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item) {
        int weight = calculateInventoryWeight();
        
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(item.getHeal() + player.getHealth());
           
            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());
            if (item.getHeal() > 500) {
                player.getGameEngine().playSpecialEffect("green_swirly");
            }
            return true;
        }
        if (item.isRare() && item.isUnique()){
            player.getGameEngine().playSpecialEffect("blue_swirly");
        }
        else if (item.isRare())
            player.getGameEngine().playSpecialEffect("cool_swirly_particles");

        inventory.add(item);
        calculateStats();
        return true;
    }
    
    private boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    private int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        inventoryWeight = sum;
        return sum;
    }

    public int getInventoryWeight(){
        return inventoryWeight;
    }
    
    private void calculateStats() {
        for (Item i: inventory) {
            player.setArmour(player.getArmour()+ i.getArmour());
        }
    }


}