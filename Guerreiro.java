class Guerreiro extends Personagem {
    public Guerreiro(String nome) { super(nome, 120, 50, 15, 8, 5); }

    @Override
    protected int aplicarReducaoDano(int dano) {
        // Pele Dura: reduz 20% do dano
        return (int)Math.round(dano * 0.8);
    }
}
