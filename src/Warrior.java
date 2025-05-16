public class Warrior {
    private int power;
    private int visibility;
    private WarriorAttackStrategy attackStrategy;
    
    public Warrior(int power, int visibility, WarriorAttackStrategy attackStrategy) {
        this.power = power;
        this.visibility = visibility;
        this.attackStrategy = attackStrategy;
    }
    
    public void attack(AlienArmy alienArmy, Satellite satellite, Telescope telescope) {
        attackStrategy.attack(alienArmy, satellite, telescope);
        increaseVisibility(15);
    }
    
    public int getPower() {
        return power;
    }
    
    public int getVisibility() {
        return visibility;
    }
    
    public void decreasePower(int amount) {
        this.power -= amount;
        if (this.power < 0) {
            this.power = 0;
        }
    }
    
    public void decreaseVisibility(int amount) {
        this.visibility -= amount;
        if (this.visibility < 0) {
            this.visibility = 0;
        }
    }
    
    public void increaseVisibility(int amount) {
        this.visibility += amount;
        if (this.visibility > 100) {
            this.visibility = 100;
        }
    }
    
    public void setAttackStrategy(WarriorAttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    
    public boolean isDefeated() {
        return power <= 0;
    }
}