package com.fastdev.test.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CityInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityInfoExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLemmaItemIsNull() {
            addCriterion("LEMMA_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andLemmaItemIsNotNull() {
            addCriterion("LEMMA_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andLemmaItemEqualTo(String value) {
            addCriterion("LEMMA_ITEM =", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemNotEqualTo(String value) {
            addCriterion("LEMMA_ITEM <>", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemGreaterThan(String value) {
            addCriterion("LEMMA_ITEM >", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemGreaterThanOrEqualTo(String value) {
            addCriterion("LEMMA_ITEM >=", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemLessThan(String value) {
            addCriterion("LEMMA_ITEM <", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemLessThanOrEqualTo(String value) {
            addCriterion("LEMMA_ITEM <=", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemLike(String value) {
            addCriterion("LEMMA_ITEM like", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemNotLike(String value) {
            addCriterion("LEMMA_ITEM not like", value, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemIn(List<String> values) {
            addCriterion("LEMMA_ITEM in", values, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemNotIn(List<String> values) {
            addCriterion("LEMMA_ITEM not in", values, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemBetween(String value1, String value2) {
            addCriterion("LEMMA_ITEM between", value1, value2, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andLemmaItemNotBetween(String value1, String value2) {
            addCriterion("LEMMA_ITEM not between", value1, value2, "lemmaItem");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andModelFlagIsNull() {
            addCriterion("MODEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andModelFlagIsNotNull() {
            addCriterion("MODEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andModelFlagEqualTo(String value) {
            addCriterion("MODEL_FLAG =", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotEqualTo(String value) {
            addCriterion("MODEL_FLAG <>", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagGreaterThan(String value) {
            addCriterion("MODEL_FLAG >", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_FLAG >=", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagLessThan(String value) {
            addCriterion("MODEL_FLAG <", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagLessThanOrEqualTo(String value) {
            addCriterion("MODEL_FLAG <=", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagLike(String value) {
            addCriterion("MODEL_FLAG like", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotLike(String value) {
            addCriterion("MODEL_FLAG not like", value, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagIn(List<String> values) {
            addCriterion("MODEL_FLAG in", values, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotIn(List<String> values) {
            addCriterion("MODEL_FLAG not in", values, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagBetween(String value1, String value2) {
            addCriterion("MODEL_FLAG between", value1, value2, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andModelFlagNotBetween(String value1, String value2) {
            addCriterion("MODEL_FLAG not between", value1, value2, "modelFlag");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("UPDATER is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("UPDATER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("UPDATER =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("UPDATER <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("UPDATER >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATER >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("UPDATER <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("UPDATER <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("UPDATER like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("UPDATER not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("UPDATER in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("UPDATER not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("UPDATER between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("UPDATER not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemIsNull() {
            addCriterion("PRAENT_LEMMA_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemIsNotNull() {
            addCriterion("PRAENT_LEMMA_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemEqualTo(String value) {
            addCriterion("PRAENT_LEMMA_ITEM =", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemNotEqualTo(String value) {
            addCriterion("PRAENT_LEMMA_ITEM <>", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemGreaterThan(String value) {
            addCriterion("PRAENT_LEMMA_ITEM >", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemGreaterThanOrEqualTo(String value) {
            addCriterion("PRAENT_LEMMA_ITEM >=", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemLessThan(String value) {
            addCriterion("PRAENT_LEMMA_ITEM <", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemLessThanOrEqualTo(String value) {
            addCriterion("PRAENT_LEMMA_ITEM <=", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemLike(String value) {
            addCriterion("PRAENT_LEMMA_ITEM like", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemNotLike(String value) {
            addCriterion("PRAENT_LEMMA_ITEM not like", value, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemIn(List<String> values) {
            addCriterion("PRAENT_LEMMA_ITEM in", values, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemNotIn(List<String> values) {
            addCriterion("PRAENT_LEMMA_ITEM not in", values, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemBetween(String value1, String value2) {
            addCriterion("PRAENT_LEMMA_ITEM between", value1, value2, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andPraentLemmaItemNotBetween(String value1, String value2) {
            addCriterion("PRAENT_LEMMA_ITEM not between", value1, value2, "praentLemmaItem");
            return (Criteria) this;
        }

        public Criteria andModelOrderIsNull() {
            addCriterion("MODEL_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andModelOrderIsNotNull() {
            addCriterion("MODEL_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andModelOrderEqualTo(Integer value) {
            addCriterion("MODEL_ORDER =", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderNotEqualTo(Integer value) {
            addCriterion("MODEL_ORDER <>", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderGreaterThan(Integer value) {
            addCriterion("MODEL_ORDER >", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("MODEL_ORDER >=", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderLessThan(Integer value) {
            addCriterion("MODEL_ORDER <", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderLessThanOrEqualTo(Integer value) {
            addCriterion("MODEL_ORDER <=", value, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderIn(List<Integer> values) {
            addCriterion("MODEL_ORDER in", values, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderNotIn(List<Integer> values) {
            addCriterion("MODEL_ORDER not in", values, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_ORDER between", value1, value2, "modelOrder");
            return (Criteria) this;
        }

        public Criteria andModelOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("MODEL_ORDER not between", value1, value2, "modelOrder");
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