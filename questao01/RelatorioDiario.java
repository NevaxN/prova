public class RelatorioDiario implements Relatorio {
    @Override
    public void preparar() {
        System.out.println("✅ Preparando Relatório Diário:");
        System.out.println("   - Fontes de Dados: Sistema de Rastreamento em Tempo Real.");
        System.out.println("   - Priorização: Número de entregas efetuadas, OTD (On-Time Delivery).");
        System.out.println("   - Regras: Validação de todas as rotas concluídas.");
    }

    @Override
    public String getFormato() {
        return "PDF (Compacto)";
    }
}