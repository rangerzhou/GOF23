package behavioral.chainofresponsibility;

public abstract class Approver {
    String approverName;
    Approver nextApprover;

    public Approver(String approverName) {
        this.approverName = approverName;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void processRequest(LeaveRequest request);

}
