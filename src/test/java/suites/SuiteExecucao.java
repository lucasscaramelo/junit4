package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import services.CalculadoraServiceTest;
import services.CalculoValorLocacaoTest;
import services.LocacaoServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ // testes que vão ser executados
        CalculadoraServiceTest.class,
        CalculoValorLocacaoTest.class,
        LocacaoServiceTest.class
})
public class SuiteExecucao {
    // Podemos introduzir before e after
}
