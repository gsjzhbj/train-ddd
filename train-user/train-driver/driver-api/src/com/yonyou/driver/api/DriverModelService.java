package com.yonyou.driver.api;

/***
 * 驾驶模式服务
 */
public interface DriverModelService {
    /*** 设置自动接收推送 ***/
    void setDriverModelAutoReceive();
    /*** 取消自动接收推送 ***/
    void cancelDriverModelAutoReceive();
}
