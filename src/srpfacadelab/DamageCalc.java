package srpfacadelab;

public class DamageCalc {
    private RpgPlayer player;

    public DamageCalc(RpgPlayer player) {
        this.player = player;
    }
    
    public void takeDamage(int damage) {
        if (player.calculateInventoryWeight() < (player.getCarryingCapacity() / 2)) {
            player.setDamage((player.getDamage() - (int)(player.getDamage() * 0.25)));
        }
        
        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();
        player.setHealth(player.getHealth()- damageToDeal);

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }
}