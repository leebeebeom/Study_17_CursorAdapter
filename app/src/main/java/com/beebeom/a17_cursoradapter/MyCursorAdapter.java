package com.beebeom.a17_cursoradapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cursoradapter.widget.CursorAdapter;

import com.bumptech.glide.Glide;

public class MyCursorAdapter extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = view.findViewById(R.id.item_image);
        //각 이미지의 URI 가져오기
        String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        Glide.with(context).load(url).into(imageView);


    }
}
