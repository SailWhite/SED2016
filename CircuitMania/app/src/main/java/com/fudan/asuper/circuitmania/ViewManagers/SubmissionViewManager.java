package com.fudan.asuper.circuitmania.ViewManagers;

import com.fudan.asuper.circuitmania.Components.*;
import com.fudan.asuper.circuitmania.MainActivity;
import com.fudan.asuper.circuitmania.Missions.Mission;
import com.fudan.asuper.circuitmania.R;

/**
 * Created by SailW on 2016/9/26.
 */

public class SubmissionViewManager extends ViewManager {
    public SubmissionViewManager(MainActivity mainActivity) {
        super(mainActivity, R.layout.submission_selecting);
        System.out.println("level:"+mainActivity.state.level);
        setColor();
    }

    public void setColor() {
        System.out.println(mainActivity.state.level);
        view.findViewById(R.id.sms_1_1).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new NorGate().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_1).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new NorGate().priorityId));
        view.findViewById(R.id.sms_1_2).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new AndGate().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_2).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new AndGate().priorityId));
        view.findViewById(R.id.sms_1_3).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new NandGate().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_3).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new NandGate().priorityId));
        view.findViewById(R.id.sms_1_4).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new XorGate().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_4).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new XorGate().priorityId));
        view.findViewById(R.id.sms_1_5).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new XnorGate().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_5).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new XnorGate().priorityId));
        view.findViewById(R.id.sms_1_6).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new Mux1_2().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_6).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new Mux1_2().priorityId));
        view.findViewById(R.id.sms_1_7).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new FullAdder().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_7).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new FullAdder().priorityId));
        view.findViewById(R.id.sms_1_8).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new Enc2_4().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_8).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new Enc2_4().priorityId));
        view.findViewById(R.id.sms_1_9).setBackgroundColor(
                mainActivity.res.getColor(mainActivity.state.level<mainActivity.res.getInteger(new Dec2_4().priorityId)?R.color.colorSltd:R.color.colorNone));
        view.findViewById(R.id.sms_1_9).setClickable(mainActivity.state.level>=mainActivity.res.getInteger(new Dec2_4().priorityId));
    }

    @Override
    public void initFunc() {
        view.findViewById(R.id.sms_back).setOnClickListener(view ->mainActivity.back());
        view.findViewById(R.id.sms_1_1).setOnClickListener(view -> {
            Mission mission=new Mission(new NorGate(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.norgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_2).setOnClickListener(view -> {
            Mission mission=new Mission(new AndGate(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.andgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_3).setOnClickListener(view -> {
            Mission mission=new Mission(new NandGate(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.nandgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_4).setOnClickListener(view -> {
            Mission mission=new Mission(new XorGate(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.xorgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_5).setOnClickListener(view -> {
            Mission mission=new Mission(new XnorGate(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.xnorgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_6).setOnClickListener(view -> {
            Mission mission=new Mission(new Mux1_2(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.mux_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_7).setOnClickListener(view -> {
            Mission mission=new Mission(new FullAdder(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.fulladder_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_8).setOnClickListener(view -> {
            Mission mission=new Mission(new Enc2_4(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.enc_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
        view.findViewById(R.id.sms_1_9).setOnClickListener(view -> {
            Mission mission=new Mission(new Dec2_4(), null);
            mission.circuit=mainActivity.state.circuits.get(R.string.andgate_desc);
            mainActivity.designerViewManager=new DesignerViewManager(mainActivity,mission);
            mainActivity.changeView(mainActivity.designerViewManager.view);
        });
    }
}
