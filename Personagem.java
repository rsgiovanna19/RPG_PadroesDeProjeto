import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

abstract class Personagem {
    protected String nome;
    protected int vidaMaxima;
    protected int vida;
    protected int manaMaxima;
    protected int mana;
    protected int forca, destreza, inteligencia;
    protected Arma armaEquipada;
    protected List<EfeitoStatus> efeitos = new ArrayList<>();
    protected Random rng = new Random();

    public Personagem(String nome, int vida, int mana, int forca, int destreza, int inteligencia) {
        this.nome = nome;
        this.vidaMaxima = vida; this.vida = vida;
        this.manaMaxima = mana; this.mana = mana;
        this.forca = forca; this.destreza = destreza; this.inteligencia = inteligencia;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public boolean estaVivo() { return vida > 0; }

    public void equipar(Arma arma) {
        if (arma.podeUsar(this)) {
            this.armaEquipada = arma;
            System.out.printf("%s equipou %s\n", nome, arma.getNome());
        } else {
            System.out.printf("%s não pode usar %s\n", nome, arma.getNome());
        }
    }

    public void aplicarEfeito(EfeitoStatus e) {
        efeitos.add(e);
        System.out.printf("%s recebeu efeito %s por %d turnos\n", nome, e.getTipo(), e.getTurnosRestantes());
    }

    public boolean estaAtordoado() {
        for (EfeitoStatus e : efeitos)
            if (e.getTipo() == TipoEfeito.ATORDOAMENTO && e.getTurnosRestantes() > 0)
                return true;
        return false;
    }

    public void processarEfeitosInicioTurno() {
        Iterator<EfeitoStatus> it = efeitos.iterator();
        while (it.hasNext()) {
            EfeitoStatus e = it.next();
            e.processar(this);
            if (e.expirou()) it.remove();
        }
    }

    public void regenerarFinalTurno() {}

    public void receberDanoBruto(int dano) {
        int antes = vida;
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.printf("%s recebeu %d de dano (HP %d -> %d)\n", nome, dano, antes, vida);
    }

    public void receberDano(int dano) {
        int real = aplicarReducaoDano(dano);
        receberDanoBruto(real);
    }

    protected int aplicarReducaoDano(int dano) {
        return dano;
    }

    public void atacar(List<Personagem> alvos, Batalha batalha) {
        if (armaEquipada == null) {
            System.out.printf("%s não tem arma equipada e golpeia com as mãos (1 de dano)\n", nome);
            for (Personagem t : alvos) t.receberDano(1);
            return;
        }
        if (mana < armaEquipada.getCustoMana()) {
            System.out.printf("%s não tem mana suficiente para usar %s. Ataque básico!\n", nome, armaEquipada.getNome());
            for (Personagem t : alvos) t.receberDano(armaEquipada.getDanoBase());
            return;
        }
        armaEquipada.atacar(this, alvos, batalha);
    }

    public boolean ehCritico() {
        return rng.nextDouble() < 0.10;
    }

    public int calcularDanoComAtributos(int danoBase) {
        int bonus = 0;
        if (armaEquipada instanceof ArmaCorpoACorpo) bonus = (int)Math.round(forca * 0.5);
        else if (armaEquipada instanceof ArmaDistancia) bonus = (int)Math.round(destreza * 0.4);
        else bonus = (int)Math.round(inteligencia * 0.6);

        int base = danoBase + bonus;
        boolean crit = ehCritico();
        if (crit) {
            int multCrit = 150 + rng.nextInt(101);
            int danoCrit = base * multCrit / 100;
            System.out.printf("CRÍTICO! %s causa %d%% do dano base -> %d\n", nome, multCrit, danoCrit);
            return danoCrit;
        }
        return base;
    }
}
