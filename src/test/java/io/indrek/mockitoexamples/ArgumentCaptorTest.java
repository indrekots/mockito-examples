package io.indrek.mockitoexamples;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArgumentCaptorTest {

    private ApplicantQueue queue;

    @Before
    public void setUp() {
        queue = mock(ApplicantQueue.class);
    }

    @Test
    public void testPush() throws Exception {
        Application application = new Application("Mario");
        ArgumentCaptor<Application> captor = forClass(Application.class);
        queue.push(application);
        verify(queue).push(captor.capture());
        assertEquals("Mario", captor.getValue().getApplicantName());
    }
}
