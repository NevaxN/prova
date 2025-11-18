public class PainelControle implements Observador {
    @Override
    public void atualizar(DadosSensor dados) {
        System.out.println("   [Painel de Controle] 🖥️: Atualizando visualização em tempo real.");
        System.out.printf("     -> Temperatura exibida: %.1f°C\n", dados.getTemperatura());
    }
}