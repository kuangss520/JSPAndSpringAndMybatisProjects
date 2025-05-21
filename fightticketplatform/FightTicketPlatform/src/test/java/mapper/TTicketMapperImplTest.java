package mapper;

import model.TTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional // 开启事务
@Rollback(true) // 测试后回滚事务，不实际修改数据库
public class TTicketMapperImplTest {

    @Autowired
    private TTicketMapper ticketMapper;

    @Test
    public void testInsertSelective() {
        System.out.println("--- 测试 insertSelective ---");
        TTicket newTicket = new TTicket();
        newTicket.setFlightId(1);
        newTicket.setSeatNumber("C12");
        newTicket.setStatus("未售出");

        int result = ticketMapper.insertSelective(newTicket);
        System.out.println("插入结果 (影响行数): " + result);
        assertTrue("插入操作应该影响至少一行", result > 0);


    }

    @Test
    public void testDeleteByPrimaryKey() {
        System.out.println("--- 测试 deleteByPrimaryKey ---");
        // 使用一个存在的机票ID进行删除测试，根据初始数据修改
        Integer ticketIdToDelete = 3; // 例如：未售出的机票
        System.out.println("删除机票ID: " + ticketIdToDelete);

        // 先查询确保记录存在
        TTicket existingTicket = ticketMapper.selectByPrimaryKey(ticketIdToDelete);
        assertNotNull("待删除的机票记录应该存在", existingTicket);

        int result = ticketMapper.deleteByPrimaryKey(ticketIdToDelete);
        System.out.println("删除结果 (影响行数): " + result);
        assertTrue("删除操作应该影响一行", result > 0);

        // 再次查询确保记录已被删除
        TTicket deletedTicket = ticketMapper.selectByPrimaryKey(ticketIdToDelete);
        assertNull("机票记录应该已被删除", deletedTicket);
    }

    @Test
    public void testSelectByPrimaryKey() {
        System.out.println("--- 测试 selectByPrimaryKey ---");
        // 使用一个存在的机票ID进行查询测试，根据初始数据修改
        Integer ticketIdToSelect = 1;
        System.out.println("查询机票ID: " + ticketIdToSelect);
        TTicket ticket = ticketMapper.selectByPrimaryKey(ticketIdToSelect);
        System.out.println("查询结果: " + ticket);

        assertNotNull("查询结果不应为 null", ticket);
        assertEquals("查询到的机票ID应该与查询条件一致", ticketIdToSelect, ticket.getTicketId());
        // 可以根据初始数据进一步断言其他字段的值
        assertEquals("航班ID应该为1", Integer.valueOf(1), ticket.getFlightId());
        assertEquals("座位号应该为A1", "A1", ticket.getSeatNumber());
        assertEquals("身份证号码应该为110101199001011234", "110101199001011234", ticket.getIdCard());
        assertEquals("状态应该为已售出", "已售出", ticket.getStatus());
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        System.out.println("--- 测试 updateByPrimaryKeySelective ---");
        TTicket ticket = new TTicket();
        // 使用一个存在的机票ID进行更新测试，根据初始数据修改
        Integer ticketIdToUpdate = 2; // 例如：已售出的机票
        ticket.setTicketId(ticketIdToUpdate);
        ticket.setStatus("已退票"); // 修改状态

        // 先查询确保记录存在且状态是已售出
        TTicket existingTicket = ticketMapper.selectByPrimaryKey(ticketIdToUpdate);
        assertNotNull("待更新的机票记录应该存在", existingTicket);
        assertEquals("更新前的状态应该是已售出", "已售出", existingTicket.getStatus());


        int result = ticketMapper.updateByPrimaryKeySelective(ticket);
        System.out.println("更新结果 (影响行数): " + result);
        assertTrue("更新操作应该影响一行", result > 0);

        // 查询回来验证更新是否成功
        TTicket updatedTicket = ticketMapper.selectByPrimaryKey(ticketIdToUpdate);
        assertNotNull("更新后的机票记录应该存在", updatedTicket);
        assertEquals("更新后的状态应该是已退票", "已退票", updatedTicket.getStatus());
        // 验证其他字段未被改变 (insertSelective只更新非null字段，所以这里我们只验证被修改的字段)
        assertEquals("航班ID不应改变", existingTicket.getFlightId(), updatedTicket.getFlightId());
        assertEquals("座位号不应改变", existingTicket.getSeatNumber(), updatedTicket.getSeatNumber());
        assertEquals("身份证号码不应改变", existingTicket.getIdCard(), updatedTicket.getIdCard());
    }

    @Test
    public void testSelectBySelective() {
        System.out.println("--- 测试 selectBySelective ---");
        // 测试根据航班ID和状态查询未售出的机票
        TTicket query = new TTicket();
        query.setFlightId(1); // 航班ID为1
        query.setStatus("未售出"); // 未售出状态

        List<TTicket> ticketList = ticketMapper.selectSelective(query);
        System.out.println("查询结果列表大小: " + ticketList.size());

        assertNotNull("查询结果列表不应为 null", ticketList);
        assertTrue("查询结果列表应该包含至少一个未售出的机票", ticketList.size() > 0);

        // 验证查询结果中的机票是否符合条件
        for (TTicket ticket : ticketList) {
            assertEquals("查询到的机票航班ID应该为1", Integer.valueOf(1), ticket.getFlightId());
            assertEquals("查询到的机票状态应该为未售出", "未售出", ticket.getStatus());
        }
    }

    // 添加其他可能的查询方法的测试，例如根据身份证号码查询等
    @Test
    public void testSelectByPassengerIdCard() {
        System.out.println("--- 测试 selectByPassengerIdCard ---");
        // 使用一个存在的乘客身份证号码进行查询测试
        String passengerIdCardToSearch = "110101199001011234"; // 张三的身份证
        System.out.println("根据乘客身份证查询机票: " + passengerIdCardToSearch);

        TTicket query = new TTicket();
        query.setIdCard(passengerIdCardToSearch);

        List<TTicket> ticketList = ticketMapper.selectSelective(query);
        System.out.println("查询结果列表大小: " + ticketList.size());

        assertNotNull("查询结果列表不应为 null", ticketList);
        assertTrue("查询结果列表应该包含该乘客的机票", ticketList.size() > 0);

        // 验证查询结果中的机票是否属于该乘客
        for (TTicket ticket : ticketList) {
            assertEquals("查询到的机票身份证号码应该与查询条件一致", passengerIdCardToSearch, ticket.getIdCard());
        }
    }
}