package src;

public class FirePokèmon extends Pokèmon {
private String specialAttack;
private String weakness;
private int specialAttackDamage;


    public FirePokèmon(String name, String food, String sound, String type, int hp, int attack, int defense, String specialAttack, String weakness,int specialAttackDamage) {
        super(name, food, sound, type, hp, attack, defense);
        this.specialAttack = specialAttack;
        this.weakness = weakness;
        this.specialAttackDamage = specialAttackDamage;
    }

    public String cheackWeakness(String weakness) {
        if(weakness.equals("water")){
            weakness = "water";
        } else {
            weakness = "notHarmed";
        }
        return weakness;
    }

    @Override
    public void print() {
        System.out.println("Pokemon " + getName() + " eats " + getFood() + " voice " + speaks() + " type " + getType() + " Hp " + getHp() + " attack " + getAttack() + " defense " + getDefense() + " specialAttack " + getSpecialAttack() + " weakness " + cheackWeakness(weakness) );
    }

    @Override
    public String speaks() {
        return "is " + getSound();
    }

    public String getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
    public int getSpecialAttackDamage() {
        return specialAttackDamage;
    }

    public void setSpecialAttackDamage(int specialAttackDamage) {
        this.specialAttackDamage = specialAttackDamage;
    }
}
