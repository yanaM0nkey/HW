package com.gmail.ioanna.myandroidapp.dz3;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.ioanna.myandroidapp.BuildConfig;
import com.gmail.ioanna.myandroidapp.R;
import com.squareup.picasso.Picasso;

public class Dz3Activity extends Activity {
    public static final String LINK = "http://minionomaniya.ru/wp-content/uploads/2015/09/%D0%9A%D0%B0%D1%80%D1%82%D0%B8%D0%BD%D0%BA%D0%B8-%D0%BC%D0%B8%D0%BD%D1%8C%D0%BE%D0%BD%D0%BE%D0%B2.jpg";
    private Button downloadButton;
    private EditText link;
    private ImageView imageView;
    private TextView text;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz3);

        downloadButton = (Button)findViewById(R.id.download_button);
        imageView = (ImageView)findViewById(R.id.dz3_image);
        link = findViewById(R.id.editText);
        link.setText(LINK);
        text = findViewById(R.id.dz3_textView);

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(Dz3Activity.this).load(link.getText().toString()).transform(new CircularTransformation(900)).into(imageView);
                text.setText(BuildConfig.API_ENDPOINT);
            }
        });
    }
}
