package cn.nextop.myapplication.vap.support.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import cn.nextop.myapplication.vap.model.bean.Data;
import cn.nextop.myapplication.vap.support.Range;
import cn.nextop.myapplication.vap.support.Rectangle;

/**
 * Created by jonny on 2018/2/11.
 */
public class VapUtils {
    //
    protected static Random random = new Random();

    /**
     *
     */
    public static List<Float> getMarkPrice(Range range) {
        final List<Float> r = new ArrayList<>(); if(range == null) return r;
        final String tMax = Float.toString(range.getLower());
        BigDecimal b = new BigDecimal(tMax).setScale(0, RoundingMode.DOWN);
        while (b.floatValue() <= range.getUpper()) {
            if(range.inRange(b.floatValue())) r.add(b.floatValue());
            b = b.add(new BigDecimal("1")).setScale(0, RoundingMode.DOWN);
        }
        return r;
    }

    /**
     *
     */
    public static float getPosition(float value, Rectangle bound, Range range) {
        float length = bound.getHeight();
        float min = range.getLower(), max = range.getUpper();
        return bound.getY() + length - (value - min) / (max - min) * length;
    }

    public static float getLeftPosition(float value, Rectangle bound, Range range) {
        float length = bound.getWidth() / 2f;
        float min = range.getLower(), max = range.getUpper();
        return bound.getX() + length - (value - min) / (max - min) * length;
    }

    public static float getRightPosition(float value, Rectangle bound, Range range) {
        float length = bound.getWidth() / 2f;
        float min = range.getLower(), max = range.getUpper();
        return bound.getX() + (value - min) / (max - min) * length + length;
    }

    /**
     *
     */
    public static Range[] getDataRange(Collection<Data> datas, BigDecimal price) {
        if(datas == null || datas.size() == 0) return null;
        float minX = Float.POSITIVE_INFINITY, minY = Float.POSITIVE_INFINITY;
        float maxX = Float.NEGATIVE_INFINITY, maxY = Float.NEGATIVE_INFINITY;
        for (Data data : datas) {
            float y = data.getPrice().floatValue();
            float x = data.getPosition().floatValue();
            if(minX > x) minX = x; if(maxX < x) maxX = x;
            if(minY > y) minY = y; if(maxY < y) maxY = y;
        }

        //
        final BigDecimal s = new BigDecimal("0.01");
        float scale = new BigDecimal(Float.toString(maxY - minY)).multiply(s).floatValue();
        float sMinY = minY - scale, sMaxY = maxY + scale; float fPrice = price.floatValue();
        //
        if (fPrice < sMinY) {
            sMinY = fPrice - new BigDecimal(Float.toString(maxY - fPrice)).multiply(s).floatValue();
        } else if (fPrice > sMaxY) {
            sMaxY = fPrice + new BigDecimal(Float.toString(fPrice - minY)).multiply(s).floatValue();
        }
        return new Range[] { new Range(0, maxX), new Range(sMinY, sMaxY)};
    }

    /**
     *
     */
    public static List<Data> random(float min1, float max1, float min2, float max2, Data.Side side, int total) {
        List<Data> r = new ArrayList<>();
        for (int i = 0 ; i < total ; i++){
            float f1 = min1 + random.nextFloat() * (max1 - min1);
            float f2 = min2 + random.nextFloat() * (max2 - min2);
            r.add(new Data(new BigDecimal(Float.toString(f1)), new BigDecimal(Float.toString(f2)), side));
        }
        return r;
    }
}
