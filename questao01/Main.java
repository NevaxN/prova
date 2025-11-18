public class Main {
    public static void main(String[] args) {
        System.out.println("### Demonstração do Padrão Factory Method ###");

        CriadorRelatorio criadorDiario = new CriadorRelatorioDiario();
        criadorDiario.emitirRelatorio(); // O sistema delega a criação à fábrica específica.

        CriadorRelatorio criadorSemanal = new CriadorRelatorioSemanal();
        criadorSemanal.emitirRelatorio(); // O sistema delega a criação à outra fábrica.


        System.out.println("\n*** SIMULANDO NOVA FUNCIONALIDADE (Relatório Emergencial) ***");

        class RelatorioEmergencial implements Relatorio {
            @Override
            public void preparar() {
                System.out.println("🚨 Preparando Relatório Emergencial:");
                System.out.println("   - Fontes de Dados: Alertas de telemetria (apenas últimas 3 horas).");
                System.out.println("   - Priorização: Incidentes críticos, desvios de rota, tempo de inatividade.");
                System.out.println("   - Regras: Notificação imediata dos supervisores.");
            }

            @Override
            public String getFormato() {
                return "JSON (Integração Rápida)";
            }
        }

        class CriadorRelatorioEmergencial extends CriadorRelatorio {
            @Override
            protected Relatorio criarRelatorio() {
                return new RelatorioEmergencial();
            }
        }

        CriadorRelatorio criadorEmergencial = new CriadorRelatorioEmergencial();
        criadorEmergencial.emitirRelatorio();
        
        System.out.println("\n*** Extensão Concluída com Sucesso! ***");
        System.out.println("O núcleo do sistema (CriadorRelatorio.emitirRelatorio) não foi modificado.");
    }
}