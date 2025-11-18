public class ModuloAlertas implements Observador {
    @Override
    public void atualizar(DadosSensor dados) {
        System.out.println("   [Módulo de Alertas] 🚨: Verificando condições críticas...");
        if (dados.getPoluicao() > 50.0) {
            System.out.println("     -> ALERTA CRÍTICO: Índice de Poluição Elevado (%.1f)!\n", dados.getPoluicao());
        } else {
            System.out.println("     -> Nenhuma anomalia detectada.");
        }
    }
}