package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions()
public class Runner {

    //hooks cucumber

    @Before
    public  void before(){
        System.out.println("BEFORE CUCUMBER");
    }

    @After
    public  void after(){
        System.out.println("AFTER CUCUMBER");
    }

}
