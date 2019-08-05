package com.example.dell.myapplication;


import android.app.Activity;
import android.app.AlertDialog;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.myapplication.fragment.OrderFragment;
import com.example.dell.myapplication.javaBean.game;
import com.example.dell.myapplication.javaBean.game1;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;


public class RaceActivity extends Activity {
    private Button btn_race_1;
    private Button btn_race_2;
    private Button btn_race_3;
    private Button btn_race_4;
    private Button btn_race_5;
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);


    }

    public void basketball(View view) {
        new AlertDialog.Builder(this)
                .setTitle("篮球赛")
                .setMessage("想要加入已有篮球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //发起包场就回到预约界面(实现由Activity跳转到fragment)
//                        FragmentManager fm=getSupportFragmentManager();
//
//                        FragmentTransaction ft=fm.beginTransaction();

                        OrderFragment orderfragment=new OrderFragment();
//
//                        ft.replace(R.id.fl_content,orderfragment);
//
//                        ft.commit();

                       //二、这个是fragment的主方法

                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     //从数据库中的race表中获取races比赛信息
                        Connector.getDatabase();
                        /*
                          需要根据数据库中game表的内容显示数据库
                          查询数据库中game比赛内容
                         */

                        final List<game> games= DataSupport.select("gname","pname","gtime")
                         //   这句话总是导致app闪退
                                           //        .where("id=?","0")
                                                  .find(game.class);
                        int length=games.size();//现在正要进行的比赛、

                        //设置singlealertlog
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items={""};
                        for(int j=0;j<length;j++){
                            gname=games.get(j).getGname();
                            pname=games.get(j).getPname();
                            gtime=games.get(j).getGtime();
                            items[j]=gname+"  "+pname+"  "+gtime;

                        }
                     new AlertDialog.Builder(RaceActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                  Toast.makeText(RaceActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                                  //如果比赛加入成功后，第i个比赛的人数增加
                                      int idd=games.get(i).getGid();
                                      List<game> g=DataSupport.where("gid =?",""+idd)
                                                                .find(game.class);
                                      int number=g.get(0).getNumber();
                                      number++;
                                      //将games.get(i)这场比赛人数+1
                                        games.get(i).setNumber(number);
                                        games.get(i).save();
                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();
                    }
                })
                .show();

    }

    public void football(View view) {
        new AlertDialog.Builder(this)
                .setTitle("足球赛")
                .setMessage("想要加入已有足球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //发起包场就回到预约界面
                        Intent intent=new Intent(RaceActivity.this,OppointActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //从数据库中的race表中获取races比赛信息


                        //注意啦注意啦注意啦
                        Connector.getDatabase();
                        game g=new game();
                        g.setGname("足球比赛二");
                        g.setPname("南足球场");
                        g.setGtime("下午14：00");
                        g.setName("张三");
                        g.setFlag(1);
                        g.setKind(2);
                        g.save();
                        /*
                          需要根据数据库中game表的内容显示数据库
                          查询数据库中game比赛内容
                         */
                        final List<game> games= DataSupport.select("gname","pname","gtime")
//                                                     .where("flag = ? and kind =?","1","2")
                                .find(game.class);
                        int length=games.size();//现在正要进行的比赛、

                        //设置singlealertlog
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items={""};
                        for(int j=0;j<length;j++){
                            gname=games.get(j).getGname();
                            pname=games.get(j).getPname();
                            gtime=games.get(j).getGtime();
                            items[j]=gname+"  "+pname+"  "+gtime;

                        }
                        new AlertDialog.Builder(RaceActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(RaceActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                                        //如果比赛加入成功后，第i个比赛的人数增加
                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.where("gid =?",""+idd)
                                                .find(game.class);
                                        int number=g.get(0).getNumber();
                                        number++;
                                        //将games.get(i)这场比赛人数+1
                                        games.get(i).setNumber(number);
                                        games.get(i).save();
                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();
  }
                })
                .show();

    }

    public void badminton(View view) {
        new AlertDialog.Builder(this)
                .setTitle("羽毛球赛")
                .setMessage("想要加入已有羽毛球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //发起包场就回到预约界面
                        Intent intent=new Intent(RaceActivity.this,OppointActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //从数据库中的race表中获取races比赛信息


                        //注意啦注意啦注意啦
                        Connector.getDatabase();
//                        game g=new game();
//                        g.setGname("篮球比赛二");
//                        g.setPname("北篮球场");
//                        g.setGtime("下午14：00");
//                        g.setName("李斯");
//                        g.setFlag(11);
//
//
//                        g.save();
                        /*
                          需要根据数据库中game表的内容显示数据库
                          查询数据库中game比赛内容
                         */

                        final List<game> games= DataSupport.select("gname","pname","gtime")
                                //   这句话总是导致app闪退
                                //        .where("id=?","0")
                                .find(game.class);
                        int length=games.size();//现在正要进行的比赛、

                        //设置singlealertlog
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items={""};
                        for(int j=0;j<length;j++){
                            gname=games.get(j).getGname();
                            pname=games.get(j).getPname();
                            gtime=games.get(j).getGtime();
                            items[j]=gname+"  "+pname+"  "+gtime;

                        }
                        new AlertDialog.Builder(RaceActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(RaceActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                                        //如果比赛加入成功后，第i个比赛的人数增加
                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.where("gid =?",""+idd)
                                                .find(game.class);
                                        int number=g.get(0).getNumber();
                                        number++;
                                        //将games.get(i)这场比赛人数+1
                                        games.get(i).setNumber(number);
                                        games.get(i).save();
                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();
                    }
                })
                .show();
    }

    public void Tabletennis(View view) {
        new AlertDialog.Builder(this)
                .setTitle("乒乓球赛")
                .setMessage("想要加入已有乒乓球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //发起包场就回到预约界面
                        Intent intent=new Intent(RaceActivity.this,OppointActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //从数据库中的race表中获取races比赛信息


                        //注意啦注意啦注意啦
                        Connector.getDatabase();
//                        game g=new game();
//                        g.setGname("篮球比赛二");
//                        g.setPname("北篮球场");
//                        g.setGtime("下午14：00");
//                        g.setName("李斯");
//                        g.setFlag(11);
//
//
//                        g.save();
                        /*
                          需要根据数据库中game表的内容显示数据库
                          查询数据库中game比赛内容
                         */

                        final List<game> games= DataSupport.select("gname","pname","gtime")
                                //   这句话总是导致app闪退
                                //        .where("id=?","0")
                                .find(game.class);
                        int length=games.size();//现在正要进行的比赛、

                        //设置singlealertlog
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items={""};
                        for(int j=0;j<length;j++){
                            gname=games.get(j).getGname();
                            pname=games.get(j).getPname();
                            gtime=games.get(j).getGtime();
                            items[j]=gname+"  "+pname+"  "+gtime;

                        }
                        new AlertDialog.Builder(RaceActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(RaceActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                                        //如果比赛加入成功后，第i个比赛的人数增加
                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.where("gid =?",""+idd)
                                                .find(game.class);
                                        int number=g.get(0).getNumber();
                                        number++;
                                        //将games.get(i)这场比赛人数+1
                                        games.get(i).setNumber(number);
                                        games.get(i).save();
                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();
                    }
                })
                .show();
    }

    public void swimming(View view) {
        new AlertDialog.Builder(this)
                .setTitle("游泳赛")
                .setMessage("想要加入已有游泳赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //发起包场就回到预约界面
                        Intent intent=new Intent(RaceActivity.this,OppointActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //从数据库中的race表中获取races比赛信息


                        //注意啦注意啦注意啦
                        Connector.getDatabase();
//                        game g=new game();
//                        g.setGname("篮球比赛二");
//                        g.setPname("北篮球场");
//                        g.setGtime("下午14：00");
//                        g.setName("李斯");
//                        g.setFlag(11);
//
//
//                        g.save();
                        /*
                          需要根据数据库中game表的内容显示数据库
                          查询数据库中game比赛内容
                         */

                        final List<game> games= DataSupport.select("gname","pname","gtime")
                                //   这句话总是导致app闪退
                                //        .where("id=?","0")
                                .find(game.class);
                        int length=games.size();//现在正要进行的比赛、

                        //设置singlealertlog
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items={""};
                        for(int j=0;j<length;j++){
                            gname=games.get(j).getGname();
                            pname=games.get(j).getPname();
                            gtime=games.get(j).getGtime();
                            items[j]=gname+"  "+pname+"  "+gtime;

                        }
                        new AlertDialog.Builder(RaceActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(RaceActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                                        //如果比赛加入成功后，第i个比赛的人数增加
                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.where("gid =?",""+idd)
                                                .find(game.class);
                                        int number=g.get(0).getNumber();
                                        number++;
                                        //将games.get(i)这场比赛人数+1
                                        games.get(i).setNumber(number);
                                        games.get(i).save();
                                        dialogInterface.dismiss();
                                    }
                                })
                                .show();
                    }
                })
                .show();
    }
    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("userloginflag", 0);

        if (id == 1 ) {
            mTabHost.setCurrentTab(3);
        }
        super.onResume();
    }
}
