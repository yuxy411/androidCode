package com.example.dell.myapplication.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.javaBean.Equipment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/9/5.
 */

public class EquipmentFragment extends Fragment {
    private View view;
    private ListView lv_equ;
    private List<Equipment> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
         view=View.inflate(getActivity(), R.layout.equipment,null);
        lv_equ=view.findViewById(R.id.lv_equ);
        //初始化集合
        list=new ArrayList<Equipment>();
        initData();

        EquipAdapter adapter=new EquipAdapter();
        lv_equ.setAdapter(adapter);
         return view;
    }

    //初始化集合数据
    private void initData() {
        list.add(new Equipment(1,R.drawable.icon_basketball,"篮球","2元/小时"));
        list.add(new Equipment(2,R.drawable.icon_football,"足球","2元/小时"));
        list.add(new Equipment(3,R.drawable.icon_badminton,"羽毛球","1元/小时"));
    }

    /**
     *
     */
    class EquipAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           //1 获取item对应layout的view
            View v=View.inflate(getActivity(),R.layout.item_equipment,null);
            //2 通过view调用findviewbyid获取子视图
            ImageView iv_item_equip=v.findViewById(R.id.iv_item_equip);
            TextView tv_item_name=v.findViewById(R.id.tv_item_name);
            TextView tv_item_price= v.findViewById(R.id.tv_item_price);
            //3.获取指定索引位置的数据，equipment对象
            Equipment equip=list.get(i);
            //4.利用equipment对象给子view设置值
            iv_item_equip.setImageResource(equip.getEicon());
            tv_item_name.setText(equip.getEname());
            tv_item_price.setText(equip.getEprice());
            //5.将最后装配好的子view返回return v
            return v;
        }
    }

}
