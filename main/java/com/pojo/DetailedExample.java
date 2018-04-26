package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class DetailedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DetailedExample() {
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

        public Criteria andDetailedIdIsNull() {
            addCriterion("detailed_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailedIdIsNotNull() {
            addCriterion("detailed_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedIdEqualTo(Integer value) {
            addCriterion("detailed_id =", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdNotEqualTo(Integer value) {
            addCriterion("detailed_id <>", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdGreaterThan(Integer value) {
            addCriterion("detailed_id >", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detailed_id >=", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdLessThan(Integer value) {
            addCriterion("detailed_id <", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdLessThanOrEqualTo(Integer value) {
            addCriterion("detailed_id <=", value, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdIn(List<Integer> values) {
            addCriterion("detailed_id in", values, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdNotIn(List<Integer> values) {
            addCriterion("detailed_id not in", values, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdBetween(Integer value1, Integer value2) {
            addCriterion("detailed_id between", value1, value2, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detailed_id not between", value1, value2, "detailedId");
            return (Criteria) this;
        }

        public Criteria andDetailedNameIsNull() {
            addCriterion("detailed_name is null");
            return (Criteria) this;
        }

        public Criteria andDetailedNameIsNotNull() {
            addCriterion("detailed_name is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedNameEqualTo(String value) {
            addCriterion("detailed_name =", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameNotEqualTo(String value) {
            addCriterion("detailed_name <>", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameGreaterThan(String value) {
            addCriterion("detailed_name >", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_name >=", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameLessThan(String value) {
            addCriterion("detailed_name <", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameLessThanOrEqualTo(String value) {
            addCriterion("detailed_name <=", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameLike(String value) {
            addCriterion("detailed_name like", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameNotLike(String value) {
            addCriterion("detailed_name not like", value, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameIn(List<String> values) {
            addCriterion("detailed_name in", values, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameNotIn(List<String> values) {
            addCriterion("detailed_name not in", values, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameBetween(String value1, String value2) {
            addCriterion("detailed_name between", value1, value2, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedNameNotBetween(String value1, String value2) {
            addCriterion("detailed_name not between", value1, value2, "detailedName");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoIsNull() {
            addCriterion("detailed_photo is null");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoIsNotNull() {
            addCriterion("detailed_photo is not null");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoEqualTo(String value) {
            addCriterion("detailed_photo =", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoNotEqualTo(String value) {
            addCriterion("detailed_photo <>", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoGreaterThan(String value) {
            addCriterion("detailed_photo >", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_photo >=", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoLessThan(String value) {
            addCriterion("detailed_photo <", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoLessThanOrEqualTo(String value) {
            addCriterion("detailed_photo <=", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoLike(String value) {
            addCriterion("detailed_photo like", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoNotLike(String value) {
            addCriterion("detailed_photo not like", value, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoIn(List<String> values) {
            addCriterion("detailed_photo in", values, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoNotIn(List<String> values) {
            addCriterion("detailed_photo not in", values, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoBetween(String value1, String value2) {
            addCriterion("detailed_photo between", value1, value2, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andDetailedPhotoNotBetween(String value1, String value2) {
            addCriterion("detailed_photo not between", value1, value2, "detailedPhoto");
            return (Criteria) this;
        }

        public Criteria andSecondIdIsNull() {
            addCriterion("second_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondIdIsNotNull() {
            addCriterion("second_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondIdEqualTo(Integer value) {
            addCriterion("second_id =", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotEqualTo(Integer value) {
            addCriterion("second_id <>", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThan(Integer value) {
            addCriterion("second_id >", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_id >=", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThan(Integer value) {
            addCriterion("second_id <", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdLessThanOrEqualTo(Integer value) {
            addCriterion("second_id <=", value, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdIn(List<Integer> values) {
            addCriterion("second_id in", values, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotIn(List<Integer> values) {
            addCriterion("second_id not in", values, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdBetween(Integer value1, Integer value2) {
            addCriterion("second_id between", value1, value2, "secondId");
            return (Criteria) this;
        }

        public Criteria andSecondIdNotBetween(Integer value1, Integer value2) {
            addCriterion("second_id not between", value1, value2, "secondId");
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