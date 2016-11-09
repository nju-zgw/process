package com.springapp.mvc.service;

import com.springapp.mvc.bean.vo.RiskItemVO;

import java.util.List;

/**
 * Created by WH on 2016/11/9.
 */
public interface RiskService {
    public RiskItemVO addRiskItem(RiskItemVO vo);
    public List<RiskItemVO> getRisks(String username);
}
