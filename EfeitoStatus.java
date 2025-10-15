abstract class EfeitoStatus {
    protected TipoEfeito tipo;
    protected int turnosRestantes;

    public EfeitoStatus(TipoEfeito tipo, int turnos) {
        this.tipo = tipo;
        this.turnosRestantes = turnos;
    }

    public TipoEfeito getTipo() { return tipo; }
    public int getTurnosRestantes() { return turnosRestantes; }

    public void processar(Personagem alvo) {
        if (turnosRestantes > 0) {
            aplicarPorTurno(alvo);
            turnosRestantes--;
        }
    }

    protected abstract void aplicarPorTurno(Personagem alvo);
    public boolean expirou() { return turnosRestantes <= 0; }
}