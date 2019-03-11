package com.example.rickmorty;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowCharacter extends Fragment {

     ViewModel mViewModel;
     ImageView imgCharacter;
     TextView tvCharacter;
     int chid;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_show_character, container, false);

        imgCharacter = view.findViewById(R.id.show_image);
        tvCharacter = view.findViewById(R.id.show_name);

        mViewModel = ViewModelProviders.of(this).get(ViewModel.class);

        fillCharacter();

        return view;
    }


    void setChid(int chid){
        this.chid = chid;
    }

    void fillCharacter(){
        mViewModel.getCharacter(chid).observe(this, new Observer<Character>() {
            @Override
            public void onChanged(@Nullable Character character) {
                tvCharacter.setText(character.name);
                GlideApp.with(ShowCharacter.this)
                        .load(character.image)
                        .into(imgCharacter);
            }
        });
    }
}
