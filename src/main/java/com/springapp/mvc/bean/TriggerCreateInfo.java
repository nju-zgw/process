package com.springapp.mvc.bean;

/**
 * Created by WH on 2016/11/10.
 */

/**
 * 创建risk的时候创建trigger的数据载体
 */
public class TriggerCreateInfo {
    int triggerType;//触发器类别
    int valueType;//阈值符号
    int value; //阈值数量
    int eventType; //事件类型
    int riskItemId;//风险条目id

    public TriggerCreateInfo(int triggerType, int valueType, int value, int eventType) {
        this.triggerType = triggerType;
        this.valueType = valueType;
        this.value = value;
        this.eventType = eventType;
    }

    public TriggerCreateInfo() {
    }

    public int getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(int triggerType) {
        this.triggerType = triggerType;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getRiskItemId() {
        return riskItemId;
    }

    public void setRiskItemId(int riskItemId) {
        this.riskItemId = riskItemId;
    }

    @Override
    public String toString() {
        return "TriggerCreateInfo{" +
                "triggerType=" + triggerType +
                ", valueType=" + valueType +
                ", value=" + value +
                ", eventType=" + eventType +
                '}';
    }
}

