package io.indrek.mockitoexamples;

public class Application {
    private String applicantName;

    public Application(String name) {
        this.applicantName = name;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
}
