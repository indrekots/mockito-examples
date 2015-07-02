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
        when(applicantQueue.getNextApplicant()).thenAnswer(new Answer<Applicant>() {
            private int counter;
            private String[] names = new String[] {"Mario", "Luigi", "Bowser"};

            @Override
            public Applicant answer(InvocationOnMock invocationOnMock) throws Throwable {
                return new Applicant(names[counter++]);
            }
        });

        assertEquals("Mario", appService.processNextApplicant().getApplicantName());
        assertEquals("Luigi", appService.processNextApplicant().getApplicantName());
        assertEquals("Bowser", appService.processNextApplicant().getApplicantName());
    }
}
