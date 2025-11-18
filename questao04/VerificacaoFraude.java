public abstract class VerificacaoFraude {
    private VerificacaoFraude proximoVerificador;

    public VerificacaoFraude setProximo(VerificacaoFraude proximo) {
        this.proximoVerificador = proximo;
        return proximo;
    }

    public void processar(Transacao transacao) {
        if (transacao.isAprovada()) {
            boolean sucesso = verificar(transacao);

            if (!sucesso) {
                transacao.setFalha("Falha na etapa: " + this.getClass().getSimpleName());
            } 
        }

        if (transacao.isAprovada() && proximoVerificador != null) {
            proximoVerificador.processar(transacao);
        }
    }

    protected abstract boolean verificar(Transacao transacao);
}