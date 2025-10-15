import java.util.List;
import java.util.Random;

class EspadaLonga implements ArmaCorpoACorpo {
    private Random rng = new Random();
    @Override public String getNome() { return "Espada Longa"; }
    @Override public int getDanoBase() { return 15; }
    @Override public int getCustoMana() { return 0; }
    @Override public boolean podeUsar(Personagem usuario) { return usuario.forca >= 10; }

    @Override
    public void atacar(Personagem usuario, List<Personagem> alvos, Batalha batalha) {
        usuario.mana -= getCustoMana();
        Personagem alvo = alvos.get(0);
        int dano = usuario.calcularDanoComAtributos(getDanoBase());
        alvo.receberDano(dano);
        if (rng.nextDouble() < 0.30) alvo.aplicarEfeito(new Sangramento(5,3));
    }
}