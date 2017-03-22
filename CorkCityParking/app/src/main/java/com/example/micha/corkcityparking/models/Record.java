
package com.example.micha.corkcityparking.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;

@Generated("org.jsonschema2pojo")
public class Record {

    @SerializedName("opening_times")
    @Expose
    private String openingTimes;
    @SerializedName("identifier")
    @Expose
    private Integer identifier;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("spaces")
    @Expose
    private Integer spaces;
    @SerializedName("free_spaces")
    @Expose
    private Integer freeSpaces;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("_id")
    @Expose
    private Integer id;

    /**
     * 
     * @return
     *     The openingTimes
     */
    public String getOpeningTimes() {
        return openingTimes;
    }

    /**
     * 
     * @param openingTimes
     *     The opening_times
     */
    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }

    /**
     * 
     * @return
     *     The identifier
     */
    public Integer getIdentifier() {
        return identifier;
    }

    /**
     * 
     * @param identifier
     *     The identifier
     */
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 
     * @param notes
     *     The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The spaces
     */
    public Integer getSpaces() {
        return spaces;
    }

    /**
     * 
     * @param spaces
     *     The spaces
     */
    public void setSpaces(Integer spaces) {
        this.spaces = spaces;
    }

    /**
     * 
     * @return
     *     The freeSpaces
     */
    public Integer getFreeSpaces() {
        return freeSpaces;
    }

    /**
     * 
     * @param freeSpaces
     *     The free_spaces
     */
    public void setFreeSpaces(Integer freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
