class Arqueiro extends Personagem {
    public Arqueiro(String nome) { super(nome, 90, 80, 8, 15, 7); }

    @Override
    public boolean ehCritico() {
        double chance = 0.10 + destreza * 0.005;
        return rng.nextDouble() < chance;
    }

    @Override
    protected int aplicarReducaoDano(int dano) {
        if (rng.nextDouble() < 0.25) {  //usando um random para reducao de dano 
            System.out.printf("%s esquivou do ataque!\n", nome);
            return 0;
        }
        return dano;
    }
}

class Mago extends Personagem {
    public Mago(String nome) { super(nome, 70, 150, 5, 7, 18); }

    @Override
    public void regenerarFinalTurno() { 
        int antes = mana;
        mana = Math.min(manaMaxima, mana + 10);
        if (mana != antes)
            System.out.printf("%s regenera 10 de mana (%d -> %d)\n", nome, antes, mana);
    }
}