class Sangramento extends EfeitoStatus {
    private int danoPorTurno;

    public Sangramento(int dano, int turnos) {
        super(TipoEfeito.SANGRAMENTO, turnos);
        this.danoPorTurno = dano;
    }

    @Override
    protected void aplicarPorTurno(Personagem alvo) {
        alvo.receberDanoBruto(danoPorTurno);
        System.out.printf("%s sofre %d de sangramento (restam %d turnos)\n", alvo.getNome(), danoPorTurno, turnosRestantes-1);
    }
}