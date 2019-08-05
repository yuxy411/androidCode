package com.example.dell.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.dell.myapplication.base.BaseFragment;
import com.example.dell.myapplication.fragment.CommunicationFragment;
import com.example.dell.myapplication.fragment.EquipmentFragment;
import com.example.dell.myapplication.fragment.MainFragment;
import com.example.dell.myapplication.fragment.OrderFragment;
import com.example.dell.myapplication.fragment.PersonFragment;
import com.example.dell.myapplication.fragment.RaceFragment;
import com.example.dell.myapplication.javaBean.game;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RadioGroup rg_main;
    private List<BaseFragment> list;
    private int position;
    private Fragment mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化view
        initView();
        //初始化fragement
        initFragment();
        //设置radiogroup的监听
        SetListener();

    }

    /**
     * 设置各个fragment 的监听
     */
    private void SetListener() {
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_main.check(R.id.tb_botton_appoint);

    }

    //比赛栏
    public void Race(View view) {

        //添加比赛的fragment
        RaceFragment rf=new RaceFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fl_content,rf);
        ft.commit();
    }

    //论坛栏页面（暂时让其回调到公告栏页面）
    public void Forum(View view) {
        MainFragment mf=new MainFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fl_content,mf);
        ft.commit();
    }

    //器械栏页面
    public void Equipment(View view) {
        //添加器材的fragment
        EquipmentFragment ef=new EquipmentFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fl_content,ef);
        ft.commit();


    }

  //公告栏事件
    public void Notice(View view) {
        MainFragment mf=new MainFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.fl_content,mf);
        ft.commit();
    }

    /**
     * 点击篮球触发的监听
     * kind=1 篮球   2足球  3羽毛球  4乒乓球  5游泳
     *
     */

    public void basketball(View view)
    {

        new AlertDialog.Builder(this)
                .setTitle("篮球赛")
                .setMessage("想要加入已有篮球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //发起包场就回到预约界面(实现由Activity跳转到fragment)
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        OrderFragment orderfragment=new OrderFragment();
                        ft.replace(R.id.fl_content,orderfragment);
                        ft.commit();


                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                         /**
                          需要根据数据库中game表的内容显示数据库
                          查询数据库中game比赛内容
                         */
                      //   Toast.makeText(MainActivity.this,"加入球赛成功",Toast.LENGTH_SHORT).show();
                        Connector.getDatabase();
                         final List<game> games= DataSupport.findAll(game.class);
                        game g1=new game();
                        g1.setGname("院间联谊赛");
                        g1.setPname("北篮球场一");
                        g1.setGtime("2018-10-10");
                        g1.setKind(1);
                        games.add(g1);
//                        game g2=new game();
//                        g2.setGname("全国大学生篮球赛 山东赛区");
//                        g2.setPname("北篮球场二");
//                        g2.setGtime("2018-10-18");
//                        games.add(g1);
//                        games.add(g2);
                        int length=games.size();//现在正要进行的比赛、

                        //将篮球赛分离出来
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items=new String[length];
                        int j=0;
                        for(game game:games)
                        {
                            if(game.getKind()==1)   //如果是篮球赛，就将该记录添加到字符串数组中
                            {
                                    gname=game.getGname();
                                    pname=game.getPname();
                                    gtime=game.getGtime();
                                    items[j]=gname+"  "+pname+"  "+gtime;
                                    j++;
                            }


                        }
                        if(j==0){
                            //如果没有篮球赛记录就显示提示
                            Toast.makeText(MainActivity.this,"目前还没有篮球赛，亲前去发起吧",Toast.LENGTH_SHORT).show();

                        }

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        /**
                                         * 如果比赛加入成功后，第i个比赛的人数增加
                                         * 如果加入成功后，显示交易费用
                                         */

                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.findAll(game.class);
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


    /**
     * 足球比赛点击事件
     * @param view
     */
    public void football(View view)
    {
        new AlertDialog.Builder(this)
                .setTitle("足球赛")
                .setMessage("想要加入已有足球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //发起包场就回到预约界面(实现由Activity跳转到fragment)
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        OrderFragment orderfragment=new OrderFragment();
                        ft.replace(R.id.fl_content,orderfragment);
                        ft.commit();


                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        /**
                         需要根据数据库中game表的内容显示数据库
                         查询数据库中game比赛内容
                         */
                        //   Toast.makeText(MainActivity.this,"加入球赛成功",Toast.LENGTH_SHORT).show();
                        Connector.getDatabase();
                        final List<game> games= DataSupport.findAll(game.class);
                        game g1=new game();
                        g1.setGname("院间联谊赛");
                        g1.setPname("足球场一");
                        g1.setGtime("2018-10-10");
                        g1.setKind(2);
                        games.add(g1);
                        int length=games.size();//现在正要进行的比赛、

                        //将篮球赛分离出来
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items=new String[length];
                        int j=0;
                        for(game game:games)
                        {
                            if(game.getKind()==2)   //如果是足球赛，就将该记录添加到字符串数组中
                            {
                                gname=game.getGname();
                                pname=game.getPname();
                                gtime=game.getGtime();
                                items[j]=gname+"  "+pname+"  "+gtime;
                                j++;
                            }

                        }
                        if(j==0){
                            //如果没有篮球赛记录就显示提示
                            Toast.makeText(MainActivity.this,"目前还没有足球赛，亲前去发起吧",Toast.LENGTH_SHORT).show();

                        }
//                        if(j==0){   //如果没有篮球赛记录就显示提示
//                            Toast.makeText(MainActivity.this,"目前还没有足球赛，亲前去发起吧",Toast.LENGTH_SHORT).show();
//                        }
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        /**
                                         * 如果比赛加入成功后，第i个比赛的人数增加
                                         * 如果加入成功后，显示交易费用
                                         */

                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.findAll(game.class);
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

    /**
     * 羽毛球比赛点击事件
     * @param view
     */
    public void badminton(View view)
    {
        new AlertDialog.Builder(this)
                .setTitle("羽毛球赛")
                .setMessage("想要加入已有羽毛球赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //发起包场就回到预约界面(实现由Activity跳转到fragment)
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        OrderFragment orderfragment=new OrderFragment();
                        ft.replace(R.id.fl_content,orderfragment);
                        ft.commit();


                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        /**
                         需要根据数据库中game表的内容显示数据库
                         查询数据库中game比赛内容
                         */
                        //   Toast.makeText(MainActivity.this,"加入球赛成功",Toast.LENGTH_SHORT).show();
                        Connector.getDatabase();
                        final List<game> games= DataSupport.findAll(game.class);
                        game g1=new game();
                        g1.setGname("双打赛");
                        g1.setPname("1#羽毛球场");
                        g1.setGtime("2018-10-10");
                        g1.setKind(3);
                        games.add(g1);
                        int length=games.size();//现在正要进行的比赛、

                        //将篮球赛分离出来
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items=new String[length];
                        int j=0;
                        for(game game:games)
                        {
                            if(game.getKind()==3)   //如果是羽毛球赛，就将该记录添加到字符串数组中
                            {
                                gname=game.getGname();
                                pname=game.getPname();
                                gtime=game.getGtime();
                                items[j]=gname+"  "+pname+"  "+gtime;
                                j++;
                            }

                        }
                        if(j==0){   //如果没有篮球赛记录就显示提示
                            Toast.makeText(MainActivity.this,"目前还没有羽毛球赛，亲前去发起吧",Toast.LENGTH_SHORT).show();
                        }
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        /**
                                         * 如果比赛加入成功后，第i个比赛的人数增加
                                         * 如果加入成功后，显示交易费用
                                         */

                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.findAll(game.class);
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

    /**
     * 游泳比赛点击事件
     * @param view
     */
    public void swimming(View view)
    {
        new AlertDialog.Builder(this)
                .setTitle("游泳赛")
                .setMessage("想要加入已有游泳赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //发起包场就回到预约界面(实现由Activity跳转到fragment)
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        OrderFragment orderfragment=new OrderFragment();
                        ft.replace(R.id.fl_content,orderfragment);
                        ft.commit();


                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        /**
                         需要根据数据库中game表的内容显示数据库
                         查询数据库中game比赛内容
                         */
                        //   Toast.makeText(MainActivity.this,"加入球赛成功",Toast.LENGTH_SHORT).show();
                   //     Connector.getDatabase();
                         final List<game> games= DataSupport.findAll(game.class);
                        game g1=new game();
                        g1.setGname("双人比拼赛");
                        g1.setPname("一楼游泳馆");
                        g1.setGtime("2018-10-10");
                        g1.setKind(4);
                        games.add(g1);
                        int length=games.size();//现在正要进行的比赛、

                        //将篮球赛分离出来
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items=new String[length];
                        int j=0;
                        for(game game:games)
                        {
                            if(game.getKind()==4)   //如果是游泳赛，就将该记录添加到字符串数组中
                            {
                                gname=game.getGname();
                                pname=game.getPname();
                                gtime=game.getGtime();
                                items[j]=gname+"  "+pname+"  "+gtime;
                                j++;
                            }

                        }
                        if(j==0){   //如果没有篮球赛记录就显示提示
                            Toast.makeText(MainActivity.this,"目前还没有游泳赛，亲前去发起吧",Toast.LENGTH_SHORT).show();
                        }
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        /**
                                         * 如果比赛加入成功后，第i个比赛的人数增加
                                         * 如果加入成功后，显示交易费用
                                         */

                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.findAll(game.class);
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
    /**
     * 乒乓球比赛点击事件
     * @param view
     */
    public void pingpang(View view)
    {
        new AlertDialog.Builder(this)
                .setTitle("乒乓球赛")
                .setMessage("想要加入已有乒乓赛还是发起包场？")
                .setPositiveButton("发起包场", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //发起包场就回到预约界面(实现由Activity跳转到fragment)
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        OrderFragment orderfragment=new OrderFragment();
                        ft.replace(R.id.fl_content,orderfragment);
                        ft.commit();


                    }
                })
                .setNegativeButton("加入球赛", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        /**
                         需要根据数据库中game表的内容显示数据库
                         查询数据库中game比赛内容
                         */
                        //   Toast.makeText(MainActivity.this,"加入球赛成功",Toast.LENGTH_SHORT).show();
                        Connector.getDatabase();
                        final List<game> games= DataSupport.findAll(game.class);
                        game g1=new game();
                        g1.setGname("单打赛");
                        g1.setPname("2#乒乓球赛");
                        g1.setGtime("2018-10-10");
                        g1.setKind(5);
                        games.add(g1);
                        int length=games.size();//现在正要进行的比赛、

                        //将篮球赛分离出来
                        String gname=null;
                        String pname=null;
                        String gtime=null;
                        String str=null;
                        final String[] items=new String[length];
                        int j=0;
                        for(game game:games)
                        {
                            if(game.getKind()==5)   //如果是乒乓球赛，就将该记录添加到字符串数组中
                            {
                                gname=game.getGname();
                                pname=game.getPname();
                                gtime=game.getGtime();
                                items[j]=gname+"  "+pname+"  "+gtime;
                                j++;
                            }

                        }
                        if(j==0){   //如果没有篮球赛记录就显示提示
                            Toast.makeText(MainActivity.this,"目前还没有乒乓球赛，亲前去发起吧",Toast.LENGTH_SHORT).show();
                        }
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("请选择比赛：")
                                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        /**
                                         * 如果比赛加入成功后，第i个比赛的人数增加
                                         * 如果加入成功后，显示交易费用
                                         */

                                        int idd=games.get(i).getGid();
                                        List<game> g=DataSupport.findAll(game.class);
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



    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {


        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.tb_botton_appoint:
                    position=0;break;
                case R.id.tb_botton_appoint2:
                    position=1;break;
                case R.id.tb_botton_appoint3:
                    position=2;break;
                case R.id.tb_botton_appoint4:
                    position=3;break;
                default:position=0;

            }
            //根据位置得到是哪个fragment  （主页，社交 预约  个人中心）
            Fragment to=getFragment();
            //替换（从本fragment转换到目的fragment）
            switchFragment(mcontext,to);
        }

        private void switchFragment(Fragment from, Fragment to) {
            if(from!=to){
                mcontext=to;//给from做好标记
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                //才替换
                //判断to是否被添加
                if(!to.isAdded()){
                    //to没有被添加过
                    //如果from不为空，就隐藏from
                    if(from!=null)
                    {
                        ft.hide(from);
                    }
                    //添加to
                    if(to!=null){
                        ft.add(R.id.fl_content, to).commit();
                    }
                }else{
                    //to被添加过
                    //如果from不为空，就隐藏from
                    if(from!=null)
                    {
                        ft.hide(from);
                    }
                    //显示to
                    if(to!=null){
                        ft.show(to).commit();
                    }
                }
            }

        }
    }

    private Fragment getFragment() {
        return 	list.get(position);

    }
    /**
     * 初始化fragment
     */
    private void initFragment() {
        list=new ArrayList<BaseFragment>();
        list.add(new MainFragment());
        list.add(new OrderFragment());
        list.add(new CommunicationFragment());
        list.add(new PersonFragment());
    }

    /**
     * 初始化视图（默认打开首页）
     */
    private void initView() {
        rg_main=(RadioGroup) findViewById(R.id.rg_main);

    }


}

