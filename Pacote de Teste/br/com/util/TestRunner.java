package br.com.util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Pacote de Teste/br/com/feature/", tags = "@cadastrar_professor",
        glue = "classpath:br.com.step.professor", monochrome = false, dryRun = false)
public class TestRunner {
}