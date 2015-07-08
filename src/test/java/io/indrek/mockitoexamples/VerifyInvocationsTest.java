package io.indrek.mockitoexamples;

import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class VerifyInvocationsTest {

    @SuppressWarnings("unchecked")
    @Test
    public void testInvocations() throws Exception {
        List<String> mock = (List<String>) mock(List.class);
        mock.add("first element");
        mock.add("second element");
        verify(mock, times(2)).add(anyString());
        verify(mock, never()).add("third element");
    }
}
