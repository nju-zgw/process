import com.springapp.mvc.bean.RiskStatusItem;
import com.springapp.mvc.dao.RiskStatusDao;
import com.springapp.mvc.service.RiskItemStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by WH on 2016/11/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class RiskStatusItemTest {
    @Autowired
    RiskStatusDao riskStatusDao;
    @Autowired
    RiskItemStatusService riskItemStatusService;
    @Test
    public void testRiskStatusGet() {
        List<RiskStatusItem> itemList = riskStatusDao.getStatusByAcceptor(2);
        System.out.println(itemList);
    }

//    @Test
    public void testRiskStatusByTracer() {
        List<RiskStatusItem> items = riskItemStatusService.getStatusItems("wanghao");
        System.out.println(items);
    }
}
