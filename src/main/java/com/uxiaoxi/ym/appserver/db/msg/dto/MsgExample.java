package com.uxiaoxi.ym.appserver.db.msg.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgExample {
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    protected String orderByClause;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    protected boolean distinct;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public MsgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNull() {
            addCriterion("sender_id is null");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNotNull() {
            addCriterion("sender_id is not null");
            return (Criteria) this;
        }

        public Criteria andSenderIdEqualTo(Long value) {
            addCriterion("sender_id =", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotEqualTo(Long value) {
            addCriterion("sender_id <>", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThan(Long value) {
            addCriterion("sender_id >", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sender_id >=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThan(Long value) {
            addCriterion("sender_id <", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThanOrEqualTo(Long value) {
            addCriterion("sender_id <=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdIn(List<Long> values) {
            addCriterion("sender_id in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotIn(List<Long> values) {
            addCriterion("sender_id not in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdBetween(Long value1, Long value2) {
            addCriterion("sender_id between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotBetween(Long value1, Long value2) {
            addCriterion("sender_id not between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andCluIdIsNull() {
            addCriterion("clu_id is null");
            return (Criteria) this;
        }

        public Criteria andCluIdIsNotNull() {
            addCriterion("clu_id is not null");
            return (Criteria) this;
        }

        public Criteria andCluIdEqualTo(Long value) {
            addCriterion("clu_id =", value, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdNotEqualTo(Long value) {
            addCriterion("clu_id <>", value, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdGreaterThan(Long value) {
            addCriterion("clu_id >", value, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdGreaterThanOrEqualTo(Long value) {
            addCriterion("clu_id >=", value, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdLessThan(Long value) {
            addCriterion("clu_id <", value, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdLessThanOrEqualTo(Long value) {
            addCriterion("clu_id <=", value, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdIn(List<Long> values) {
            addCriterion("clu_id in", values, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdNotIn(List<Long> values) {
            addCriterion("clu_id not in", values, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdBetween(Long value1, Long value2) {
            addCriterion("clu_id between", value1, value2, "cluId");
            return (Criteria) this;
        }

        public Criteria andCluIdNotBetween(Long value1, Long value2) {
            addCriterion("clu_id not between", value1, value2, "cluId");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNull() {
            addCriterion("msg_type is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(Long value) {
            addCriterion("msg_type =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(Long value) {
            addCriterion("msg_type <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(Long value) {
            addCriterion("msg_type >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("msg_type >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(Long value) {
            addCriterion("msg_type <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(Long value) {
            addCriterion("msg_type <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<Long> values) {
            addCriterion("msg_type in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<Long> values) {
            addCriterion("msg_type not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(Long value1, Long value2) {
            addCriterion("msg_type between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(Long value1, Long value2) {
            addCriterion("msg_type not between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(Long value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(Long value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(Long value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(Long value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(Long value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<Long> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<Long> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(Long value1, Long value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(Long value1, Long value2) {
            addCriterion("content_type not between", value1, value2,
                    "contentType");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andStypeIsNull() {
            addCriterion("stype is null");
            return (Criteria) this;
        }

        public Criteria andStypeIsNotNull() {
            addCriterion("stype is not null");
            return (Criteria) this;
        }

        public Criteria andStypeEqualTo(Integer value) {
            addCriterion("stype =", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotEqualTo(Integer value) {
            addCriterion("stype <>", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThan(Integer value) {
            addCriterion("stype >", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stype >=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThan(Integer value) {
            addCriterion("stype <", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeLessThanOrEqualTo(Integer value) {
            addCriterion("stype <=", value, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeIn(List<Integer> values) {
            addCriterion("stype in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotIn(List<Integer> values) {
            addCriterion("stype not in", values, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeBetween(Integer value1, Integer value2) {
            addCriterion("stype between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andStypeNotBetween(Integer value1, Integer value2) {
            addCriterion("stype not between", value1, value2, "stype");
            return (Criteria) this;
        }

        public Criteria andSelect1IsNull() {
            addCriterion("select1 is null");
            return (Criteria) this;
        }

        public Criteria andSelect1IsNotNull() {
            addCriterion("select1 is not null");
            return (Criteria) this;
        }

        public Criteria andSelect1EqualTo(String value) {
            addCriterion("select1 =", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotEqualTo(String value) {
            addCriterion("select1 <>", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1GreaterThan(String value) {
            addCriterion("select1 >", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1GreaterThanOrEqualTo(String value) {
            addCriterion("select1 >=", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1LessThan(String value) {
            addCriterion("select1 <", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1LessThanOrEqualTo(String value) {
            addCriterion("select1 <=", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1Like(String value) {
            addCriterion("select1 like", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotLike(String value) {
            addCriterion("select1 not like", value, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1In(List<String> values) {
            addCriterion("select1 in", values, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotIn(List<String> values) {
            addCriterion("select1 not in", values, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1Between(String value1, String value2) {
            addCriterion("select1 between", value1, value2, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect1NotBetween(String value1, String value2) {
            addCriterion("select1 not between", value1, value2, "select1");
            return (Criteria) this;
        }

        public Criteria andSelect2IsNull() {
            addCriterion("select2 is null");
            return (Criteria) this;
        }

        public Criteria andSelect2IsNotNull() {
            addCriterion("select2 is not null");
            return (Criteria) this;
        }

        public Criteria andSelect2EqualTo(String value) {
            addCriterion("select2 =", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotEqualTo(String value) {
            addCriterion("select2 <>", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2GreaterThan(String value) {
            addCriterion("select2 >", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2GreaterThanOrEqualTo(String value) {
            addCriterion("select2 >=", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2LessThan(String value) {
            addCriterion("select2 <", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2LessThanOrEqualTo(String value) {
            addCriterion("select2 <=", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2Like(String value) {
            addCriterion("select2 like", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotLike(String value) {
            addCriterion("select2 not like", value, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2In(List<String> values) {
            addCriterion("select2 in", values, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotIn(List<String> values) {
            addCriterion("select2 not in", values, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2Between(String value1, String value2) {
            addCriterion("select2 between", value1, value2, "select2");
            return (Criteria) this;
        }

        public Criteria andSelect2NotBetween(String value1, String value2) {
            addCriterion("select2 not between", value1, value2, "select2");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andContentLikeInsensitive(String value) {
            addCriterion("upper(content) like", value.toUpperCase(), "content");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(url) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andSelect1LikeInsensitive(String value) {
            addCriterion("upper(select1) like", value.toUpperCase(), "select1");
            return (Criteria) this;
        }

        public Criteria andSelect2LikeInsensitive(String value) {
            addCriterion("upper(select2) like", value.toUpperCase(), "select2");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator. This class corresponds to the database table msg
     * @mbggenerated  Sat Jan 30 20:07:25 CST 2016
     */
    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue,
                String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table msg
     *
     * @mbggenerated do_not_delete_during_merge Wed Jan 27 10:24:05 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}