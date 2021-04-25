
package br.com.johnnyfagundes.heroismarvel.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable {

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    @SerializedName("total")
    private Integer total;

    @SerializedName("count")
    private Integer count;

    @SerializedName("results")
    private List<Result> results = null;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
