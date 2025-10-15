class Queimadura extends EfeitoStatus {
    private int danoPorTurno;

    public Queimadura(int dano, int turnos) {
        super(TipoEfeito.QUEIMADURA, turnos);
        this.danoPorTurno = dano;
    }

    @Override
    protected void aplicarPorTurno(Personagem alvo) {
        alvo.receberDanoBruto(danoPorTurno);
        System.out.printf("%s sofre %d de queimadura (restam %d turnos)\n", alvo.getNome(), danoPorTurno, turnosRestantes-1);
    }
}