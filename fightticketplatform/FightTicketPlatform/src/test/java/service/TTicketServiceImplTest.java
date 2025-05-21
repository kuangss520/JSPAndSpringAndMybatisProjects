package service;

import model.TTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * TTicketServiceImpl 测试类
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TTicketServiceImplTest {

    @Autowired
    private TTicketService tTicketService;

    @Test
    public void orderTicket() {
        System.out.println("--- 测试 orderTicket (TTicketService) ---");
        TTicket ticket = new TTicket();
        // TODO: 填充订票信息，确保 flightId 和 idCard 存在

        ticket.setFlightId(1);
        ticket.setIdCard("existing_id_card");
        ticket.setSeatNumber("A1");
        ticket.setStatus("booked");

        int result = tTicketService.orderTicket(ticket);
        System.out.println("订票结果 (影响行数): " + result);
    }

    @Test
    public void modifyTicket() {
        System.out.println("--- 测试 modifyTicket (TTicketService) ---");
        TTicket ticket = new TTicket();
        // TODO: 使用一个存在的机票ID进行更新测试
        Integer ticketIdToUpdate = 1;
        System.out.println("尝试修改机票ID: " + ticketIdToUpdate);
        ticket.setTicketId(ticketIdToUpdate);
        // TODO: 填充需要更新的字段
        ticket.setSeatNumber("B2"); // 更新座位号
        ticket.setStatus("paid"); // 更新状态

        boolean result = tTicketService.modifyTicket(ticket);
        System.out.println("修改机票结果 (true表示成功): " + result);
    }

    @Test
    public void cancelTicket() {
        System.out.println("--- 测试 cancelTicket (TTicketService) ---");
        // TODO: 替换为实际存在的机票ID进行删除测试
        // 如果你想测试取消机票，可以先orderTicket一个新机票，然后cancelTicket它。
        Integer ticketIdToDelete = 2;
        System.out.println("尝试取消机票ID: " + ticketIdToDelete);

        boolean result = tTicketService.cancelTicket(ticketIdToDelete);
        System.out.println("取消机票结果 (true表示成功): " + result);
    }

    @Test
    public void getTicketsByFlightId() {
        System.out.println("--- 测试 getTicketsByFlightId (TTicketService) ---");
        // TODO: 使用一个存在的航班ID进行查询测试
        Integer flightIdToFind = 1; // 示例航班ID
        System.out.println("尝试根据航班ID查询机票: " + flightIdToFind);

        List<TTicket> tickets = tTicketService.getTicketsByFlightId(flightIdToFind);
        System.out.println("查询结果列表: " + tickets);
        System.out.println("找到 " + (tickets != null ? tickets.size() : 0) + " 条记录.");
    }

    @Test
    public void getTicketsByPassengerId() {
        System.out.println("--- 测试 getTicketsByPassengerId (TTicketService) ---");
        // TODO: 使用一个存在的乘客身份证号进行查询测试
        String idCardToFind = "existing_id_card"; // 示例身份证号
        System.out.println("尝试根据乘客身份证号查询机票: " + idCardToFind);

        List<TTicket> tickets = tTicketService.getTicketsByPassengerId(idCardToFind);
        System.out.println("查询结果列表: " + tickets);
        System.out.println("找到 " + (tickets != null ? tickets.size() : 0) + " 条记录.");
    }

    @Test
    public void getTicketById() {
        System.out.println("--- 测试 getTicketById (TTicketService) ---");
        // TODO: 使用一个存在的机票ID进行查询测试
        Integer ticketIdToSelect = 1; // 示例ID，请根据你的数据库实际情况修改
        System.out.println("查询机票ID: " + ticketIdToSelect);

        TTicket ticket = tTicketService.getTicketById(ticketIdToSelect);
        System.out.println("查询结果: " + ticket);
    }
}