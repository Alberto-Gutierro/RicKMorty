package com.example.rickmorty;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RymRepository {
    RymAPI rymAPI;

    public RymRepository(){
        rymAPI = RymAPIModule.getAPI();
    }

    public LiveData<List<Character>> getCharacters(){
        final MutableLiveData<List<Character>> lista = new MutableLiveData<>();

        rymAPI.getCharacters().enqueue(new Callback<CharacterList>() {
            @Override
            public void onResponse(Call<CharacterList> call, Response<CharacterList> response) {
                lista.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<CharacterList> call, Throwable t) {
            }
        });

        return lista;
    }

    public LiveData<Character> getCharacter(int id){
        final MutableLiveData<Character> characterMutableLiveData = new MutableLiveData<>();

        rymAPI.getCharacter(id).enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                characterMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
            }
        });

        return characterMutableLiveData;
    }
}

