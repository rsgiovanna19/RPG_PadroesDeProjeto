class Paladino extends Personagem {
    public Paladino(String nome) { super(nome, 110, 100, 12, 10, 10); }

    @Override
    protected int aplicarReducaoDano(int dano) {
        return (int)Math.round(dano * 0.9);
    }

    @Override
    public void regenerarFinalTurno() {
        if (estaVivo()) {
            int antes = vida;
            vida = Math.min(vidaMaxima, vida + 5);
            if (vida != antes)
                System.out.printf("%s regenera 5 HP (%d -> %d)\n", nome, antes, vida);
        }
    }
}
