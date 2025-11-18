public class VerificacaoHistorico extends VerificacaoFraude {
    @Override
    protected boolean verificar(Transacao transacao) {
        System.out.println("   -> [Verificação Histórico] Analisando histórico limpo: " + transacao.isHistoricoLimpo());
        if (!transacao.isHistoricoLimpo()) {
            System.out.println("      ❌ FALHA: Histórico de fraudes prévias.");
            return false;
        }
        return true;
    }
}