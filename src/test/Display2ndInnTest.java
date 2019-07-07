package test;

import cgone.display.Display2ndInn;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class Display2ndInnTest {

    @Test
    public void shouldPerform(){
        Display2ndInn ts = mock(Display2ndInn.class);
        ts.perform("select * from matches","select * from matches");
    }
}
