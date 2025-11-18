public abstract class CriadorRelatorio {

    protected abstract Relatorio criarRelatorio();

    public void emitirRelatorio() {
        Relatorio relatorio = criarRelatorio();

        System.out.println("\n--------------------------------------------------");
        System.out.println("Sistema Core: Iniciando emissão de um novo relatório...");

        relatorio.preparar();

        System.out.println("   - Formato Final: " + relatorio.getFormato());
        System.out.println("Sistema Core: Relatório concluído e armazenado.");
        System.out.println("--------------------------------------------------");
    }
}