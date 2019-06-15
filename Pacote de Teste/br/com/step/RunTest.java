package br.com.step;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Pacote de Teste/br/com/feature/Login.feature",
        glue = "", tags = "@login_logout")
public class RunTest {

}
