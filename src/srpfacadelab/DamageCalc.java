package srpfacadelab;

public class DamageCalc {
    private RpgPlayer player;

    public DamageCalc(RpgPlayer player) {
        this.player = player;
    }
    
    public void takeDamage(int damage) {
        int damageToDeal = damage - player.getArmour();
        
        if (player.calculateInventoryWeight() < (player.getCarryingCapacity() / 2)) {
            damageToDeal = damageToDeal - (int)(damageToDeal * .25);
        }

        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        player.setHealth(player.getHealth() - damageToDeal);
        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }
}