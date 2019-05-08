package com.yonyou.itinerary.api;

/***
 * 行程服务
 */
public interface ItineraryService {
    /*** 车主发送行程单 ***/
    void sendTravelPlan();

    /*** 乘客发送行程需求单 ***/
    void sendTravelDemand();

    /*** 加价设置 ***/
    void setPriceMarkup();
}
