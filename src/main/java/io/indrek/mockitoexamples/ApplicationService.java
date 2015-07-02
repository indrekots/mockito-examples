package io.indrek.mockitoexamples;

public class ApplicationService {

    private ApplicantQueue applicantQueue;

    public ApplicationService(ApplicantQueue applicantQueue) {
        this.applicantQueue = applicantQueue;
    }

    public Application processNextApplicant() {
        Applicant applicant = applicantQueue.getNextApplicant();
        return generateApplication(applicant);
    }

    private Application generateApplication(Applicant applicant) {
        return new Application(applicant.getName());
    }
}
