package com.fudan.asuper.circuitmania;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsoluteLayout;

import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.ViewManagers.DesignerViewManager;

/**
 * Created by SailW on 2016/11/3.
 */

public class DrawLayout extends AbsoluteLayout {
    public DesignerViewManager designerViewManager=null;

    public DrawLayout(Context context) {
        super(context);
        this.setWillNotDraw(false);
    }

    public DrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setWillNotDraw(false);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(designerViewManager==null)return;
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(10);
        for(Component component:designerViewManager.mapvc.values()) {
            View v0=designerViewManager.mapcv.get(component);
            for(Component inp:component.inputComonent.values()) {
                View v1=designerViewManager.mapcv.get(inp);
                if(v0!=null && v1!=null)
                    canvas.drawLine(v0.getX(), v0.getY()+v0.getHeight()/2, v1.getX()+v1.getWidth(), v1.getY()+v1.getHeight()/2, p);
            }
        }
    }
}
