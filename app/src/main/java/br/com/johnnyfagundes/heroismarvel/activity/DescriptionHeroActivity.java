package br.com.johnnyfagundes.heroismarvel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import br.com.johnnyfagundes.heroismarvel.R;
import br.com.johnnyfagundes.heroismarvel.model.Result;

public class DescriptionHeroActivity extends AppCompatActivity {

    ImageLoader imageLoader = ImageLoader.getInstance();
    private TextView  mTxtHeroName,mTextHeroDescription;
    private ImageView mImageViewHero;
    String url = "";
    Result hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_description_hero);

        mTxtHeroName = findViewById(R.id.txtHeroDescName);
        mTextHeroDescription = findViewById(R.id.txtDescription);
        mImageViewHero = findViewById(R.id.imageHero);

        Bundle data = getIntent().getExtras();
        hero = (Result) data.getSerializable("hero");

        url = hero.getThumbnail().getPath() + "." + hero.getThumbnail().getExtension();
        url = url.replaceAll(":", "s:");

        imageLoader.displayImage(url, mImageViewHero);

        mTxtHeroName.setText(hero.getName());
        mTextHeroDescription.setText(hero.getDescription());

        System.out.println(hero.getDescription());

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}