class VerificacaoVelocidade extends VerificacaoFraude {
    @Override
    protected boolean verificar(Transacao transacao) {
        System.out.println("   -> [Verificação Velocidade] Analisando tempo desde a última compra...");
        System.out.println("      ❌ FALHA: Transação muito rápida (Velocidade de ataque)");
        return false;
    }
}