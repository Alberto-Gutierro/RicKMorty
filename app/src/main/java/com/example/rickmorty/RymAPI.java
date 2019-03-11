package com.example.rickmorty;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface RymAPI {
    @GET("api/character/")
    Call<CharacterList> getCharacters();

    @GET("api/character/{id}")
    Call<Character> getCharacter(@Path("id") int id);
}
