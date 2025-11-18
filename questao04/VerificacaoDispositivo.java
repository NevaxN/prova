public class VerificacaoDispositivo extends VerificacaoFraude {
    @Override
    protected boolean verificar(Transacao transacao) {
        System.out.println("   -> [Verificação Dispositivo] Analisando dispositivo: " + transacao.getDispositivoAtual());
        if (transacao.getDispositivoAtual().equals("Incomum") || transacao.getDispositivoAtual().equals("VPN")) {
            System.out.println("      ❌ FALHA: Dispositivo incomum ou suspeito.");
            return false;
        }
        return true;
    }
}