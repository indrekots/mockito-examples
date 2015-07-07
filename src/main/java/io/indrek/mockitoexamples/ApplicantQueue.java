package io.indrek.mockitoexamples;

public interface ApplicantQueue {
    Applicant getNextApplicant();

    void push(Application application);
}
