package com.example.springProduct.infrastructure.db.generated;

import com.example.springProduct.constant.code.RoleFlugEnum;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected String orderByClause;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected boolean distinct;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public UsersExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Id value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Id value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Id value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Id value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Id value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Id value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Id> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Id> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Id value1, Id value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Id value1, Id value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(UserName value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(UserName value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(UserName value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(UserName value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(UserName value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(UserName value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(UserName value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(UserName value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<UserName> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<UserName> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(UserName value1, UserName value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(UserName value1, UserName value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNull() {
            addCriterion("login_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("login_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(LoginId value) {
            addCriterion("login_id =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(LoginId value) {
            addCriterion("login_id <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(LoginId value) {
            addCriterion("login_id >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(LoginId value) {
            addCriterion("login_id >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(LoginId value) {
            addCriterion("login_id <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(LoginId value) {
            addCriterion("login_id <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLike(LoginId value) {
            addCriterion("login_id like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotLike(LoginId value) {
            addCriterion("login_id not like", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<LoginId> values) {
            addCriterion("login_id in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<LoginId> values) {
            addCriterion("login_id not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(LoginId value1, LoginId value2) {
            addCriterion("login_id between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(LoginId value1, LoginId value2) {
            addCriterion("login_id not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadIsNull() {
            addCriterion("authority_read is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadIsNotNull() {
            addCriterion("authority_read is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadEqualTo(RoleFlugEnum value) {
            addCriterion("authority_read =", value, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadNotEqualTo(RoleFlugEnum value) {
            addCriterion("authority_read <>", value, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadGreaterThan(RoleFlugEnum value) {
            addCriterion("authority_read >", value, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadGreaterThanOrEqualTo(RoleFlugEnum value) {
            addCriterion("authority_read >=", value, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadLessThan(RoleFlugEnum value) {
            addCriterion("authority_read <", value, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadLessThanOrEqualTo(RoleFlugEnum value) {
            addCriterion("authority_read <=", value, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadIn(List<RoleFlugEnum> values) {
            addCriterion("authority_read in", values, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadNotIn(List<RoleFlugEnum> values) {
            addCriterion("authority_read not in", values, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadBetween(RoleFlugEnum value1, RoleFlugEnum value2) {
            addCriterion("authority_read between", value1, value2, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityReadNotBetween(RoleFlugEnum value1, RoleFlugEnum value2) {
            addCriterion("authority_read not between", value1, value2, "authorityRead");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateIsNull() {
            addCriterion("authority_update is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateIsNotNull() {
            addCriterion("authority_update is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateEqualTo(RoleFlugEnum value) {
            addCriterion("authority_update =", value, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateNotEqualTo(RoleFlugEnum value) {
            addCriterion("authority_update <>", value, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateGreaterThan(RoleFlugEnum value) {
            addCriterion("authority_update >", value, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateGreaterThanOrEqualTo(RoleFlugEnum value) {
            addCriterion("authority_update >=", value, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateLessThan(RoleFlugEnum value) {
            addCriterion("authority_update <", value, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateLessThanOrEqualTo(RoleFlugEnum value) {
            addCriterion("authority_update <=", value, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateIn(List<RoleFlugEnum> values) {
            addCriterion("authority_update in", values, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateNotIn(List<RoleFlugEnum> values) {
            addCriterion("authority_update not in", values, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateBetween(RoleFlugEnum value1, RoleFlugEnum value2) {
            addCriterion("authority_update between", value1, value2, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityUpdateNotBetween(RoleFlugEnum value1, RoleFlugEnum value2) {
            addCriterion("authority_update not between", value1, value2, "authorityUpdate");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminIsNull() {
            addCriterion("authority_admin is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminIsNotNull() {
            addCriterion("authority_admin is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminEqualTo(RoleFlugEnum value) {
            addCriterion("authority_admin =", value, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminNotEqualTo(RoleFlugEnum value) {
            addCriterion("authority_admin <>", value, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminGreaterThan(RoleFlugEnum value) {
            addCriterion("authority_admin >", value, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminGreaterThanOrEqualTo(RoleFlugEnum value) {
            addCriterion("authority_admin >=", value, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminLessThan(RoleFlugEnum value) {
            addCriterion("authority_admin <", value, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminLessThanOrEqualTo(RoleFlugEnum value) {
            addCriterion("authority_admin <=", value, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminIn(List<RoleFlugEnum> values) {
            addCriterion("authority_admin in", values, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminNotIn(List<RoleFlugEnum> values) {
            addCriterion("authority_admin not in", values, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminBetween(RoleFlugEnum value1, RoleFlugEnum value2) {
            addCriterion("authority_admin between", value1, value2, "authorityAdmin");
            return (Criteria) this;
        }

        public Criteria andAuthorityAdminNotBetween(RoleFlugEnum value1, RoleFlugEnum value2) {
            addCriterion("authority_admin not between", value1, value2, "authorityAdmin");
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