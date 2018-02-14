package cn.nextop.myapplication.vap.model.render.impl.painter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import cn.nextop.myapplication.vap.model.adapter.VapAdapter;

/**
 * Created by jonny on 2018/2/9.
 */

public class TitlePainter extends AbstractPainter {
    protected Paint paint = new Paint();

    /**
     *
     */
    public TitlePainter() {
        super("title", 2);
    }

    @Override
    protected void doInit(VapAdapter adapter, Canvas canvas) {
    }

    @Override
    protected void doDraw(VapAdapter adapter, Canvas canvas) {
        float hw = bound.getWidth() / 2f, hh = bound.getHeight() / 2f;
        //
        this.paint.setAntiAlias(true); paint.setStrokeWidth(3);
        this.paint.setTypeface(Typeface.DEFAULT_BOLD); this.paint.setColor(Color.WHITE);
        paint.setTextSize(40); final Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        int baseline = ((int)bound.getHeight() + (int)bound.getY() - fontMetrics.bottom - fontMetrics.top) / 2;
        canvas.drawText("Sell", hw / 2f, baseline, paint); canvas.drawText("Buy", hw + hw / 2f, baseline, paint);
    }
}
