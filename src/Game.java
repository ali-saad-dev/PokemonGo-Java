package src;


import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, enter your name:");
        String player1Name = scanner.nextLine();
        player1 = new Player(player1Name);

        System.out.println("Player 2, enter your name:");
        String player2Name = scanner.nextLine();
        player2 = new Player(player2Name);

        // Let players select their Pokémon
        selectPokèmon(player1);
        selectPokèmon(player2);

        // Print selected Pokémon for both players
        System.out.println(player1.getName() + " selected " + player1.getSelectedPokèmon().getName());
        System.out.println(player2.getName() + " selected " + player2.getSelectedPokèmon().getName());

        // Implement your battle logic here
        battle(player1, player2);
    }

    private void selectPokèmon(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + ", select your Pokémon:");
        System.out.println("1. Fire Pokémon");
        System.out.println("2. Water Pokémon");
        System.out.println("3. Grass Pokémon");
        System.out.println("4. Electric Pokémon");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                player.selectPokèmon(new FirePokèmon("Charminder","meet","chaaar","fire",50,75,40,"FirePunch","water",100));
                break;
            case 2:
                player.selectPokèmon(new WaterPokèmon("Squirtle","waterGraas","squirlSquirl","water",70,60,40,"waterPunsh","fire"));
                break;
            case 3:
                player.selectPokèmon(new GrassPokèmon("Bulbasaur","grass","Bulbasauuur","grass",60,100,100,"grassStorm","fire"));
                break;
            case 4:
                player.selectPokèmon(new ElectricPokèmon("Pikachū","frut","pikaPika","Elctric",100,100,100,"ElctricThinder","water"));
                break;

            default:
                System.out.println("Invalid choice. Selecting default Fire Pokémon.");
                player.selectPokèmon(new FirePokèmon("Charizard", "Flames", "Roar", "Fire", 100, 50, 30, "Flamethrower", "Water",100));
                break;
        }
    }
    private int calculateDamage(Pokèmon attacker, Pokèmon defender) {
        Random random = new Random();
        double damage = (random.nextDouble() * 0.5 + 0.7) * (attacker.getAttack() - defender.getDefense());

        // Apply type advantages
        if (attacker.getType().equals("Fire") && defender.getType().equals("Grass")) {
            damage *= 1.5; // Fire is strong against Grass
        } else if (attacker.getType().equals("Water") && defender.getType().equals("Fire")) {
            damage *= 1.5; // Water is strong against Fire
        } else if (attacker.getType().equals("Grass") && defender.getType().equals("Water")) {
            damage *= 1.5; // Grass is strong against Water
        }

        // Apply special attack bonus
        if (random.nextDouble() < 0.2 && attacker instanceof FirePokèmon) {
            // 20% chance of special attack bonus for Fire Pokémon
            damage += ((FirePokèmon) attacker).getSpecialAttackDamage();
            System.out.println(attacker.getName() + " used special attack!");
        }

        return (int) damage;
    }
    private void battle(Player player1, Player player2) {
        Player attacker = player1;
        Player defender = player2;

        while (player1.getSelectedPokèmon().getHp() > 0 && player2.getSelectedPokèmon().getHp() > 0) {
            int damage = calculateDamage(attacker.getSelectedPokèmon(), defender.getSelectedPokèmon());
            defender.getSelectedPokèmon().setHp(defender.getSelectedPokèmon().getHp() - damage);

            System.out.println(attacker.getName() + "'s " + attacker.getSelectedPokèmon().getName() +
                    " attacks " + defender.getName() + "'s " + defender.getSelectedPokèmon().getName() +
                    " for " + damage + " damage!");

            // Switch attacker and defender for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Determine the winner of the battle
        Player winner = player1.getSelectedPokèmon().getHp() > 0 ? player1 : player2;
        System.out.println(winner.getName() + "'s " + winner.getSelectedPokèmon().getName() + " wins the battle!");
    }

}
