package com.yonyou.train.core.demand.domain.vo;

/***
 * 需求单值对象
 */
public class DemandVO {
    private String id;
    private String time;
    private String begin;
    private String end;
    private String userId;
    /**加价策略**/
    private String markupStrategy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMarkupStrategy() {
        return markupStrategy;
    }

    public void setMarkupStrategy(String markupStrategy) {
        this.markupStrategy = markupStrategy;
    }
}
