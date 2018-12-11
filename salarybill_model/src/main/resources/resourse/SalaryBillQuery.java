package com.htcs.wework.salarybill.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SalaryBillQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public SalaryBillQuery() {
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(Date value) {
            addCriterionForJDBCDate("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<Date> values) {
            addCriterionForJDBCDate("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entry_time not between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceIsNull() {
            addCriterion("duty_attendance is null");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceIsNotNull() {
            addCriterion("duty_attendance is not null");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceEqualTo(Integer value) {
            addCriterion("duty_attendance =", value, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceNotEqualTo(Integer value) {
            addCriterion("duty_attendance <>", value, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceGreaterThan(Integer value) {
            addCriterion("duty_attendance >", value, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("duty_attendance >=", value, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceLessThan(Integer value) {
            addCriterion("duty_attendance <", value, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("duty_attendance <=", value, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceIn(List<Integer> values) {
            addCriterion("duty_attendance in", values, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceNotIn(List<Integer> values) {
            addCriterion("duty_attendance not in", values, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("duty_attendance between", value1, value2, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andDutyAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("duty_attendance not between", value1, value2, "dutyAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceIsNull() {
            addCriterion("actual_attendance is null");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceIsNotNull() {
            addCriterion("actual_attendance is not null");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceEqualTo(Integer value) {
            addCriterion("actual_attendance =", value, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceNotEqualTo(Integer value) {
            addCriterion("actual_attendance <>", value, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceGreaterThan(Integer value) {
            addCriterion("actual_attendance >", value, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_attendance >=", value, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceLessThan(Integer value) {
            addCriterion("actual_attendance <", value, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceLessThanOrEqualTo(Integer value) {
            addCriterion("actual_attendance <=", value, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceIn(List<Integer> values) {
            addCriterion("actual_attendance in", values, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceNotIn(List<Integer> values) {
            addCriterion("actual_attendance not in", values, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceBetween(Integer value1, Integer value2) {
            addCriterion("actual_attendance between", value1, value2, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andActualAttendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_attendance not between", value1, value2, "actualAttendance");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryIsNull() {
            addCriterion("base_salary is null");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryIsNotNull() {
            addCriterion("base_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryEqualTo(Integer value) {
            addCriterion("base_salary =", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotEqualTo(Integer value) {
            addCriterion("base_salary <>", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryGreaterThan(Integer value) {
            addCriterion("base_salary >", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("base_salary >=", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryLessThan(Integer value) {
            addCriterion("base_salary <", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("base_salary <=", value, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryIn(List<Integer> values) {
            addCriterion("base_salary in", values, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotIn(List<Integer> values) {
            addCriterion("base_salary not in", values, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryBetween(Integer value1, Integer value2) {
            addCriterion("base_salary between", value1, value2, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andBaseSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("base_salary not between", value1, value2, "baseSalary");
            return (Criteria) this;
        }

        public Criteria andPercentageIsNull() {
            addCriterion("percentage is null");
            return (Criteria) this;
        }

        public Criteria andPercentageIsNotNull() {
            addCriterion("percentage is not null");
            return (Criteria) this;
        }

        public Criteria andPercentageEqualTo(Integer value) {
            addCriterion("percentage =", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotEqualTo(Integer value) {
            addCriterion("percentage <>", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageGreaterThan(Integer value) {
            addCriterion("percentage >", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageGreaterThanOrEqualTo(Integer value) {
            addCriterion("percentage >=", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLessThan(Integer value) {
            addCriterion("percentage <", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLessThanOrEqualTo(Integer value) {
            addCriterion("percentage <=", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageIn(List<Integer> values) {
            addCriterion("percentage in", values, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotIn(List<Integer> values) {
            addCriterion("percentage not in", values, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageBetween(Integer value1, Integer value2) {
            addCriterion("percentage between", value1, value2, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotBetween(Integer value1, Integer value2) {
            addCriterion("percentage not between", value1, value2, "percentage");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyIsNull() {
            addCriterion("work_age_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyIsNotNull() {
            addCriterion("work_age_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyEqualTo(Integer value) {
            addCriterion("work_age_subsidy =", value, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyNotEqualTo(Integer value) {
            addCriterion("work_age_subsidy <>", value, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyGreaterThan(Integer value) {
            addCriterion("work_age_subsidy >", value, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_age_subsidy >=", value, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyLessThan(Integer value) {
            addCriterion("work_age_subsidy <", value, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyLessThanOrEqualTo(Integer value) {
            addCriterion("work_age_subsidy <=", value, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyIn(List<Integer> values) {
            addCriterion("work_age_subsidy in", values, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyNotIn(List<Integer> values) {
            addCriterion("work_age_subsidy not in", values, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyBetween(Integer value1, Integer value2) {
            addCriterion("work_age_subsidy between", value1, value2, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkAgeSubsidyNotBetween(Integer value1, Integer value2) {
            addCriterion("work_age_subsidy not between", value1, value2, "workAgeSubsidy");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardIsNull() {
            addCriterion("total_day_reward is null");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardIsNotNull() {
            addCriterion("total_day_reward is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardEqualTo(Integer value) {
            addCriterion("total_day_reward =", value, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardNotEqualTo(Integer value) {
            addCriterion("total_day_reward <>", value, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardGreaterThan(Integer value) {
            addCriterion("total_day_reward >", value, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_day_reward >=", value, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardLessThan(Integer value) {
            addCriterion("total_day_reward <", value, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardLessThanOrEqualTo(Integer value) {
            addCriterion("total_day_reward <=", value, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardIn(List<Integer> values) {
            addCriterion("total_day_reward in", values, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardNotIn(List<Integer> values) {
            addCriterion("total_day_reward not in", values, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardBetween(Integer value1, Integer value2) {
            addCriterion("total_day_reward between", value1, value2, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTotalDayRewardNotBetween(Integer value1, Integer value2) {
            addCriterion("total_day_reward not between", value1, value2, "totalDayReward");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyIsNull() {
            addCriterion("traffic_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyIsNotNull() {
            addCriterion("traffic_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyEqualTo(Integer value) {
            addCriterion("traffic_subsidy =", value, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyNotEqualTo(Integer value) {
            addCriterion("traffic_subsidy <>", value, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyGreaterThan(Integer value) {
            addCriterion("traffic_subsidy >", value, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyGreaterThanOrEqualTo(Integer value) {
            addCriterion("traffic_subsidy >=", value, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyLessThan(Integer value) {
            addCriterion("traffic_subsidy <", value, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyLessThanOrEqualTo(Integer value) {
            addCriterion("traffic_subsidy <=", value, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyIn(List<Integer> values) {
            addCriterion("traffic_subsidy in", values, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyNotIn(List<Integer> values) {
            addCriterion("traffic_subsidy not in", values, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyBetween(Integer value1, Integer value2) {
            addCriterion("traffic_subsidy between", value1, value2, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andTrafficSubsidyNotBetween(Integer value1, Integer value2) {
            addCriterion("traffic_subsidy not between", value1, value2, "trafficSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyIsNull() {
            addCriterion("communication_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyIsNotNull() {
            addCriterion("communication_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyEqualTo(Integer value) {
            addCriterion("communication_subsidy =", value, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyNotEqualTo(Integer value) {
            addCriterion("communication_subsidy <>", value, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyGreaterThan(Integer value) {
            addCriterion("communication_subsidy >", value, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyGreaterThanOrEqualTo(Integer value) {
            addCriterion("communication_subsidy >=", value, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyLessThan(Integer value) {
            addCriterion("communication_subsidy <", value, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyLessThanOrEqualTo(Integer value) {
            addCriterion("communication_subsidy <=", value, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyIn(List<Integer> values) {
            addCriterion("communication_subsidy in", values, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyNotIn(List<Integer> values) {
            addCriterion("communication_subsidy not in", values, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyBetween(Integer value1, Integer value2) {
            addCriterion("communication_subsidy between", value1, value2, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andCommunicationSubsidyNotBetween(Integer value1, Integer value2) {
            addCriterion("communication_subsidy not between", value1, value2, "communicationSubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyIsNull() {
            addCriterion("birthday_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyIsNotNull() {
            addCriterion("birthday_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyEqualTo(Integer value) {
            addCriterion("birthday_subsidy =", value, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyNotEqualTo(Integer value) {
            addCriterion("birthday_subsidy <>", value, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyGreaterThan(Integer value) {
            addCriterion("birthday_subsidy >", value, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyGreaterThanOrEqualTo(Integer value) {
            addCriterion("birthday_subsidy >=", value, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyLessThan(Integer value) {
            addCriterion("birthday_subsidy <", value, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyLessThanOrEqualTo(Integer value) {
            addCriterion("birthday_subsidy <=", value, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyIn(List<Integer> values) {
            addCriterion("birthday_subsidy in", values, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyNotIn(List<Integer> values) {
            addCriterion("birthday_subsidy not in", values, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyBetween(Integer value1, Integer value2) {
            addCriterion("birthday_subsidy between", value1, value2, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBirthdaySubsidyNotBetween(Integer value1, Integer value2) {
            addCriterion("birthday_subsidy not between", value1, value2, "birthdaySubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyIsNull() {
            addCriterion("business_trip_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyIsNotNull() {
            addCriterion("business_trip_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyEqualTo(Integer value) {
            addCriterion("business_trip_subsidy =", value, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyNotEqualTo(Integer value) {
            addCriterion("business_trip_subsidy <>", value, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyGreaterThan(Integer value) {
            addCriterion("business_trip_subsidy >", value, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_trip_subsidy >=", value, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyLessThan(Integer value) {
            addCriterion("business_trip_subsidy <", value, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyLessThanOrEqualTo(Integer value) {
            addCriterion("business_trip_subsidy <=", value, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyIn(List<Integer> values) {
            addCriterion("business_trip_subsidy in", values, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyNotIn(List<Integer> values) {
            addCriterion("business_trip_subsidy not in", values, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyBetween(Integer value1, Integer value2) {
            addCriterion("business_trip_subsidy between", value1, value2, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andBusinessTripSubsidyNotBetween(Integer value1, Integer value2) {
            addCriterion("business_trip_subsidy not between", value1, value2, "businessTripSubsidy");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalIsNull() {
            addCriterion("should_pay_total is null");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalIsNotNull() {
            addCriterion("should_pay_total is not null");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalEqualTo(Integer value) {
            addCriterion("should_pay_total =", value, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalNotEqualTo(Integer value) {
            addCriterion("should_pay_total <>", value, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalGreaterThan(Integer value) {
            addCriterion("should_pay_total >", value, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("should_pay_total >=", value, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalLessThan(Integer value) {
            addCriterion("should_pay_total <", value, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalLessThanOrEqualTo(Integer value) {
            addCriterion("should_pay_total <=", value, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalIn(List<Integer> values) {
            addCriterion("should_pay_total in", values, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalNotIn(List<Integer> values) {
            addCriterion("should_pay_total not in", values, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalBetween(Integer value1, Integer value2) {
            addCriterion("should_pay_total between", value1, value2, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andShouldPayTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("should_pay_total not between", value1, value2, "shouldPayTotal");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdIsNull() {
            addCriterion("be_late_withhold is null");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdIsNotNull() {
            addCriterion("be_late_withhold is not null");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdEqualTo(Integer value) {
            addCriterion("be_late_withhold =", value, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdNotEqualTo(Integer value) {
            addCriterion("be_late_withhold <>", value, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdGreaterThan(Integer value) {
            addCriterion("be_late_withhold >", value, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("be_late_withhold >=", value, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdLessThan(Integer value) {
            addCriterion("be_late_withhold <", value, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdLessThanOrEqualTo(Integer value) {
            addCriterion("be_late_withhold <=", value, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdIn(List<Integer> values) {
            addCriterion("be_late_withhold in", values, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdNotIn(List<Integer> values) {
            addCriterion("be_late_withhold not in", values, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdBetween(Integer value1, Integer value2) {
            addCriterion("be_late_withhold between", value1, value2, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andBeLateWithholdNotBetween(Integer value1, Integer value2) {
            addCriterion("be_late_withhold not between", value1, value2, "beLateWithhold");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceIsNull() {
            addCriterion("endowment_insurance is null");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceIsNotNull() {
            addCriterion("endowment_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceEqualTo(Integer value) {
            addCriterion("endowment_insurance =", value, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceNotEqualTo(Integer value) {
            addCriterion("endowment_insurance <>", value, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceGreaterThan(Integer value) {
            addCriterion("endowment_insurance >", value, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceGreaterThanOrEqualTo(Integer value) {
            addCriterion("endowment_insurance >=", value, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceLessThan(Integer value) {
            addCriterion("endowment_insurance <", value, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceLessThanOrEqualTo(Integer value) {
            addCriterion("endowment_insurance <=", value, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceIn(List<Integer> values) {
            addCriterion("endowment_insurance in", values, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceNotIn(List<Integer> values) {
            addCriterion("endowment_insurance not in", values, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceBetween(Integer value1, Integer value2) {
            addCriterion("endowment_insurance between", value1, value2, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentInsuranceNotBetween(Integer value1, Integer value2) {
            addCriterion("endowment_insurance not between", value1, value2, "endowmentInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceIsNull() {
            addCriterion("medical_insurance is null");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceIsNotNull() {
            addCriterion("medical_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceEqualTo(Integer value) {
            addCriterion("medical_insurance =", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceNotEqualTo(Integer value) {
            addCriterion("medical_insurance <>", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceGreaterThan(Integer value) {
            addCriterion("medical_insurance >", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceGreaterThanOrEqualTo(Integer value) {
            addCriterion("medical_insurance >=", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceLessThan(Integer value) {
            addCriterion("medical_insurance <", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceLessThanOrEqualTo(Integer value) {
            addCriterion("medical_insurance <=", value, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceIn(List<Integer> values) {
            addCriterion("medical_insurance in", values, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceNotIn(List<Integer> values) {
            addCriterion("medical_insurance not in", values, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceBetween(Integer value1, Integer value2) {
            addCriterion("medical_insurance between", value1, value2, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalInsuranceNotBetween(Integer value1, Integer value2) {
            addCriterion("medical_insurance not between", value1, value2, "medicalInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceIsNull() {
            addCriterion("unemployment_insurance is null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceIsNotNull() {
            addCriterion("unemployment_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceEqualTo(Integer value) {
            addCriterion("unemployment_insurance =", value, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceNotEqualTo(Integer value) {
            addCriterion("unemployment_insurance <>", value, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceGreaterThan(Integer value) {
            addCriterion("unemployment_insurance >", value, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceGreaterThanOrEqualTo(Integer value) {
            addCriterion("unemployment_insurance >=", value, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceLessThan(Integer value) {
            addCriterion("unemployment_insurance <", value, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceLessThanOrEqualTo(Integer value) {
            addCriterion("unemployment_insurance <=", value, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceIn(List<Integer> values) {
            addCriterion("unemployment_insurance in", values, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceNotIn(List<Integer> values) {
            addCriterion("unemployment_insurance not in", values, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceBetween(Integer value1, Integer value2) {
            addCriterion("unemployment_insurance between", value1, value2, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentInsuranceNotBetween(Integer value1, Integer value2) {
            addCriterion("unemployment_insurance not between", value1, value2, "unemploymentInsurance");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundIsNull() {
            addCriterion("housing_provident_fund is null");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundIsNotNull() {
            addCriterion("housing_provident_fund is not null");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundEqualTo(Integer value) {
            addCriterion("housing_provident_fund =", value, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundNotEqualTo(Integer value) {
            addCriterion("housing_provident_fund <>", value, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundGreaterThan(Integer value) {
            addCriterion("housing_provident_fund >", value, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundGreaterThanOrEqualTo(Integer value) {
            addCriterion("housing_provident_fund >=", value, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundLessThan(Integer value) {
            addCriterion("housing_provident_fund <", value, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundLessThanOrEqualTo(Integer value) {
            addCriterion("housing_provident_fund <=", value, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundIn(List<Integer> values) {
            addCriterion("housing_provident_fund in", values, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundNotIn(List<Integer> values) {
            addCriterion("housing_provident_fund not in", values, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundBetween(Integer value1, Integer value2) {
            addCriterion("housing_provident_fund between", value1, value2, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andHousingProvidentFundNotBetween(Integer value1, Integer value2) {
            addCriterion("housing_provident_fund not between", value1, value2, "housingProvidentFund");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalIsNull() {
            addCriterion("actural_pay_total is null");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalIsNotNull() {
            addCriterion("actural_pay_total is not null");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalEqualTo(Integer value) {
            addCriterion("actural_pay_total =", value, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalNotEqualTo(Integer value) {
            addCriterion("actural_pay_total <>", value, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalGreaterThan(Integer value) {
            addCriterion("actural_pay_total >", value, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("actural_pay_total >=", value, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalLessThan(Integer value) {
            addCriterion("actural_pay_total <", value, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalLessThanOrEqualTo(Integer value) {
            addCriterion("actural_pay_total <=", value, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalIn(List<Integer> values) {
            addCriterion("actural_pay_total in", values, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalNotIn(List<Integer> values) {
            addCriterion("actural_pay_total not in", values, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalBetween(Integer value1, Integer value2) {
            addCriterion("actural_pay_total between", value1, value2, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andActuralPayTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("actural_pay_total not between", value1, value2, "acturalPayTotal");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSalaryDateIsNull() {
            addCriterion("salary_date is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDateIsNotNull() {
            addCriterion("salary_date is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDateEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date =", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date <>", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateGreaterThan(Date value) {
            addCriterionForJDBCDate("salary_date >", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date >=", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateLessThan(Date value) {
            addCriterionForJDBCDate("salary_date <", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date <=", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateIn(List<Date> values) {
            addCriterionForJDBCDate("salary_date in", values, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("salary_date not in", values, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salary_date between", value1, value2, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salary_date not between", value1, value2, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBalancePayIsNull() {
            addCriterion("balance_pay is null");
            return (Criteria) this;
        }

        public Criteria andBalancePayIsNotNull() {
            addCriterion("balance_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBalancePayEqualTo(Integer value) {
            addCriterion("balance_pay =", value, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayNotEqualTo(Integer value) {
            addCriterion("balance_pay <>", value, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayGreaterThan(Integer value) {
            addCriterion("balance_pay >", value, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance_pay >=", value, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayLessThan(Integer value) {
            addCriterion("balance_pay <", value, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayLessThanOrEqualTo(Integer value) {
            addCriterion("balance_pay <=", value, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayIn(List<Integer> values) {
            addCriterion("balance_pay in", values, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayNotIn(List<Integer> values) {
            addCriterion("balance_pay not in", values, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayBetween(Integer value1, Integer value2) {
            addCriterion("balance_pay between", value1, value2, "balancePay");
            return (Criteria) this;
        }

        public Criteria andBalancePayNotBetween(Integer value1, Integer value2) {
            addCriterion("balance_pay not between", value1, value2, "balancePay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayIsNull() {
            addCriterion("already_pay is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayIsNotNull() {
            addCriterion("already_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayEqualTo(Integer value) {
            addCriterion("already_pay =", value, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayNotEqualTo(Integer value) {
            addCriterion("already_pay <>", value, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayGreaterThan(Integer value) {
            addCriterion("already_pay >", value, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("already_pay >=", value, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayLessThan(Integer value) {
            addCriterion("already_pay <", value, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayLessThanOrEqualTo(Integer value) {
            addCriterion("already_pay <=", value, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayIn(List<Integer> values) {
            addCriterion("already_pay in", values, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayNotIn(List<Integer> values) {
            addCriterion("already_pay not in", values, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayBetween(Integer value1, Integer value2) {
            addCriterion("already_pay between", value1, value2, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andAlreadyPayNotBetween(Integer value1, Integer value2) {
            addCriterion("already_pay not between", value1, value2, "alreadyPay");
            return (Criteria) this;
        }

        public Criteria andLogicalDelIsNull() {
            addCriterion("logical_del is null");
            return (Criteria) this;
        }

        public Criteria andLogicalDelIsNotNull() {
            addCriterion("logical_del is not null");
            return (Criteria) this;
        }

        public Criteria andLogicalDelEqualTo(Byte value) {
            addCriterion("logical_del =", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelNotEqualTo(Byte value) {
            addCriterion("logical_del <>", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelGreaterThan(Byte value) {
            addCriterion("logical_del >", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("logical_del >=", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelLessThan(Byte value) {
            addCriterion("logical_del <", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelLessThanOrEqualTo(Byte value) {
            addCriterion("logical_del <=", value, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelIn(List<Byte> values) {
            addCriterion("logical_del in", values, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelNotIn(List<Byte> values) {
            addCriterion("logical_del not in", values, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelBetween(Byte value1, Byte value2) {
            addCriterion("logical_del between", value1, value2, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andLogicalDelNotBetween(Byte value1, Byte value2) {
            addCriterion("logical_del not between", value1, value2, "logicalDel");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNull() {
            addCriterion("update_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNotNull() {
            addCriterion("update_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameEqualTo(String value) {
            addCriterion("update_name =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotEqualTo(String value) {
            addCriterion("update_name <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThan(String value) {
            addCriterion("update_name >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_name >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThan(String value) {
            addCriterion("update_name <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("update_name <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLike(String value) {
            addCriterion("update_name like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotLike(String value) {
            addCriterion("update_name not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIn(List<String> values) {
            addCriterion("update_name in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotIn(List<String> values) {
            addCriterion("update_name not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameBetween(String value1, String value2) {
            addCriterion("update_name between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotBetween(String value1, String value2) {
            addCriterion("update_name not between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andProblemIsNull() {
            addCriterion("problem is null");
            return (Criteria) this;
        }

        public Criteria andProblemIsNotNull() {
            addCriterion("problem is not null");
            return (Criteria) this;
        }

        public Criteria andProblemEqualTo(Byte value) {
            addCriterion("problem =", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotEqualTo(Byte value) {
            addCriterion("problem <>", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThan(Byte value) {
            addCriterion("problem >", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThanOrEqualTo(Byte value) {
            addCriterion("problem >=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThan(Byte value) {
            addCriterion("problem <", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThanOrEqualTo(Byte value) {
            addCriterion("problem <=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemIn(List<Byte> values) {
            addCriterion("problem in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotIn(List<Byte> values) {
            addCriterion("problem not in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemBetween(Byte value1, Byte value2) {
            addCriterion("problem between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotBetween(Byte value1, Byte value2) {
            addCriterion("problem not between", value1, value2, "problem");
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