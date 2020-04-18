package srpfacadelab;

public class Damage {
    private RpgPlayer player;

    public Damage(RpgPlayer player) {
        this.player = player;
    }
    
    public void takeDamage(int damage) {
        if (player.getInventory().getInventoryWeight() < (player.getCarryingCapacity() / 2)) {
            player.setDamage((player.getDamage() - (int)(player.getDamage() * (25/100))));
        }
        
        if (player.getDamage() < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        player.setHealth(player.getHealth()- damageToDeal);

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }
}