package com.uxiaoxi.ym.appserver.db.verification.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerificationCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VerificationCodeExample() {
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

        public Criteria andVCodeIsNull() {
            addCriterion("v_code is null");
            return (Criteria) this;
        }

        public Criteria andVCodeIsNotNull() {
            addCriterion("v_code is not null");
            return (Criteria) this;
        }

        public Criteria andVCodeEqualTo(Integer value) {
            addCriterion("v_code =", value, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeNotEqualTo(Integer value) {
            addCriterion("v_code <>", value, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeGreaterThan(Integer value) {
            addCriterion("v_code >", value, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_code >=", value, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeLessThan(Integer value) {
            addCriterion("v_code <", value, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeLessThanOrEqualTo(Integer value) {
            addCriterion("v_code <=", value, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeIn(List<Integer> values) {
            addCriterion("v_code in", values, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeNotIn(List<Integer> values) {
            addCriterion("v_code not in", values, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeBetween(Integer value1, Integer value2) {
            addCriterion("v_code between", value1, value2, "vCode");
            return (Criteria) this;
        }

        public Criteria andVCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("v_code not between", value1, value2, "vCode");
            return (Criteria) this;
        }

        public Criteria andVContentIsNull() {
            addCriterion("v_content is null");
            return (Criteria) this;
        }

        public Criteria andVContentIsNotNull() {
            addCriterion("v_content is not null");
            return (Criteria) this;
        }

        public Criteria andVContentEqualTo(String value) {
            addCriterion("v_content =", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentNotEqualTo(String value) {
            addCriterion("v_content <>", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentGreaterThan(String value) {
            addCriterion("v_content >", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentGreaterThanOrEqualTo(String value) {
            addCriterion("v_content >=", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentLessThan(String value) {
            addCriterion("v_content <", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentLessThanOrEqualTo(String value) {
            addCriterion("v_content <=", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentLike(String value) {
            addCriterion("v_content like", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentNotLike(String value) {
            addCriterion("v_content not like", value, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentIn(List<String> values) {
            addCriterion("v_content in", values, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentNotIn(List<String> values) {
            addCriterion("v_content not in", values, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentBetween(String value1, String value2) {
            addCriterion("v_content between", value1, value2, "vContent");
            return (Criteria) this;
        }

        public Criteria andVContentNotBetween(String value1, String value2) {
            addCriterion("v_content not between", value1, value2, "vContent");
            return (Criteria) this;
        }

        public Criteria andVTypeIsNull() {
            addCriterion("v_type is null");
            return (Criteria) this;
        }

        public Criteria andVTypeIsNotNull() {
            addCriterion("v_type is not null");
            return (Criteria) this;
        }

        public Criteria andVTypeEqualTo(Integer value) {
            addCriterion("v_type =", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotEqualTo(Integer value) {
            addCriterion("v_type <>", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeGreaterThan(Integer value) {
            addCriterion("v_type >", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("v_type >=", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeLessThan(Integer value) {
            addCriterion("v_type <", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeLessThanOrEqualTo(Integer value) {
            addCriterion("v_type <=", value, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeIn(List<Integer> values) {
            addCriterion("v_type in", values, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotIn(List<Integer> values) {
            addCriterion("v_type not in", values, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeBetween(Integer value1, Integer value2) {
            addCriterion("v_type between", value1, value2, "vType");
            return (Criteria) this;
        }

        public Criteria andVTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("v_type not between", value1, value2, "vType");
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

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Boolean value) {
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Boolean value) {
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Boolean value) {
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Boolean value) {
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Boolean value) {
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<Boolean> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<Boolean> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Boolean value1, Boolean value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("used not between", value1, value2, "used");
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