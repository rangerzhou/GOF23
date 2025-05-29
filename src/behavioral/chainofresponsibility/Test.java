package behavioral.chainofresponsibility;

public class Test {
    public static void main(String[] args) {
        Approver teamLeader = new TeamLeader("唐僧");
        Approver manager = new Manager("如来佛祖");
        Approver director = new Director("玉帝");

        teamLeader.setNextApprover(manager);
        manager.setNextApprover(director);

        LeaveRequest request1 = new LeaveRequest("孙悟空", 3, "和白骨精约会");
        teamLeader.processRequest(request1);
        System.out.println("------------------------------------------------------------");

        LeaveRequest request2 = new LeaveRequest("猪八戒", 7, "和嫦娥约会");
        teamLeader.processRequest(request2);
        System.out.println("------------------------------------------------------------");

        LeaveRequest request3 = new LeaveRequest("沙僧", 10, "去找大师兄和二师兄");
        teamLeader.processRequest(request3);
        System.out.println("------------------------------------------------------------");
    }
}
