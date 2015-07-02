package io.indrek.mockitoexamples;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThenAnswerTest {

    private ApplicantQueue applicantQueue;
    private ApplicationService appService;

    @Before
    public void setUp() {
        applicantQueue = mock(ApplicantQueue.class);
        appService = new ApplicationService(applicantQueue);
    }

    @Test
    public void testThenAnswer() throws Exception {
        when(appService.processNextApplicant()).thenAnswer(new Answer<Application>() {
            private int counter;
            private String[] names = new String[] {"Mario", "Luigi", "Bowser"};

            @Override
            public Application answer(InvocationOnMock invocationOnMock) throws Throwable {
                return new Application(names[counter++]);
            }
        });

        assertEquals("Mario", appService.processNextApplicant().getApplicantName());
    }
}
