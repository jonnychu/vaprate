package cn.nextop.myapplication.vap.model.config.theme;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import cn.nextop.myapplication.vap.model.render.IPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.AreaPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.BasicPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.TitlePainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.XAxisPainter;
import cn.nextop.myapplication.vap.model.render.impl.painter.YAxisPainter;

/**
 * Created by jonny on 2018/2/12.
 */

public class DefaulTheme {
    // Area
    protected int background1 = Color.rgb(139, 0, 0);
    protected int background2 = Color.rgb(70, 130, 180);
    //
    private final List<IPainter> painters = new ArrayList<>(16);

    /**
     *
     */
    public DefaulTheme() {
        this.painters.add(new AreaPainter());
        this.painters.add(new XAxisPainter());
        this.painters.add(new YAxisPainter());
        this.painters.add(new TitlePainter());
        this.painters.add(new BasicPainter());
    }

    public List<IPainter> getPainters() {
        return this.painters;
    }

    public int getBackground1() {
        return background1;
    }

    public void setBackground1(int background1) {
        this.background1 = background1;
    }

    public int getBackground2() {
        return background2;
    }

    public void setBackground2(int background2) {
        this.background2 = background2;
    }
}
