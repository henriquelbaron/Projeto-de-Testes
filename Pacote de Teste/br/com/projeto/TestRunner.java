package br.com.projeto;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Pacote de Teste/br/com/projeto/feature/", tags = "@excluir_professor",
        glue = "classpath:br.com.projeto.step.professor", monochrome = false, dryRun = false)
public class TestRunner {
}
