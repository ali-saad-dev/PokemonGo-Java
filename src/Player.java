package src;

public class Player {
    private String name;
    private Pokèmon selectedPokèmon;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void selectPokèmon(Pokèmon pokèmon) {
        this.selectedPokèmon = pokèmon;
    }

    public Pokèmon getSelectedPokèmon() {
        return selectedPokèmon;
    }
}
