package com.beebeom.a17_cursoradapter;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //런타임 권한 체크 구현 안함
        //타겟 SDK 22로 낮춤

        GridView gridView = findViewById(R.id.gridView);
        //커서 객체로 이미지 URI 가져오기
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                MediaStore.Images.Media.DATE_TAKEN + " DESC");
        MyCursorAdapter adapter = new MyCursorAdapter(this, cursor, false);
        gridView.setAdapter(adapter);

    }

}
