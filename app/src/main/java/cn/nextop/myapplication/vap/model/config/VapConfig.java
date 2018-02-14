package cn.nextop.myapplication.vap.model.config;

import cn.nextop.myapplication.vap.model.config.theme.DefaulTheme;

/**
 * Created by jonny on 2018/2/9.
 */

public class VapConfig {
    protected DefaulTheme theme;

    /**
     *
     */
    public VapConfig() {
        this.theme = new DefaulTheme();
    }

    public DefaulTheme getTheme() {
        return theme;
    }

    public void setTheme(DefaulTheme theme) {
        this.theme = theme;
    }
}
