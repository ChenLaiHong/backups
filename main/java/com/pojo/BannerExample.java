package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class BannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BannerExample() {
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

        public Criteria andBannerIdIsNull() {
            addCriterion("banner_id is null");
            return (Criteria) this;
        }

        public Criteria andBannerIdIsNotNull() {
            addCriterion("banner_id is not null");
            return (Criteria) this;
        }

        public Criteria andBannerIdEqualTo(Integer value) {
            addCriterion("banner_id =", value, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdNotEqualTo(Integer value) {
            addCriterion("banner_id <>", value, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdGreaterThan(Integer value) {
            addCriterion("banner_id >", value, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("banner_id >=", value, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdLessThan(Integer value) {
            addCriterion("banner_id <", value, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdLessThanOrEqualTo(Integer value) {
            addCriterion("banner_id <=", value, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdIn(List<Integer> values) {
            addCriterion("banner_id in", values, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdNotIn(List<Integer> values) {
            addCriterion("banner_id not in", values, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdBetween(Integer value1, Integer value2) {
            addCriterion("banner_id between", value1, value2, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("banner_id not between", value1, value2, "bannerId");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoIsNull() {
            addCriterion("banner_photo is null");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoIsNotNull() {
            addCriterion("banner_photo is not null");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoEqualTo(String value) {
            addCriterion("banner_photo =", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoNotEqualTo(String value) {
            addCriterion("banner_photo <>", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoGreaterThan(String value) {
            addCriterion("banner_photo >", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("banner_photo >=", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoLessThan(String value) {
            addCriterion("banner_photo <", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoLessThanOrEqualTo(String value) {
            addCriterion("banner_photo <=", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoLike(String value) {
            addCriterion("banner_photo like", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoNotLike(String value) {
            addCriterion("banner_photo not like", value, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoIn(List<String> values) {
            addCriterion("banner_photo in", values, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoNotIn(List<String> values) {
            addCriterion("banner_photo not in", values, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoBetween(String value1, String value2) {
            addCriterion("banner_photo between", value1, value2, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerPhotoNotBetween(String value1, String value2) {
            addCriterion("banner_photo not between", value1, value2, "bannerPhoto");
            return (Criteria) this;
        }

        public Criteria andBannerStateIsNull() {
            addCriterion("banner_state is null");
            return (Criteria) this;
        }

        public Criteria andBannerStateIsNotNull() {
            addCriterion("banner_state is not null");
            return (Criteria) this;
        }

        public Criteria andBannerStateEqualTo(Integer value) {
            addCriterion("banner_state =", value, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateNotEqualTo(Integer value) {
            addCriterion("banner_state <>", value, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateGreaterThan(Integer value) {
            addCriterion("banner_state >", value, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("banner_state >=", value, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateLessThan(Integer value) {
            addCriterion("banner_state <", value, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateLessThanOrEqualTo(Integer value) {
            addCriterion("banner_state <=", value, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateIn(List<Integer> values) {
            addCriterion("banner_state in", values, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateNotIn(List<Integer> values) {
            addCriterion("banner_state not in", values, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateBetween(Integer value1, Integer value2) {
            addCriterion("banner_state between", value1, value2, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerStateNotBetween(Integer value1, Integer value2) {
            addCriterion("banner_state not between", value1, value2, "bannerState");
            return (Criteria) this;
        }

        public Criteria andBannerOrderIsNull() {
            addCriterion("banner_order is null");
            return (Criteria) this;
        }

        public Criteria andBannerOrderIsNotNull() {
            addCriterion("banner_order is not null");
            return (Criteria) this;
        }

        public Criteria andBannerOrderEqualTo(Integer value) {
            addCriterion("banner_order =", value, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderNotEqualTo(Integer value) {
            addCriterion("banner_order <>", value, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderGreaterThan(Integer value) {
            addCriterion("banner_order >", value, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("banner_order >=", value, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderLessThan(Integer value) {
            addCriterion("banner_order <", value, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderLessThanOrEqualTo(Integer value) {
            addCriterion("banner_order <=", value, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderIn(List<Integer> values) {
            addCriterion("banner_order in", values, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderNotIn(List<Integer> values) {
            addCriterion("banner_order not in", values, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderBetween(Integer value1, Integer value2) {
            addCriterion("banner_order between", value1, value2, "bannerOrder");
            return (Criteria) this;
        }

        public Criteria andBannerOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("banner_order not between", value1, value2, "bannerOrder");
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