class Atordoamento extends EfeitoStatus {
    public Atordoamento(int turnos) { super(TipoEfeito.ATORDOAMENTO, turnos); }

    @Override
    protected void aplicarPorTurno(Personagem alvo) {
        System.out.printf("%s está atordoado (restam %d turnos)\n", alvo.getNome(), turnosRestantes-1);
    }
}