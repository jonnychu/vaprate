package cn.nextop.myapplication.vap.model.render;

import android.graphics.Canvas;

import java.util.Comparator;

import cn.nextop.myapplication.vap.model.adapter.VapAdapter;

/**
 * Created by jonny on 2018/2/13.
 */
public interface IPainter {

    int getLayer();

    void init(VapAdapter adapter, Canvas canvas);

    void draw(VapAdapter adapter, Canvas canvas);

    Comparator<IPainter> ASC = new Comparator<IPainter>() {
        @Override
        public int compare(IPainter lhs, IPainter rhs) {
            int v1 = lhs.getLayer(), v2 = rhs.getLayer();
            int r = 0; if (v1 < v2) r = -1; else if (v1 > v2) r = 1; return r;
        }
    };
}
