import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SistemaCombateRPG {
    public static void main(String[] args) {
        Guerreiro g = new Guerreiro("Thorin (Guerreiro)");
        Arqueiro a = new Arqueiro("Lyria (Arqueira)");
        Mago m = new Mago("Eldrin (Mago)");
        Paladino p = new Paladino("Ulric (Paladino)");

        EspadaLonga espada = new EspadaLonga();
        MachadoGuerra machado = new MachadoGuerra();

        g.equipar(espada);
        p.equipar(machado);

        List<Personagem> timeA = Arrays.asList(g, a);
        List<Personagem> timeB = Arrays.asList(m, p);

        Batalha batalha = new Batalha(new ArrayList<>(timeA), new ArrayList<>(timeB));
        batalha.iniciar();
    }
}