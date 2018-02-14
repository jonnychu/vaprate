package cn.nextop.myapplication.vap.model.render.impl.painter;

import android.graphics.Canvas;

import java.util.Map;

import cn.nextop.myapplication.vap.model.adapter.VapAdapter;
import cn.nextop.myapplication.vap.model.render.IPainter;
import cn.nextop.myapplication.vap.model.render.impl.VapRender;
import cn.nextop.myapplication.vap.support.Rectangle;

/**
 * Created by jonny on 2018/2/13.
 */
public class AbstractPainter implements IPainter {
    //
    protected Rectangle bound;
    protected final int layer;
    protected final String name;

    /**
     *
     */
    public AbstractPainter(String name, int layer) {
        this.name = name; this.layer = layer;
    }

    /**
     *
     */
    public int getLayer() { return layer; }

    public String getName() { return name; }

    //
    protected void doInit(VapAdapter adapter, Canvas canvas) {}
    protected void doDraw(VapAdapter adapter, Canvas canvas) {}

    @Override
    public void init(final VapAdapter adapter, Canvas canvas) {
        final VapRender render = adapter.getRender();
        Map<String, Rectangle> areas = render.getAreas();
        this.bound = areas.get(getName()); doInit(adapter, canvas);
    }

    @Override
    public void draw(final VapAdapter adapter, Canvas canvas) {
        doDraw(adapter, canvas);
    }
}
