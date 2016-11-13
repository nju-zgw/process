package com.springapp.mvc.service.serviceImpl;

import com.springapp.mvc.bean.Project;
import com.springapp.mvc.bean.RiskItem;
import com.springapp.mvc.bean.User;
import com.springapp.mvc.bean.vo.RiskItemVO;
import com.springapp.mvc.dao.ProjectDao;
import com.springapp.mvc.dao.RiskItemDao;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WH on 2016/11/9.
 */
@Service("riskService")
public class RiskServiceImpl implements RiskService {
    @Autowired
    RiskItemDao riskItemDao;
    @Autowired
    UserDao userDao;

    @Autowired
    ProjectDao projectDao;

    //各项最大值级别设定为常量
    final static int MAX_RISK_TYPE_ID = 5;
    final static int MAX_RISK_PROB = 3;
    final static int MAX_RISK_AFFECT = 3;
    /**
     *
     * @param vo
     * @return
     * 插入新的RiskItem
     */
    @Override
    public RiskItemVO addRiskItem(RiskItemVO vo) {

        User creater = null;
        if(vo.getProjectId() < 0) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("Project ID 小于 0");
        }
        if(vo.getCreaterName() == null || vo.getCreaterName().length() == 0) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("creater name 不合法");
        }else {
            //get creater
           creater = userDao.getUserByName(vo.getCreaterName());
            if(creater == null){
                vo.setOperateSuccess(false);
                vo.setOperateInfo("creater 不存在");
            }
        }
        if(vo.getRiskTypeId() < 0 || vo.getRiskTypeId() > MAX_RISK_TYPE_ID) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("Risk Type ID不合法");
        }
        if(vo.getDescript() == null) {
            vo.setDescript("暂无");

        }
        if(vo.getRiskProb() < 0 || vo.getRiskProb() > MAX_RISK_PROB) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("Risk Prob 数值不合法");
        }
        if(vo.getRiskAffect() < 0 || vo.getRiskAffect() > MAX_RISK_AFFECT) {
            vo.setOperateSuccess(false);
            vo.setOperateInfo("Risk Affect 数值不合法");
        }
        if(vo.isOperateSuccess() == false) {
            return vo;
        }
        System.out.println("调用riskItemDao...");
        RiskItem itemToInsert = new RiskItem();

        itemToInsert.setProjectId(vo.getProjectId());
        itemToInsert.setCreaterId(creater.getId());
        itemToInsert.setDescript(vo.getDescript());
        itemToInsert.setTypeId(vo.getRiskTypeId());
        itemToInsert.setProb(vo.getRiskProb());
        itemToInsert.setAffect(vo.getRiskAffect());
        itemToInsert.setRiskName(vo.getRiskName());

        riskItemDao.insert(itemToInsert);

        int key = itemToInsert.getRid();
        if( key > 0) {
            //更新了对象的主键字段，因此说明插入成功
            vo.setRiskItemId(key);
            vo.setOperateSuccess(true);
            vo.setOperateInfo("创建新RiskItem成功!");
        }
        return vo;
    }

    /**
     *
     * @param username
     * @return 返回一个List的集合，第一个List是全部有关项目的风险，第2个List是创建的风险，第3个List是接受并处理的风险
     */
    @Override
    public List<List<RiskItemVO>> getRisks(String username) {
        List<List<RiskItemVO>> results = new ArrayList<>();
        User user = userDao.getUserByName(username);
        if(user == null)
            return results;
        int userId = user.getId();
        List<RiskItem> itemList = riskItemDao.getRisks(userId);
        List<RiskItem> createItemList = riskItemDao.getRisksCreated(userId);
        List<RiskItem> acceptItemList = riskItemDao.getRisksAccepted(userId);

        results.add(transform(itemList));
        results.add(transform(createItemList));
        results.add(transform(acceptItemList));
        return results;
    }

    @Override
    public List<List<RiskItemVO>> getRisksForAdmin(String name) {

        List<List<RiskItemVO>> results = new ArrayList<>();
        User user = userDao.getUserByName(name);
        if(user == null)
            return results;
        int userId = user.getId();
        List<RiskItem> itemList = riskItemDao.getAllRisks();
        List<RiskItem> createItemList = riskItemDao.getRisksCreated(userId);
        List<RiskItem> acceptItemList = riskItemDao.getRisksAccepted(userId);

        results.add(transform(itemList));
        results.add(transform(createItemList));
        results.add(transform(acceptItemList));
        return results;
    }


    private List<RiskItemVO> transform (List<RiskItem> itemList) {
        List<RiskItemVO> results = new ArrayList<>();
        for(RiskItem item : itemList) {
            RiskItemVO vo = new RiskItemVO();
            vo.setRiskItemId(item.getRid());
            vo.setProjectId(item.getProjectId());
            vo.setCreaterId(item.getCreaterId());
            vo.setRiskTypeId(item.getTypeId());
            vo.setDescript(item.getDescript());
            vo.setRiskProb(item.getProb());
            vo.setRiskAffect(item.getAffect());
            results.add(vo);
        }
        return results;
    }
    @Override
    public String getRiskName(int riskId) {
        RiskItem risk = riskItemDao.getRisk(riskId);
        if(risk != null){
            Project p = null;
            try {
                p = projectDao.findProject(risk.getProjectId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return p.getName();
        }
        return "这是这个系统的风险。。";
    }

    @Override
    public RiskItem getRisk(int riskId) {
        RiskItem risk = riskItemDao.getRisk(riskId);
        return risk;
    }

}
