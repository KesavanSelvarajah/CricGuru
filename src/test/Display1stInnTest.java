package test;

import cgone.display.Display1stInn;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class Display1stInnTest {
    @Test
    public void shouldPerform(){
        Display1stInn ts = mock(Display1stInn.class);
        ts.perform("select * from matches","select * from matches");
    }
}
