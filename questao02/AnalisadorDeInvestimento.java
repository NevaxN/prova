public class AnalisadorDeInvestimento {
    
    private ModeloCalculoRisco modeloAtual;

    public AnalisadorDeInvestimento(ModeloCalculoRisco modeloInicial) {
        this.modeloAtual = modeloInicial;
    }

    public void setModeloCalculo(ModeloCalculoRisco novoModelo) {
        System.out.println("\n*** Modelo de cálculo alterado para: " + novoModelo.getNomeModelo() + " ***");
        this.modeloAtual = novoModelo;
    }

    public void analisarRisco(String nomeCliente, double scoreBase) {
        System.out.println("--------------------------------------------------");
        System.out.println("Análise de Risco para Cliente: " + nomeCliente);
        System.out.println("   - Modelo utilizado: " + modeloAtual.getNomeModelo());

        double scoreRisco = modeloAtual.calcularRisco(scoreBase);

        System.out.printf("   - Score Base do Cliente: %.2f\n", scoreBase);
        System.out.printf("   - Perfil de Risco Calculado (Score Final): %.2f\n", scoreRisco);

        if (scoreRisco >= 70) {
            System.out.println("   - Recomendações: Alto Risco, foco em ativos de crescimento.");
        } else if (scoreRisco >= 40) {
            System.out.println("   - Recomendações: Risco Médio, equilíbrio entre renda fixa e variável.");
        } else {
            System.out.println("   - Recomendações: Baixo Risco, foco em ativos de preservação de capital.");
        }
        System.out.println("--------------------------------------------------");
    }
}