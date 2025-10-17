//importando o necessário
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//
class Batalha {
    private List<Personagem> timeA;
    private List<Personagem> timeB;
    private Random rng = new Random();
    public Batalha(List<Personagem> a, List<Personagem> b) {
        timeA = new ArrayList<>(a);
        timeB = new ArrayList<>(b);
    }

    public void iniciar() {
        System.out.println("NOVA BATALHA");
        int rodada = 1;
        while (temVivos(timeA) && temVivos(timeB)) {
            System.out.printf("\n--- Rodada %d ---\n", rodada++);
            turnoTime(timeA, timeB);
            turnoTime(timeB, timeA);
            for (Personagem p : juntar(timeA, timeB))
                if (p.estaVivo()) p.regenerarFinalTurno();
        }
        if (temVivos(timeA)) System.out.println("Time A venceu!");
        else System.out.println("Time B venceu!");
    }

    private void turnoTime(List<Personagem> atuantes, List<Personagem> inimigos) {
        for (Personagem p : new ArrayList<>(atuantes)) {
            if (!p.estaVivo()) continue;
            p.processarEfeitosInicioTurno();
            if (!p.estaVivo()) continue;
            if (p.estaAtordoado()) {
                System.out.printf("%s está atordoado e perde o turno\n", p.getNome());
                continue;
            }

            List<Personagem> vivos = vivos(inimigos);
            if (vivos.isEmpty()) return;
            Personagem alvo = vivos.get(0);

            System.out.printf("%s ataca com %s\n", p.getNome(), p.armaEquipada != null ? p.armaEquipada.getNome() : "Punhos");
            p.atacar(Collections.singletonList(alvo), this);

            removerMortos(timeA);
            removerMortos(timeB);
            if (!temVivos(timeA) || !temVivos(timeB)) return;
        }
    }

    private boolean temVivos(List<Personagem> lista) {
        return lista.stream().anyMatch(Personagem::estaVivo);
    }

    private List<Personagem> vivos(List<Personagem> lista) {
        List<Personagem> res = new ArrayList<>();
        for (Personagem p : lista) if (p.estaVivo()) res.add(p);
        return res;
    }

    private void removerMortos(List<Personagem> lista) {
        lista.removeIf(p -> !p.estaVivo());
    }

    private List<Personagem> juntar(List<Personagem> a, List<Personagem> b) {
        List<Personagem> res = new ArrayList<>();
        res.addAll(a); res.addAll(b);
        return res;
    }
}