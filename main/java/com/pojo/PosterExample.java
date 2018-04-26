package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class PosterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PosterExample() {
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

        public Criteria andPosterIdIsNull() {
            addCriterion("poster_id is null");
            return (Criteria) this;
        }

        public Criteria andPosterIdIsNotNull() {
            addCriterion("poster_id is not null");
            return (Criteria) this;
        }

        public Criteria andPosterIdEqualTo(Integer value) {
            addCriterion("poster_id =", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdNotEqualTo(Integer value) {
            addCriterion("poster_id <>", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdGreaterThan(Integer value) {
            addCriterion("poster_id >", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("poster_id >=", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdLessThan(Integer value) {
            addCriterion("poster_id <", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdLessThanOrEqualTo(Integer value) {
            addCriterion("poster_id <=", value, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdIn(List<Integer> values) {
            addCriterion("poster_id in", values, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdNotIn(List<Integer> values) {
            addCriterion("poster_id not in", values, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdBetween(Integer value1, Integer value2) {
            addCriterion("poster_id between", value1, value2, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("poster_id not between", value1, value2, "posterId");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoIsNull() {
            addCriterion("poster_photo is null");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoIsNotNull() {
            addCriterion("poster_photo is not null");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoEqualTo(String value) {
            addCriterion("poster_photo =", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoNotEqualTo(String value) {
            addCriterion("poster_photo <>", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoGreaterThan(String value) {
            addCriterion("poster_photo >", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("poster_photo >=", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoLessThan(String value) {
            addCriterion("poster_photo <", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoLessThanOrEqualTo(String value) {
            addCriterion("poster_photo <=", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoLike(String value) {
            addCriterion("poster_photo like", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoNotLike(String value) {
            addCriterion("poster_photo not like", value, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoIn(List<String> values) {
            addCriterion("poster_photo in", values, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoNotIn(List<String> values) {
            addCriterion("poster_photo not in", values, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoBetween(String value1, String value2) {
            addCriterion("poster_photo between", value1, value2, "posterPhoto");
            return (Criteria) this;
        }

        public Criteria andPosterPhotoNotBetween(String value1, String value2) {
            addCriterion("poster_photo not between", value1, value2, "posterPhoto");
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