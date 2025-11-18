public class VerificacaoGeoLocalizacao extends VerificacaoFraude {
    @Override
    protected boolean verificar(Transacao transacao) {
        System.out.println("   -> [Verificação Geolocalização] Analisando: " + transacao.getGeolocalizacao());
        if (transacao.getGeolocalizacao().equals("RU")) {
            System.out.println("      ❌ FALHA: Geolocalização de alto risco detectada.");
            return false;
        }
        return true;
    }
}