package br.com.johnnyfagundes.heroismarvel.utils.api;

import br.com.johnnyfagundes.heroismarvel.model.Heroi;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HeroesApi {

    @GET("v1/public/characters?ts=thesoer&apikey=1fde12d08f30e71aba6111275fa8b100&hash=388aa90472ef77ebbdfce146b9a61e0e&limit=4")
    Call<Heroi> getHeroes(@Query("offset") int offSet);

    @GET("v1/public/characters?")
    Call<Heroi> getHeroesByName(@Query("nameStartsWith") String heroName,
                                @Query("ts") String ts,
                                @Query("apikey") String apiKey,
                                @Query("hash") String hash,
                                @Query("limit") int limite
    );
}

//&ts=thesoer&apikey=1fde12d08f30e71aba6111275fa8b100&hash=388aa90472ef77ebbdfce146b9a61e0e
