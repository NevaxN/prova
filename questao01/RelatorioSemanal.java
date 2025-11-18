public class RelatorioSemanal implements Relatorio {
    @Override
    public void preparar() {
        System.out.println("✅ Preparando Relatório Semanal:");
        System.out.println("   - Fontes de Dados: Histórico do banco de dados (7 dias).");
        System.out.println("   - Priorização: Custos operacionais, eficiência de combustível, KPIs consolidados.");
        System.out.println("   - Regras: Análise de tendências de atrasos e gargalos.");
    }

    @Override
    public String getFormato() {
        return "Excel (Detalhado)";
    }
}