package behavioral.chainofresponsibility;

public class LeaveRequest {
    private final String applicantName;
    private final int leaveDays;
    private final String reason;

    public LeaveRequest(String applicantName, int leaveDays, String reason) {
        this.applicantName = applicantName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "applicantName='" + applicantName + '\'' +
                ", leaveDays=" + leaveDays +
                ", reason='" + reason + '\'' +
                '}';
    }
}
