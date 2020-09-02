
package com.pecpaker.leaderboard.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelIQ implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;
    private final static long serialVersionUID = -4401466978302274170L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelIQ() {
    }

    /**
     * 
     * @param score
     * @param country
     * @param badgeUrl
     * @param name
     */
    public ModelIQ(String name, int score, String country, String badgeUrl) {
        super();
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

}
