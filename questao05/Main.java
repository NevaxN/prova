public class DemonstracaoSingleton {
    public static void main(String[] args) {
        System.out.println("### Demonstração do Padrão Singleton Thread-Safe ###");
        
        System.out.println("\n--- TESTE 1: Acesso Simples ---");
        LoggerCorporativo logger1 = LoggerCorporativo.getInstancia();
        logger1.registrarEvento("Início da Aplicação.");

        System.out.println("\n--- TESTE 2: Segundo Acesso ---");
        LoggerCorporativo logger2 = LoggerCorporativo.getInstancia();
        logger2.registrarErro("Falha ao carregar configuração.");
        
        System.out.println("\n-> logger1 == logger2: " + (logger1 == logger2));

        System.out.println("\n--- TESTE 3: Acesso em Múltiplas Threads ---");
        
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];
        
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                LoggerCorporativo loggerThread = LoggerCorporativo.getInstancia();
                loggerThread.registrarLog("THREAD-" + threadId, "Tentativa de log da thread.");
            });
        }
        
        for (Thread t : threads) {
            t.start();
        }
        
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n*** Teste Concluído. ***");
        System.out.println("Verifique a saída: A mensagem 'INSTÂNCIA CRIADA' deve aparecer apenas uma vez.");
    }
}