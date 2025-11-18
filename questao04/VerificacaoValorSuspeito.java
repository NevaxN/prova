public class VerificacaoValorSuspeito extends VerificacaoFraude {
    @Override
    protected boolean verificar(Transacao transacao) {
        System.out.println("   -> [Verificação Valor Suspeito] Analisando valor: R$" + transacao.getValor());
        if (transacao.getValor() > 5000.0) {
            System.out.println("      ❌ FALHA: Valor alto demais.");
            return false;
        }
        return true;
    }
}