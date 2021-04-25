package br.com.johnnyfagundes.heroismarvel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import br.com.johnnyfagundes.heroismarvel.R;
import br.com.johnnyfagundes.heroismarvel.adapter.HeroAdapter;

import br.com.johnnyfagundes.heroismarvel.model.Heroi;
import br.com.johnnyfagundes.heroismarvel.model.Result;
import br.com.johnnyfagundes.heroismarvel.utils.RecyclerItemClickListener;
import br.com.johnnyfagundes.heroismarvel.utils.api.HeroesApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecvHeroes;
    private EditText mEdtSearchHeroByName;

    private List<Result> mheroList = new ArrayList<>();
    private Retrofit retrofit;
    private String heroName = "";
    private int offSet = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));

        getHeroes();

        mRecvHeroes = findViewById(R.id.recycler_herois);
        mEdtSearchHeroByName = findViewById(R.id.edtSearchHero);

        mEdtSearchHeroByName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                heroName = mEdtSearchHeroByName.getText().toString();
                getHeroByName();
            }

            @Override
            public void afterTextChanged(Editable s) {
                heroName = mEdtSearchHeroByName.getText().toString();
                getHeroByName();
            }
        });


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecvHeroes.setLayoutManager(layoutManager);
        mRecvHeroes.setHasFixedSize(true);

        mRecvHeroes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        mRecvHeroes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Result hero = mheroList.get(position);
                                Intent intent = new Intent(getApplicationContext(), DescriptionHeroActivity.class);
                                intent.putExtra("hero", hero);
                                startActivity(intent);

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }


    public void onClickGoBack(View view){
        if (offSet <= 0){
            System.out.println("Offset no seu limite de volta");
        } else {
            offSet -= 4;
            System.out.println(offSet);
        }
        getHeroes();
    }

    public void onClickGoFoward(View view){
        offSet += 4;
        System.out.println(offSet);
        getHeroes();
    }



    public void getHeroes() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HeroesApi heroes = retrofit.create(HeroesApi.class);
        Call<Heroi> mCall = heroes.getHeroes(offSet);

        mCall.enqueue(new Callback<Heroi>() {
            @Override
            public void onResponse(Call<Heroi> call, Response<Heroi> response) {
                if (response.isSuccessful()) {
                    mheroList = response.body().getData().getResults();
                    for (int i = 0; i < mheroList.size(); i++) {
                        System.out.println(mheroList.get(i).getName());
                    }
                    HeroAdapter adapter = new HeroAdapter(mheroList);
                    mRecvHeroes.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Heroi> call, Throwable t) {
                System.out.println("error");
            }
        });
    }

    public void getHeroByName() {
        String key = "1fde12d08f30e71aba6111275fa8b100";
        String hash = "388aa90472ef77ebbdfce146b9a61e0e";
        String api = "https://gateway.marvel.com/v1/public/characters?ts=thesoer&";
        String ts = "thesoer";

        retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HeroesApi heroes = retrofit.create(HeroesApi.class);
        Call<Heroi> mCall = heroes.getHeroesByName(heroName, ts, key, hash, 4);

        mCall.enqueue(new Callback<Heroi>() {
            @Override
            public void onResponse(Call<Heroi> call, Response<Heroi> response) {
                if (response.isSuccessful()) {
                    mheroList = response.body().getData().getResults();
                    for (int i = 0; i < mheroList.size(); i++) {
                        System.out.println(mheroList.get(i).getName());
                    }
                    HeroAdapter adapter = new HeroAdapter(mheroList);
                    mRecvHeroes.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Heroi> call, Throwable t) {
                System.out.println("error");
            }
        });
    }
}