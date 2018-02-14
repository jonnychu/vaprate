package cn.nextop.myapplication.vap.model.render.impl.painter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import cn.nextop.myapplication.vap.model.VapModel;
import cn.nextop.myapplication.vap.model.adapter.VapAdapter;
import cn.nextop.myapplication.vap.model.bean.Data;
import cn.nextop.myapplication.vap.model.config.VapConfig;
import cn.nextop.myapplication.vap.model.config.theme.DefaulTheme;
import cn.nextop.myapplication.vap.support.Range;
import cn.nextop.myapplication.vap.support.util.VapUtils;

/**
 * Created by jonny on 2018/2/6.
 */
public class AreaPainter extends AbstractPainter {
    protected Paint paint = new Paint();
    protected Paint paint1 = new Paint();
    protected Paint paint2 = new Paint();
    protected Paint paint3 = new Paint();

    /**
     *
     */
    public AreaPainter() {
        super("area", 1);
    }

    @Override
    protected void doInit(VapAdapter adapter, Canvas canvas) {
        final VapModel model = adapter.getModel();
        final VapConfig config = model.getConfig();
        final DefaulTheme theme = config.getTheme();
        //
        paint.setStrokeWidth(2);
        paint2.setStyle(Paint.Style.FILL);
        paint3.setStrokeWidth(1); paint3.setColor(Color.BLACK);
        paint1.setStrokeWidth(3); paint1.setColor(Color.WHITE); paint1.setTextSize(30);
    }

    @Override
    protected void doDraw(VapAdapter adapter, Canvas canvas) {
        final VapModel model = adapter.getModel();
        final VapConfig config = model.getConfig();
        final DefaulTheme theme = config.getTheme();
        final Range xRange = model.getXRange(), yRange = model.getYRange();
        final List<Data> datas = model.getDatas(); if (datas == null || datas.size() == 0) return;

        //  variable
        final String text = String.valueOf(model.getPrice());
        float cx = bound.getX() + bound.getWidth() / 2f; // center x
        float cy = VapUtils.getPosition(model.getPrice().floatValue(), this.bound, yRange); // current y

        // background 1 , 4
        paint2.setColor(theme.getBackground1());
        canvas.drawRect(bound.getX(), bound.getY(), cx, cy, paint2);
        canvas.drawRect(cx, cy, bound.getX() + bound.getWidth(), bound.getY() + bound.getHeight(), paint2);
        // background 2 , 3
        paint2.setColor(theme.getBackground2());
        canvas.drawRect(cx, bound.getY(), bound.getX() + bound.getWidth(), cy, paint2);
        canvas.drawRect(bound.getX(), cy, cx, bound.getY() + bound.getHeight(), paint2);

        // sell position
        for (Data data: datas) {
            float y = VapUtils.getPosition(data.getPrice().floatValue(), bound, yRange);
            if (data.getSide() == Data.Side.Buy) {
                float x2 = VapUtils.getRightPosition(data.getPosition().floatValue(), bound, xRange);
                paint.setColor(Color.rgb(255,0,0)); canvas.drawLine(x2,y,cx,y,paint);
            } else {
                float x1 = VapUtils.getLeftPosition(data.getPosition().floatValue(), bound, xRange);
                paint.setColor(Color.rgb(65,105,225)); canvas.drawLine(x1,y,cx,y,paint);
            }
        }

        // current price & position
        canvas.drawText(text, bound.getX() + bound.getWidth() + 10, cy + 8, paint1);
        canvas.drawLine(bound.getX(), cy, bound.getX() + bound.getWidth() + 10, cy, paint1);

        // x center line ?
        canvas.drawLine(cx, bound.getY(), cx, bound.getY() + bound.getHeight(), paint3);
    }
}
