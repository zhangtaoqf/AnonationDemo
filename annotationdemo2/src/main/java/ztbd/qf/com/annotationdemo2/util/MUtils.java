package ztbd.qf.com.annotationdemo2.util;

import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ztbd.qf.com.annotationdemo2.MainActivity;
import ztbd.qf.com.annotationdemo2.annotation.MField;
import ztbd.qf.com.annotationdemo2.annotation.MMethod;
/**
 * Created by Administrator on 2016/7/17.
 */
public class MUtils {

    private MainActivity activity;

    private static MUtils mUtils;

    private MUtils(MainActivity activity){
        this.activity = activity;
        initAc();
    }

    public void initAc()
    {
        Class<? extends MainActivity> aClass = activity.getClass();

        final Field[] declaredFields = aClass.getDeclaredFields();

        //获取属性

        for (Field declaredField : declaredFields) {
            MField annotationField = declaredField.getAnnotation(MField.class);
            if(annotationField!=null)
            {
                int id = annotationField.id();

                View view = activity.findViewById(id);

                if(view!=null)
                {
                    declaredField.setAccessible(true);

                    if(declaredField.getType() == TextView.class)
                    {
                        try {
                            //设置值
                            declaredField.set(activity,(TextView)view);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
        Method[] declaredMethods = aClass.getDeclaredMethods();

        for (final Method declaredMethod : declaredMethods) {
            MMethod annotationMethod = declaredMethod.getAnnotation(MMethod.class);
            if(annotationMethod!=null)
            {
                int id = annotationMethod.id();
                //设置可访问
                declaredMethod.setAccessible(true);

                activity.findViewById(id).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            /**
                             * 参数一：方法所属的类的对象
                             * 参数二：方法的执行需要的参数
                             */
                            declaredMethod.invoke(activity,v);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        }
    }

    public static MUtils init(MainActivity activity)
    {
        if(mUtils==null)
        {
            mUtils = new MUtils(activity);
        }
        return mUtils;
    }


}
