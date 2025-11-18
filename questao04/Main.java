public class DemonstracaoChain {
    public static void main(String[] args) {
        System.out.println("### Demonstração do Padrão Chain of Responsibility ###");
        
        VerificacaoFraude verificadorValor = new VerificacaoValorSuspeito();
        VerificacaoFraude verificadorGeo = new VerificacaoGeoLocalizacao();
        VerificacaoFraude verificadorHistorico = new VerificacaoHistorico();
        VerificacaoFraude verificadorDispositivo = new VerificacaoDispositivo();
        
        verificadorValor.setProximo(verificadorGeo)
                        .setProximo(verificadorHistorico)
                        .setProximo(verificadorDispositivo);
        
        VerificacaoFraude inicioCadeia = verificadorValor;

        Transacao t1 = new Transacao("T001", 350.00, "BR", true, "Mobile-iOS");
        System.out.println("\n--- Processando Transação " + t1.getId() + " (Esperado: APROVADA) ---");
        inicioCadeia.processar(t1);
        exibirResultado(t1);

        Transacao t2 = new Transacao("T002", 7500.00, "BR", true, "Desktop");
        System.out.println("\n--- Processando Transação " + t2.getId() + " (Esperado: FALHA em Valor) ---");
        inicioCadeia.processar(t2); // A cadeia para aqui
        exibirResultado(t2);
        
        Transacao t3 = new Transacao("T003", 200.00, "RU", true, "Mobile-Android");
        System.out.println("\n--- Processando Transação " + t3.getId() + " (Esperado: FALHA em Geolocalização) ---");
        inicioCadeia.processar(t3); // A cadeia para aqui
        exibirResultado(t3);
        
        System.out.println("\n*** EXTENSIBILIDADE: Adicionando Verificação de Velocidade ***");
        

        
        VerificacaoFraude novoVerificadorVelocidade = new VerificacaoVelocidade();
        
        verificadorGeo.setProximo(verificadorHistorico); // Mantém a Geo ligada ao Histórico
        verificadorHistorico.setProximo(novoVerificadorVelocidade); // Histórico liga ao Novo
        novoVerificadorVelocidade.setProximo(verificadorDispositivo); // Novo liga ao Dispositivo
        
        Transacao t4 = new Transacao("T004", 50.00, "BR", true, "Mobile-iOS");
        System.out.println("\n--- Processando Transação " + t4.getId() + " (Esperado: FALHA em Velocidade) ---");
        inicioCadeia.processar(t4);
        exibirResultado(t4);
        
        System.out.println("\n*** Extensão Concluída com Sucesso! ***");
    }

    private static void exibirResultado(Transacao t) {
        System.out.println("   RESULTADO FINAL [" + t.getId() + "]:");
        if (t.isAprovada()) {
            System.out.println("      ✅ APROVADA.");
        } else {
            System.out.println("      🛑 REPROVADA. Motivo: " + t.getMotivoFalha());
        }
    }
}