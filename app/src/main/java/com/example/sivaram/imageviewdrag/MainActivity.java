package com.example.sivaram.imageviewdrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private ViewGroup rootlayout;
    private int x;
    private int y;
    PhotoViewAttacher p;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.iv);
        rootlayout=findViewById(R.id.viewroot);
        RelativeLayout.LayoutParams layoutParams =new RelativeLayout.LayoutParams(150,150);
        imageView.setLayoutParams(layoutParams);
        p=new PhotoViewAttacher(imageView);
        imageView.setOnTouchListener(new ChoiceToughListener());
    }
        private final class ChoiceToughListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event){
            final int X=(int) event.getRawX();
            final int Y=(int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lparams =(RelativeLayout.LayoutParams) view.getLayoutParams();
                    x=X-lparams.leftMargin;
                    y=Y-lparams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin=X-x;
                    layoutParams.topMargin=Y-y;
                    layoutParams.rightMargin=-250;
                    layoutParams.bottomMargin=-250;
                    view.setLayoutParams(layoutParams);
                    break;


            }
            rootlayout.invalidate();
            return true;
        }

    }
}
