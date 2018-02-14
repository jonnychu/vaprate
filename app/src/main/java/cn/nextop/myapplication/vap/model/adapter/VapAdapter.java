package cn.nextop.myapplication.vap.model.adapter;

import android.os.SystemClock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.nextop.myapplication.vap.VapView;
import cn.nextop.myapplication.vap.model.VapModel;
import cn.nextop.myapplication.vap.model.bean.Data;
import cn.nextop.myapplication.vap.model.render.impl.VapRender;
import cn.nextop.myapplication.vap.support.Range;
import cn.nextop.myapplication.vap.support.util.VapUtils;

/**
 * Created by jonny on 2018/2/9.
 */

public class VapAdapter implements Runnable{
    //
    protected VapModel model;
    protected VapView vapView;
    protected VapRender render;
    /**
     *
     */
    public VapAdapter(VapView vapView) {
        this.vapView = vapView;
        this.model = new VapModel();
        this.render = new VapRender(this);
    }

    /**
     *
     */
    public VapModel getModel() {
        return model;
    }

    public VapView getVapView() {
        return vapView;
    }

    public VapRender getRender() {
        return render;
    }

    @Override
    public void run() {
        boolean init = true;
        List<Data> ds = null;
        while (true){
            SystemClock.sleep(50);
            // data
            if(init) {
                ds = new ArrayList<>();
                ds.addAll(VapUtils.random(100.000f, 100000.000f, 119.000f, 124.000f, Data.Side.Buy, 1000));
                ds.addAll(VapUtils.random(10.000f, 100000.000f, 119.000f, 124.000f, Data.Side.Sell, 1000));
                this.model.setDatas(ds); init = false;
            }
            float price = 118.000f + new Random().nextFloat() * (125.000f - 118.000f);
            this.model.setPrice(new BigDecimal(Float.toString(price)));
            final Range[] ranges = VapUtils.getDataRange(ds, this.model.getPrice()); model.setRanges(ranges);
//            System.out.println(ranges[0] + ", " + ranges[1] + " , price = "+model.getPrice());

            // render
            this.render.render();
        }
    }
}
