import java.util.List;
import java.util.Random;

class MachadoGuerra implements ArmaCorpoACorpo {
    private Random rng = new Random();
    @Override public String getNome() { return "Machado de Guerra"; }
    @Override public int getDanoBase() { return 18; }
    @Override public int getCustoMana() { return 5; }
    @Override public boolean podeUsar(Personagem usuario) { return usuario.forca >= 15; }

    @Override
    public void atacar(Personagem usuario, List<Personagem> alvos, Batalha batalha) {
        usuario.mana -= getCustoMana();
        Personagem alvo = alvos.get(0);
        int dano = usuario.calcularDanoComAtributos(getDanoBase());
        alvo.receberDano(dano);
        if (rng.nextDouble() < 0.25) alvo.aplicarEfeito(new Atordoamento(1));
    }
}