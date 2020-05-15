package srpfacadelab;

public class RpgPlayerFacade {

    public final RpgPlayer player;
    public final Inventory inventory;
    public final DamageCalc damageCalc;

    public RpgPlayerFacade(IGameEngine gameEngine){
        this.player = new RpgPlayer(gameEngine);
        this.inventory = new Inventory(player);
        this.damageCalc = new DamageCalc(player);                
    }

    public void useItem(Item item) {
        inventory.useItem(item);
    }
    public boolean pickUpItem(Item item) {
        return inventory.pickUpItem(item);
    }

    public void takeDamage(int damage) {
        int inventoryWeight = inventory.calculateInventoryWeight();
        damageCalc.takeDamage(damage, inventoryWeight);
    }
    
}