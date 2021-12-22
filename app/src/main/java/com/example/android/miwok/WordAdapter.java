package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> Word, int colorResourceId) {
        super(context, colorResourceId, Word);
        mColorResourceId = colorResourceId;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View ListItemView = convertView;
        if (ListItemView == null) {
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Word currentWord = getItem(position);

        TextView MiwokTextView = ListItemView.findViewById(R.id.miwok_text_view);
        MiwokTextView.setText(currentWord.getmMiwokTranslation());

        TextView DefaultTextView = ListItemView.findViewById(R.id.default_text_view);
        DefaultTextView.setText(currentWord.getmDefaultTranslation());


        ImageView ImageView = ListItemView.findViewById(R.id.imageView);

        if (currentWord.hasImage()) {
            ImageView.setImageResource(currentWord.getmImageResourceId());
        } else
            ImageView.setVisibility(View.GONE);


        View textContainer = ListItemView.findViewById(R.id.text_container);
        int Color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(Color);
        return ListItemView;


    }


}
