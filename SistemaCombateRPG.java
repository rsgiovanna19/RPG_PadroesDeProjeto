//imports necessárops - lists 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SistemaCombateRPG {
    public static void main(String[] args) {
        //referencia todos os personagens primeiro, iniciando eles
        Guerreiro guerreiro = new Guerreiro("Leonardo, o Guerreiro");
        Arqueiro arqueiro = new Arqueiro("Silvinho, a Arqueira");
        Mago mago = new Mago("Giovanna o Mago");
        Paladino paladino = new Paladino("Gustavinho, o Paladino");

        //inicia as armas que vao ser utilizadas
        EspadaLonga espada = new EspadaLonga();
        MachadoGuerra machado = new MachadoGuerra();

        guerreiro.equipar(espada);
        paladino.equipar(machado);

        List<Personagem> timeA = Arrays.asList(guerreiro, arqueiro);
        List<Personagem> timeB = Arrays.asList(mago, paladino);

        //nova batalha
        Batalha batalha = new Batalha(new ArrayList<>(timeA), new ArrayList<>(timeB));
        batalha.iniciar();
    }
}