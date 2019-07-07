package test;

import cgone.display.Display1stInn;
import cgone.display.DisplayOverView;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class DisplayOverViewTest {
    @Test
    public void shouldPerform(){
        DisplayOverView ts = mock(DisplayOverView.class);
        ts.perform("select * from matches");
    }

}
