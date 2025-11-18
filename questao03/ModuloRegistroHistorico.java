public class ModuloRegistroHistorico implements Observador {
    private int contadorRegistros = 0;

    @Override
    public void atualizar(DadosSensor dados) {
        contadorRegistros++;
        System.out.println("   [Registro Histórico] 💾: Salvando registro # " + contadorRegistros + " no banco de dados.");
        System.out.println("     -> Dados registrados: " + dados.toString());
    }
}