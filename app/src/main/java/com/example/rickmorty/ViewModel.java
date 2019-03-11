package com.example.rickmorty;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private RymRepository rymRepository;
    private int chid;

    public ViewModel(@NonNull Application application) {
        super(application);
        rymRepository = new RymRepository();
    }

    public LiveData<List<Character>> getCharacters(){
        return rymRepository.getCharacters();
    }

    public LiveData<Character> getCharacter(int id){
        return rymRepository.getCharacter(id);
    }

    public int getChid() {
        return chid;
    }

    public void setChid(int chid) {
        this.chid = chid;
    }
}
