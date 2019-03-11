package com.example.rickmorty;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class FragmentEnemy extends Fragment {

    private int num;
    private ViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);

        viewModel.getCharacters().observe(this, new Observer<List<Character>>() {
            @Override
            public void onChanged(@Nullable List<Character> characters) {
                num = characters.size();
                Log.e("ABC", String.valueOf(num));
                viewModel.getCharacter((int) (Math.random()*num)).observe(getActivity(), new Observer<Character>() {
                    @Override
                    public void onChanged(@Nullable Character character) {

                        TextView tvnom =getView().findViewById(R.id.nom_enemy);
                        ImageView iv_enemy = getView().findViewById(R.id.img_enemy);
                        tvnom.setText(character.name);

                        GlideApp.with(getContext()).load(character.image).into(iv_enemy);
                    }

                });
            }
        });
        return inflater.inflate(R.layout.fragment_fragment_enemy, container, false);
    }
}
