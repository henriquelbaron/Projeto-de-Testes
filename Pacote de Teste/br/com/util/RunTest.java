package br.com.util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Pacote de Teste/br/com/feature/Sala.feature",
        glue = "", tags = "@cadastrar_sala")
public class RunTest {

}
