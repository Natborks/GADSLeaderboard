package com.example.gadsleaderboard.models;

public class SkillLeader {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberOfLearningHours() {
        return numberOfLearningHours;
    }

    public void setNumberOfLearningHours(String numberOfLearningHours) {
        this.numberOfLearningHours = numberOfLearningHours;
    }

    String country;
    String numberOfLearningHours;

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    String badgeUrl;
}
