package cn.nextop.myapplication.vap.model.render.impl.painter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import cn.nextop.myapplication.vap.model.VapModel;
import cn.nextop.myapplication.vap.model.adapter.VapAdapter;
import cn.nextop.myapplication.vap.support.util.VapUtils;

/**
 * Created by jonny on 2018/2/6.
 */
public class YAxisPainter extends AbstractPainter {
    //
    protected Paint paint = new Paint();

    /**
     *
     */
    public YAxisPainter() {
        super("yaxis", 4);
    }

    @Override
    protected void doInit(VapAdapter adapter, Canvas canvas) {
        //
        paint.setTextSize(30); paint.setStrokeWidth(1); paint.setColor(Color.WHITE);
    }

    @Override
    protected void doDraw(VapAdapter adapter, Canvas canvas) {
        final VapModel model = adapter.getModel();

        //
        List<Float> marks = VapUtils.getMarkPrice(model.getYRange());
        for (Float f : marks) {
            float x = bound.getX();
            float y = VapUtils.getPosition(f, bound, model.getYRange());
            canvas.drawLine(x, y, x + 6, y, paint); canvas.drawText(String.valueOf(f), x + 6 + 4, y + 8, paint);
        }
    }
}
