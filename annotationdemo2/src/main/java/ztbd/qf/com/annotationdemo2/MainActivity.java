package ztbd.qf.com.annotationdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ztbd.qf.com.annotationdemo2.annotation.MField;
import ztbd.qf.com.annotationdemo2.annotation.MMethod;
import ztbd.qf.com.annotationdemo2.util.MUtils;

/**
 * 反射+注解写了一个框架
 *  1.注入控件和事件方法的
 */
public class MainActivity extends AppCompatActivity {
    @MField(id = R.id.textViewId)
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MUtils.init(this);
        textView.setText("小宝");
    }
    @MMethod(id = R.id.textViewId)
    private void textViewOnClick(View view)
    {
        Toast.makeText(MainActivity.this, "点击了我的按钮", Toast.LENGTH_SHORT).show();
    }

}
