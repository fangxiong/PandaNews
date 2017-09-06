package com.fx.pandanews.bean;

import java.util.List;

/**
 * Created by fangxiong on 2017/8/30.
 */
public class GirlData {

    private boolean isError;
    private List<PhotoGirl> results;

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public void setResults(List<PhotoGirl> results) {
        this.results = results;
    }

    public List<PhotoGirl> getResults() {
        return results;
    }
}
