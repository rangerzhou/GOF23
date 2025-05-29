package behavioral.chainofresponsibility;

public class TeamLeader extends Approver {
    public TeamLeader(String approverName) {
        super(approverName);
    }

    @Override
    public void processRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= 3) {
            System.out.println(approverName + " 审批通过: " + request);
        } else if (nextApprover != null) {
            System.out.println(approverName + " 无法处理超过 3 天的请假，转给 " + nextApprover.approverName + " 处理");
            nextApprover.processRequest(request);
        } else {
            System.out.println("链中无人可处理该请假申请: " + request);
        }
    }
}
