package com.example.dell.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.dell.myapplication.R;

import java.util.Calendar;

/**
 * Created by dell on 2018/8/25.
 */

public class BookingDetails extends Fragment {
    protected TextView groundInfo,count;
    protected Button confirm,cancel;
    protected TimePicker startTime,endTime;
    protected Calendar calendar;
    protected double pricePerHour;
    public static BookingDetails newInstance(Bundle bundle){
        BookingDetails bookingDetails = new BookingDetails();
        Bundle args = bundle;
        bookingDetails.setArguments(args);
        return bookingDetails;
    }
    protected void init(View view){
        groundInfo = view.findViewById(R.id.groundInfo);
        count = view.findViewById(R.id.count);
        confirm = view.findViewById(R.id.confirm);
        cancel = view.findViewById(R.id.cancel);
        /*
        * 如果前一个fragment传来了有关场地信息的Bundle，就将传过来的信息设置到场地信息中
        */
        if(getArguments()!=null){
            String info = getArguments().getString("groundInfo");
            groundInfo.setText(info);
        }

        startTime = view.findViewById(R.id.startTime);
        startTime.setIs24HourView(true);
        endTime = view.findViewById(R.id.endTime);
        endTime.setIs24HourView(true);
        calendar = Calendar.getInstance();
        int currentHour,currentMinute;
        currentHour = calendar.get(Calendar.HOUR);
        currentMinute = calendar.get(Calendar.MINUTE);
        startTime.setCurrentHour(currentHour);
        startTime.setCurrentMinute(currentMinute);
        if(currentMinute<30){
            endTime.setCurrentHour(currentHour);
            endTime.setCurrentMinute(currentMinute+30);
        }else{
            endTime.setCurrentHour(currentHour+1);
            endTime.setCurrentMinute(currentMinute-30);
        }

    }
    protected void setListener(){
        Listener listener = new Listener();
        confirm.setOnClickListener(listener);
        cancel.setOnClickListener(listener);
        TimePickerListener timePickerListener = new TimePickerListener();
        startTime.setOnTimeChangedListener(timePickerListener);
        endTime.setOnTimeChangedListener(timePickerListener);
    }
    protected double Count(){
        int start_hour = startTime.getCurrentHour();
        int start_minute = startTime.getCurrentMinute();
        int end_hour = endTime.getCurrentHour();
        int end_minute = endTime.getCurrentMinute();
        if(start_hour>end_hour) {
            /*报错*/
            return -1;
        }else if(start_hour==end_hour&&start_minute>end_minute){
            /*报错*/
            return -1;
        }else{
            return pricePerHour*(end_hour-start_hour)+pricePerHour*(end_minute-start_minute)*1.0/60;
        }

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookingdetails,container,false);
        init(view);
        setListener();
        if(getArguments()!=null){
            String info = getArguments().getString("groundInfo");
            groundInfo.setText(info);
            pricePerHour = (double) getArguments().get("pricePerHour");
        }

        return view;
    }

    /**
     * class Listener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
    switch (v.getId()){
    case R.id.confirm:{

    }
    }
    }
    }

     */
    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.confirm:
                {
                   /** String tempInfo = getArguments().getString("groundInfo");
                    if(tempInfo.charAt(0)=='篮'){
                        tempInfo="篮球场";
                    }else if(tempInfo.charAt(0)=='足'){
                        tempInfo="足球场";
                    }else if(tempInfo.charAt(0)=='羽'){
                        tempInfo="羽毛球场";
                    }
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentDate(new Date());
                    appointment.setAppointmentID("appointmengID");
                    appointment.setAppointmentTimeInMinute(getAppointmentMinute());
                    appointment.setAppointmentType(tempInfo);
                    appointment.setNumberOfPeople(1);
                    appointment.save();
                    //Toast.makeText(getActivity(),"点击确认按钮",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(),"预约信息已保存",Toast.LENGTH_SHORT).show();
                    getFragmentManager().popBackStack();
                    break;
                */
                    FragmentManager fm=getActivity().getSupportFragmentManager();
                    SuccessFragment sussf=new SuccessFragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.addToBackStack(null);
                    ft.replace(R.id.fl_content,sussf);
                    ft.commit();
                    break;
                }
                case R.id.cancel:{

                    Toast.makeText(getActivity(),"点击取消按钮",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }
    class TimePickerListener implements TimePicker.OnTimeChangedListener{

        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            Double tempCount = Count();
            count.setText(tempCount.toString()+"元");
        }
    }
/**
 * class Listener implements View.OnClickListener{

@Override
public void onClick(View v) {
switch (v.getId()){
case R.id.confirm:{
String tempInfo = getArguments().getString("groundInfo");
if(tempInfo.charAt(0)=='篮'){
tempInfo="篮球场";
}else if(tempInfo.charAt(0)=='足'){
tempInfo="足球场";
}else if(tempInfo.charAt(0)=='羽'){
tempInfo="羽毛球场";
}
Appointment appointment = new Appointment();
appointment.setAppointmentDate(new Date());
appointment.setAppointmentID("appointmengID");
appointment.setAppointmentTimeInMinute(getAppointmentMinute());
appointment.setAppointmentType(tempInfo);
appointment.setNumberOfPeople(1);
appointment.save();
//Toast.makeText(getActivity(),"点击确认按钮",Toast.LENGTH_SHORT).show();
Toast.makeText(getActivity(),"预约信息已保存",Toast.LENGTH_SHORT).show();
getFragmentManager().popBackStack();
break;
}
case R.id.cancel:{
getFragmentManager().popBackStack();
//Toast.makeText(getActivity(),"点击取消按钮",Toast.LENGTH_SHORT).show();
break;
}
}
}
}

 */
}
