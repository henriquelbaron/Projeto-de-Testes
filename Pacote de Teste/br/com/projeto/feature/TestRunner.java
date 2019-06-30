package br.com.projeto.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Pacote de Teste/br/com/projeto/feature/", tags = "@suporte_tecnico",
        glue = "classpath:br.com.projeto.step.suportetecnico", monochrome = false, dryRun = false)
public class TestRunner {
}
