package cn.nextop.myapplication.vap.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.nextop.myapplication.vap.model.bean.Data;
import cn.nextop.myapplication.vap.model.config.VapConfig;
import cn.nextop.myapplication.vap.support.Range;

/**
 * Created by jonny on 2018/2/9.
 */
public class VapModel {
    //
    protected Range[] ranges;
    protected Short symbolId;
    protected BigDecimal price;
    protected List<Data> datas;
    //
    protected VapConfig config;

    /**
     *
     */

    public VapModel() {
        this.config = new VapConfig();
    }

    /**
     *
     */
    public Range getXRange() {
        return ranges[0];
    }

    public Range getYRange() {
        return ranges[1];
    }

    public Range[] getRanges() {
        return ranges;
    }

    public void setRanges(Range[] ranges) {
        this.ranges = ranges;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    public Short getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(Short symbolId) {
        this.symbolId = symbolId;
    }

    public VapConfig getConfig() {
        return config;
    }

    public void setConfig(VapConfig config) {
        this.config = config;
    }
}
