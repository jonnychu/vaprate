package cn.nextop.myapplication.vap.model.render.impl;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.nextop.myapplication.vap.VapView;
import cn.nextop.myapplication.vap.model.VapModel;
import cn.nextop.myapplication.vap.model.adapter.VapAdapter;
import cn.nextop.myapplication.vap.model.config.theme.DefaulTheme;
import cn.nextop.myapplication.vap.model.render.IPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.AreaPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.TitlePainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.XAxisPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.YAxisPainter;
import cn.nextop.myapplication.vap.support.Rectangle;

/**
 * Created by jonny on 2018/2/12.
 */

public class VapRender {
    protected VapAdapter vapAdapter;
    protected final Map<String, Rectangle> areas;

    /**
     *
     */
    public VapRender(VapAdapter vapAdapter) {
        this.areas = new HashMap<>();
        this.vapAdapter = vapAdapter;
    }

    public Map<String, Rectangle> getAreas() {
        return areas;
    }

    protected List<IPainter> getPainters(VapModel model) {
        DefaulTheme theme = model.getConfig().getTheme();
        List<IPainter> r = theme.getPainters(); Collections.sort(r, IPainter.ASC);
        return r;
    }

    public void render() {
        //
        final VapView view = this.vapAdapter.getVapView();
        final VapModel model = this.vapAdapter.getModel();

        //
        final Canvas canvas = view.getHolder().lockCanvas();
        try {
            if(canvas == null) return;
            List<IPainter> p = getPainters(model); int size = p.size();
            for (int i = 0; i < size; i++) p.get(i).init(this.vapAdapter, canvas);
            for (int i = 0; i < size; i++) p.get(i).draw(this.vapAdapter, canvas);
        }catch (Exception e){
            System.out.printf(e.toString());
        }finally {
            if(canvas != null) this.vapAdapter.getVapView().getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
