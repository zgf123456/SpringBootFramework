package com.fastdev.task.frame.model;

public class QuartzJobConfig {
    private Integer id;

    private String jobName;

    private String enable;

    private String className;

    private String cron;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }

    @Override
    public String toString() {
        return "QuartzJobConfig{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", enable='" + enable + '\'' +
                ", className='" + className + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}