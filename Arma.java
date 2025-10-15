import java.util.List;

interface Arma {
    String getNome();
    int getDanoBase();
    int getCustoMana();
    boolean podeUsar(Personagem usuario);
    void atacar(Personagem usuario, List<Personagem> alvos, Batalha batalha);
}

enum TipoEfeito { SANGRAMENTO, QUEIMADURA, ATORDOAMENTO }
