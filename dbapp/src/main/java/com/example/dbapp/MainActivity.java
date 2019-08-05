package com.example.dbapp;

import android.app.Activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import org.litepal.tablemanager.Connector;

import java.util.List;


public class MainActivity extends Activity {
    private ListView lv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//
//        //create book
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Connector.getDatabase();
//            }
//        });
//
//        //insert book
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Book book=new Book();
//                book.setName("第一行代码");
//                book.setAuthor("郭霖");
//                book.setPages(1000);
//                book.setPrice(59.90);
//                book.save();
//                book.setName("Second");
//                book.save();
//            }
//        });
//
//        //update book
//        button_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Book book=new Book();
//                book.setPrice(10);   //这是更新内容
//                book.setName("First");
//                book.updateAll("name=?","第一行代码");  //这是更新条件
//            }
//        });
//
//        //select book
//        button_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               List<Book> books=DataSupport.select("name","price")
//                                           .where("price>?","50")
//                                           .find(Book.class);
//               Book book=books.get(0);
//                   Toast.makeText(MainActivity.this, "这本书的名字:"+book.getName(), Toast.LENGTH_SHORT).show();
//                   Toast.makeText(MainActivity.this, "这本书的价格:"+book.getPrice(), Toast.LENGTH_SHORT).show();               }
//
//        });

//        tv=findViewById(R.id.tv);
//   //   SQLiteDatabase database=Connector.getDatabase();
//        News news=new News();
//        news.setId(1);
//        news.setTitle("标题");
//        news.setCommentCount(0007);
//        news.save();
//        News list=DataSupport.find(News.class,1);
////        for(News item:list){
//           tv.setText(news.getTitle());
//           Toast.makeText(this,news.getTitle(),Toast.LENGTH_SHORT).show();
//        //}







//        lv=findViewById(R.id.lv);
//        String[] data={"1","2","3","4"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item,data);
//
////   这句话导致闪退
//        lv.setAdapter(adapter);
        /**
         * 从数据库中获取数据（采用litepal框架）
         */

    }

  /**  public void db(View view) {

        dbHelper dbhelper=new dbHelper(this,1);
        SQLiteDatabase database=dbhelper.getReadableDatabase();
        String sql="insert into user(id,name) values(9,'Tom')";
        database.execSQL(sql);
        database.close();
        Toast.makeText(this,"创建和插入成功",Toast.LENGTH_SHORT).show();
    }
   */
 /** public void click(View view) {
      Connector.getDatabase();
      User user=new User();
      user.setId(1);
      user.setName("张三");
      user.save();
  }
  */
}
