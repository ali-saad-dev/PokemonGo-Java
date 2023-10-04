package src;

public abstract class Pokèmon {
private String name;
private String food;
private String sound;
private String type;
private int hp;
private int attack;
private int defense;


    public Pokèmon(String name, String food, String sound, String type, int hp, int attack, int defense) {
        this.name = name;
        this.food = food;
        this.sound = sound;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public abstract void print();
    public abstract String speaks();

}
