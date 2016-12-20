package com.fudan.asuper.circuitmania.ViewManagers;

import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.fudan.asuper.circuitmania.Components.AndGate;
import com.fudan.asuper.circuitmania.Components.Component;
import com.fudan.asuper.circuitmania.Components.InPort;
import com.fudan.asuper.circuitmania.Components.NotGate;
import com.fudan.asuper.circuitmania.Components.OrGate;
import com.fudan.asuper.circuitmania.Components.OutPort;
import com.fudan.asuper.circuitmania.DrawLayout;
import com.fudan.asuper.circuitmania.Judger;
import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.Missions.Mission;
import com.fudan.asuper.circuitmania.R;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by SailW on 2016/9/26.
 */

public class DesignerViewManager extends ViewManager {
    String missionName="ms_1_1";
    Mission mission;
    Component currentComponent, outComp;
    View sltdView;
    int stt;
    AbsoluteLayout canvas;
    public Map<View,Component> mapvc=new HashMap<>();
    public Map<Component,View> mapcv=new HashMap<>();
    InPort inPort;
    OutPort outPort;

    public DesignerViewManager(MainActivity mainActivity, Mission mission) {
        super(mainActivity, R.layout.designer);
        this.mission=mission;
        initCompBox();
        initCanvas();
        inPort=new InPort(mission.standardComponent);
        outPort=new OutPort(mission.standardComponent);
        ((DrawLayout)view.findViewById(R.id.dn_canvas)).designerViewManager=this;
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.dn_back).setOnClickListener(view ->mainActivity.back());
        view.findViewById(R.id.dn_help).setOnClickListener(view ->mainActivity.messageManager.show_text_msg(mission.standardComponent.descriptionID));
        view.findViewById(R.id.dn_remove).setOnClickListener(view->gotoStt(R.integer.dn_stt_remove, view.findViewById(R.id.dn_remove)));
        view.findViewById(R.id.dn_submit).setOnClickListener(view->{
            /*InPort inPort=new InPort(mission.standardComponent);
            OutPort outPort=new OutPort(mission.standardComponent);
            Set<Component> components=new HashSet<Component>();
            NotGate notGate0=new NotGate();
            NotGate notGate1=new NotGate();
            OrGate orGate=new OrGate();
            NotGate notGate=new NotGate();
            notGate0.setPort(R.string.notgate_in,inPort,R.string.andgate_a);
            notGate1.setPort(R.string.notgate_in,inPort,R.string.andgate_b);
            orGate.setPort(R.string.orgate_a,notGate0,R.string.notgate_out);
            orGate.setPort(R.string.orgate_b,notGate1,R.string.notgate_out);
            notGate.setPort(R.string.notgate_in,orGate,R.string.orgate_out);
            outPort.setPort(R.string.andgate_out,notGate,R.string.notgate_out);*/
            Judger judger=new Judger(this.mainActivity,0);
            mainActivity.messageManager.show_judge_msg(judger.judge(mission.standardComponent,inPort,mapcv.keySet(),outPort));
        });
        view.findViewById(R.id.dn_link).setOnClickListener(view->gotoStt(R.integer.dn_stt_link0, view.findViewById(R.id.dn_link)));
    }

    private void gotoStt(int sttid,View v) {
        if(v!=sltdView) {
            stt=sttid;
            select(v);
        } else {
            stt=R.integer.dn_stt_none;
            select(null);
        }
    }

    private void select(View v) {
        if(sltdView!=null)sltdView.setBackgroundColor(mainActivity.res.getColor(R.color.colorNone));
        sltdView=v;
        if(sltdView!=null)sltdView.setBackgroundColor(mainActivity.res.getColor(R.color.colorSltd));
    }

    public boolean _onTouch(View v, MotionEvent event) {
        int eventaction = event.getAction();
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                temp[0] = x - v.getLeft();
                temp[1] = y - v.getTop();
                break;
            case MotionEvent.ACTION_MOVE:
                int l = x - temp[0];
                int t = y - temp[1];
                v.setLayoutParams(new AbsoluteLayout.LayoutParams(
                        AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                        AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                        l, t));
                break;
            case MotionEvent.ACTION_UP:
                if(stt==R.integer.dn_stt_remove) {
                    Component r=mapvc.get(v);
                    mapvc.remove(v);
                    for(Component c:mapvc.values()) {
                        for(Integer pid:c.inputComonent.keySet()) {
                            if(c.inputComonent.get(pid)==r)c.inputComonent.put(pid,null);
                        }
                    }
                    mapcv.remove(r);

                    canvas.removeView(v);
                    gotoStt(R.integer.dn_stt_none,null);
                }
                if(stt==R.integer.dn_stt_link1 && outComp!=mapvc.get(v)) {
                    mainActivity.messageManager.show_port_msg(outComp, mapvc.get(v));
                    gotoStt(R.integer.dn_stt_none,null);
                }
                if(stt==R.integer.dn_stt_link0) {
                    outComp=mapvc.get(v);
                    stt=R.integer.dn_stt_link1;
                }
                break;
        }
        return true;
    }

    int[] temp = new int[] { 0, 0 };
    private void initCanvas() {
        canvas= (AbsoluteLayout) view.findViewById(R.id.dn_canvas);
        canvas.setOnTouchListener((view,event)->{
            int eventaction = event.getAction();
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            switch (eventaction) {
                case MotionEvent.ACTION_DOWN:
                    temp[0] = x;
                    temp[1] = y;
                    if(stt==R.integer.dn_stt_compsltd) {
                        ImageView iv=new ImageView(mainActivity);
                        iv.setImageResource(currentComponent.iconId);
                        iv.setOnTouchListener((v, e) ->{return this._onTouch(v, e);});
                        try {
                            Component component;
                            if(currentComponent instanceof InPort) {
                                component=inPort;
                            } else if(currentComponent instanceof OutPort) {
                                component=outPort;
                            } else {
                                component=currentComponent.getClass().newInstance();
                            }
                            mapvc.put(iv,component);
                            mapcv.put(component,iv);
                        } catch (InstantiationException|IllegalAccessException e) {}
                        //控制摆放初始位置的坐标
                        iv.setLayoutParams(new AbsoluteLayout.LayoutParams(
                                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                                x - canvas.getLeft() - 120,
                                y - canvas.getTop() - 300));
                        canvas.addView(iv);
                        gotoStt(R.integer.dn_stt_none,null);
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    for(int i=0;i<canvas.getChildCount();++i) {
                        View v=canvas.getChildAt(i);
                        v.setLayoutParams(new AbsoluteLayout.LayoutParams(
                                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                                v.getLeft()+x-temp[0],
                                v.getTop()+y-temp[1]));
                        //v.invalidate();
                    }
                    temp[0] = x;
                    temp[1] = y;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return true;
        });
    }

    private void initCompBox() {
        int s=0;
        LinearLayout compBox= (LinearLayout) view.findViewById(R.id.dn_compbox);
        LinearLayout line=null;

        for(Component component:Component.components) {
            if (mainActivity.res.getInteger(component.priorityId)
                    <mainActivity.res.getInteger(mission.standardComponent.priorityId)) {
                if(s==0) {
                    line=new LinearLayout(mainActivity);
                    line.setOrientation(LinearLayout.HORIZONTAL);
                    line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    line.setWeightSum(3);
                    compBox.addView(line);
                }
                ImageView iv=new ImageView(mainActivity);
                iv.setImageResource(component.iconId);
                iv.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,1));
                iv.setOnClickListener(view ->{
                    currentComponent=component;
                    gotoStt(R.integer.dn_stt_compsltd,iv);
                });
                iv.setOnLongClickListener(view->{
                    return false;
                });
                line.addView(iv);
                s=(s+1)%3;
            }
        }
    }
}
