package cn.nextop.myapplication.vap;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import cn.nextop.myapplication.vap.model.adapter.VapAdapter;
import cn.nextop.myapplication.vap.support.Rectangle;

/**
 * Created by jonny on 2018/2/6.
 */

public class VapView extends SurfaceView implements SurfaceHolder.Callback {
    //
    protected VapAdapter adapter;
    protected SurfaceHolder holder;

    /**
     *
     */
    public VapView(Context context) {
        super(context); init();
    }

    public VapView(Context context, AttributeSet attrs) {
        super(context, attrs); init();
    }

    public VapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr); init();
    }

    protected void init() {
        this.adapter = new VapAdapter(this);
        (this.holder = getHolder()).addCallback(this);
        this.holder.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        new Thread(this.adapter).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
