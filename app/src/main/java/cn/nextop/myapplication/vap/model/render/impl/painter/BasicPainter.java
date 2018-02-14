package cn.nextop.myapplication.vap.model.render.impl.painter;

import android.graphics.Canvas;
import android.graphics.PorterDuff;

import cn.nextop.myapplication.vap.model.adapter.VapAdapter;
import cn.nextop.myapplication.vap.model.render.impl.VapRender;
import cn.nextop.myapplication.vap.support.Rectangle;

/**
 * Created by jonny on 2018/2/13.
 */

public class BasicPainter extends AbstractPainter {
    //
    private float left = 50, bottom = 100, right = 150, top = 100;

    /**
     */
    public BasicPainter() {
        super("basic", 0);
    }

    @Override
    protected void doInit(VapAdapter adapter, Canvas canvas) {
        final VapRender render = adapter.getRender();
        final Rectangle rect = new Rectangle(0, 0, canvas.getWidth(), canvas.getHeight());

        // title
        Rectangle tRect = new Rectangle(rect.getX() + left, rect.getY(), rect.getWidth() - left - right, top);
        // area
        Rectangle aRect = new Rectangle(rect.getX() + left, tRect.getHeight(), tRect.getWidth(), rect.getHeight() - top - bottom);
        // xaxis
        Rectangle xRect = new Rectangle(rect.getX() + left, tRect.getHeight() + aRect.getHeight(), tRect.getWidth(), bottom);
        // yaxis
        Rectangle yRect = new Rectangle(left + aRect.getWidth(), aRect.getY(), right, aRect.getHeight());
        //System.out.println("Rect : "+rect+" , Title : "+tRect+" , Area : "+aRect+" , xaxis"+xRect+" , yaxis"+yRect);

        render.getAreas().clear();
        render.getAreas().put("area", aRect);
        render.getAreas().put("xaxis", xRect);
        render.getAreas().put("yaxis", yRect);
        render.getAreas().put("title", tRect);
    }

    @Override
    protected void doDraw(VapAdapter adapter, Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
}
