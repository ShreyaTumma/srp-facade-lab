package srpfacadelab;
import java.util.List;
import java.util.ArrayList;

public class Inventory {

    private RpgPlayer player;
    
    //initialize inventory for each player
    public Inventory(RpgPlayer player) {
        this.player = player;
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

        player.getInventoryList().add(item);
        calculateStats();
        return true;
    }
    
    public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.getInventoryList()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.getInventoryList()) {
            sum += i.getWeight();
        }
        return sum;
    }

    public void calculateStats() {
        for (Item i: player.getInventoryList()) {
            player.setArmour(player.getArmour()+ i.getArmour());
        }
    }
}