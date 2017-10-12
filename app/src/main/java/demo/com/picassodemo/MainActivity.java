package demo.com.picassodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.img);
        //Load from asset
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(MainActivity.this).load("file:///android_asset/rose.jpg").into(imageView);
            }
        });
        //Load from network
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(MainActivity.this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
            }
        });
        //Load image with resize
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(MainActivity.this)
                        .load("http://i.imgur.com/DvpvklR.png")
                        .resize(50, 50)
                        .centerCrop()
                        .into(imageView);
            }
        });
        //With holder and error
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(MainActivity.this)
                        .load("https://phunudep.com/wp-content/uploads/2016/01/nhung-hinh-anh-hoa-anh-tuc-cuc-dep-so-8.jpg")
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.error)
                        .into(imageView);
            }
        });
    }
}
