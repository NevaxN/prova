
public class DemonstracaoStrategy {
    public static void main(String[] args) {
        System.out.println("### Demonstração do Padrão Strategy ###");

        AnalisadorDeInvestimento analisador = new AnalisadorDeInvestimento(new ModeradoStrategy());
        double scoreBaseCliente1 = 65.0;
        
        analisador.analisarRisco("Alice - Perfil Padrão", scoreBaseCliente1);

        ModeloCalculoRisco novoModelo = new AgressivoStrategy();
        analisador.setModeloCalculo(novoModelo);

        double scoreBaseCliente2 = 65.0; // Mesmo score base de Alice
        analisador.analisarRisco("Bob - Perfil Agressivo", scoreBaseCliente2);

        analisador.setModeloCalculo(new SuperConservadorStrategy());
        
        double scoreBaseCliente3 = 65.0; 
        analisador.analisarRisco("Carlos - Perfil Super Conservador", scoreBaseCliente3);
        
        System.out.println("\n*** Extensão Concluída com Sucesso! ***");
        System.out.println("O fluxo principal (AnalisadorDeInvestimento.analisarRisco) não foi modificado em nenhum momento.");
    }
}