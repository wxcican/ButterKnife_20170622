package com.fuicuiedu.xc.butterknife_20170622;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //当行复制 ctrl + d
    //当行删除 ctrl + y
    //格式化代码 ctrl + alt + l

    @BindView(R.id.main_tv1)
    TextView textView1;
    @BindView(R.id.main_tv2)
    TextView textView2;
    @BindView(R.id.main_tv3)
    TextView textView3;

    @BindString(R.string.app_name) String app;

    //绑定视图列表
    @BindViews({R.id.main_tv1,R.id.main_tv2,R.id.main_tv3})
    List<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Butterknife绑定！！！
        ButterKnife.bind(this);

        textView1.setText(app);
        textView2.setText(app);
        textView3.setText(app);



        //当绑定到集合中，需要整体发生修改时怎么办？
        //提供了一个apply方法。不过需要实现action或者setter接口。

        //action
        ButterKnife.apply(textViews, new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setText("哈哈哈哈哈哈哈");
            }
        });

        //setter
        ButterKnife.apply(textViews, new ButterKnife.Setter<TextView, String>() {
            @Override
            public void set(@NonNull TextView view, String value, int index) {
                if (index == 2){
                    view.setText(value);
                }
            }
        },"呵呵呵呵呵");


    }
}
