
package br.com.johnnyfagundes.heroismarvel.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Heroi implements Serializable {

    @SerializedName("code")
    private Integer code;

    @SerializedName("status")
    private String status;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("attributionText")
    private String attributionText;

    @SerializedName("attributionHTML")
    private String attributionHTML;

    @SerializedName("etag")
    private String etag;

    @SerializedName("data")
    private Data data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
