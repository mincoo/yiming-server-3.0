package com.uxiaoxi.ym.appserver.db.account.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InviteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InviteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andAccIdIsNull() {
            addCriterion("acc_id is null");
            return (Criteria) this;
        }

        public Criteria andAccIdIsNotNull() {
            addCriterion("acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccIdEqualTo(Long value) {
            addCriterion("acc_id =", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotEqualTo(Long value) {
            addCriterion("acc_id <>", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdGreaterThan(Long value) {
            addCriterion("acc_id >", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdGreaterThanOrEqualTo(Long value) {
            addCriterion("acc_id >=", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLessThan(Long value) {
            addCriterion("acc_id <", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLessThanOrEqualTo(Long value) {
            addCriterion("acc_id <=", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdIn(List<Long> values) {
            addCriterion("acc_id in", values, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotIn(List<Long> values) {
            addCriterion("acc_id not in", values, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdBetween(Long value1, Long value2) {
            addCriterion("acc_id between", value1, value2, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotBetween(Long value1, Long value2) {
            addCriterion("acc_id not between", value1, value2, "accId");
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

        public Criteria andInvitedMobileIsNull() {
            addCriterion("invited_mobile is null");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileIsNotNull() {
            addCriterion("invited_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileEqualTo(String value) {
            addCriterion("invited_mobile =", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileNotEqualTo(String value) {
            addCriterion("invited_mobile <>", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileGreaterThan(String value) {
            addCriterion("invited_mobile >", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileGreaterThanOrEqualTo(String value) {
            addCriterion("invited_mobile >=", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileLessThan(String value) {
            addCriterion("invited_mobile <", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileLessThanOrEqualTo(String value) {
            addCriterion("invited_mobile <=", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileLike(String value) {
            addCriterion("invited_mobile like", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileNotLike(String value) {
            addCriterion("invited_mobile not like", value, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileIn(List<String> values) {
            addCriterion("invited_mobile in", values, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileNotIn(List<String> values) {
            addCriterion("invited_mobile not in", values, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileBetween(String value1, String value2) {
            addCriterion("invited_mobile between", value1, value2, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andInvitedMobileNotBetween(String value1, String value2) {
            addCriterion("invited_mobile not between", value1, value2, "invitedMobile");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNull() {
            addCriterion("create_dt is null");
            return (Criteria) this;
        }

        public Criteria andCreateDtIsNotNull() {
            addCriterion("create_dt is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDtEqualTo(Date value) {
            addCriterion("create_dt =", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotEqualTo(Date value) {
            addCriterion("create_dt <>", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThan(Date value) {
            addCriterion("create_dt >", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dt >=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThan(Date value) {
            addCriterion("create_dt <", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtLessThanOrEqualTo(Date value) {
            addCriterion("create_dt <=", value, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtIn(List<Date> values) {
            addCriterion("create_dt in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotIn(List<Date> values) {
            addCriterion("create_dt not in", values, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtBetween(Date value1, Date value2) {
            addCriterion("create_dt between", value1, value2, "createDt");
            return (Criteria) this;
        }

        public Criteria andCreateDtNotBetween(Date value1, Date value2) {
            addCriterion("create_dt not between", value1, value2, "createDt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}