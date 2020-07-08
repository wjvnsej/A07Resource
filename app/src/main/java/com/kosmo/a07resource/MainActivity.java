package com.kosmo.a07resource;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯 가져오기
        TextView textViewCode = (TextView)findViewById(R.id.code_textview);
        ImageView imageViewCode = (ImageView)findViewById(R.id.code_imageview);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        //텍스트뷰에 리소스에서 가져온 값 설정하기
        final Resources resources = getResources();/*
            지역변수를 익명클래스 내부에서 사용하기 위해서는 반드시
            final(상수)로 선언해야 한다. (JAVA규칙)
            아래 버튼의 리스너 내부에서 사용되고 있음
        */
        textViewCode.setText(R.string.code_message); //텍스트 값 설정
        textViewCode.setTextSize(TypedValue.COMPLEX_UNIT_PT, resources.getDimension(R.dimen.dimenXml)); //텍스트 크기 설정
        textViewCode.setTextColor(ContextCompat.getColor(this, R.color.colorXml)); //텍스트 컬러 설정
        //※ XML파일에서 사용하는 속성앞에 set을 붙이면 대부분 설정함수가 존재한다.

        //이미지뷰에 이미지 설정하기
        imageViewCode.setImageResource(R.drawable.grandmother);

        //int형 배열을 출력하는 버튼
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //res의 arrays.xml파일의 내용 중 int_array항목을 가져와서 토스트로 출력
                Toast.makeText(v.getContext(),
                        Arrays.toString(resources.getIntArray(R.array.int_array)),
                        Toast.LENGTH_LONG).show();
            }
        });
        //String형 배열을 출력
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //리소스를 읽어와서 String형 배열에 저장
                String[] idolArr = resources.getStringArray(R.array.str_array);
                //배열에 저장된 내용을 하나의 문자열로 만들어줌
                StringBuffer buf = new StringBuffer();
                for(String idol : idolArr){
                    buf.append(idol + "\r\n");
                }
                Toast.makeText(v.getContext(), buf,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}














