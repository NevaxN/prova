public class DemonstracaoObserver {
    public static void main(String[] args) {
        System.out.println("### Demonstração do Padrão Observer (Monitoramento Ambiental) ###");

        Sensor sensorRegiaoA = new Sensor();

        Observador painel = new PainelControle();
        Observador alertas = new ModuloAlertas();
        Observador registro = new ModuloRegistroHistorico();

        System.out.println("\n--- FASE DE INSCRIÇÃO DOS MÓDULOS ---");
        sensorRegiaoA.inscrever(painel);
        sensorRegiaoA.inscrever(alertas);
        sensorRegiaoA.inscrever(registro);

        System.out.println("\n--- ATUALIZAÇÃO 1: DADOS NORMAIS (Inicia o Processo de Notificação) ---");

        sensorRegiaoA.setDados(25.5, 60.0, 35.0);

        System.out.println("\n--- ATUALIZAÇÃO 2: DADOS CRÍTICOS (Dispara o Alerta) ---");
        sensorRegiaoA.setDados(30.1, 75.0, 88.5);
        
        System.out.println("\n--- FASE DE EXTENSÃO: ADICIONANDO NOVO MÓDULO ---");
        
        sensorRegiaoA.desinscrever(alertas);
        
        Observador moduloBackup = new Observador() {
            @Override
            public void atualizar(DadosSensor dados) {
                if (dados.getTemperatura() > 28.0) {
                    System.out.println("   [Módulo de Backup] ☁️: Dados de emergência (Temperatura Alta) enviados para a Nuvem de Backup.");
                }
            }
        };
        
        sensorRegiaoA.inscrever(moduloBackup);
        
        System.out.println("\n--- ATUALIZAÇÃO 3: NOVO MÓDULO ATIVO ---");
        sensorRegiaoA.setDados(29.0, 50.0, 40.0);
        
        System.out.println("\n*** Extensão Concluída com Sucesso! ***");
        System.out.println("O código do Sensor.java não precisou ser alterado para adicionar ou remover módulos.");
    }
}