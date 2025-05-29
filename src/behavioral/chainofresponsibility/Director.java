package behavioral.chainofresponsibility;

public class Director extends Approver {
    public Director(String approverName) {
        super(approverName);
    }

    @Override
    public void processRequest(LeaveRequest request) {
        if (request.getLeaveDays() > 7) {
            System.out.println(approverName + "审批通过: " + request);
        }
    }
}
