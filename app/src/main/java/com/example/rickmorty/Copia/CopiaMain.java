package com.example.rickmorty.Copia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rickmorty.Character;
import com.example.rickmorty.CharacterListAdapter;
import com.example.rickmorty.R;
import com.example.rickmorty.ViewModel;

import java.util.List;

public class CopiaMain {
//    package com.example.rickmorty;
//
//import android.arch.lifecycle.Observer;
//import android.arch.lifecycle.ViewModelProviders;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import java.util.List;
//
//    public class MainActivity extends AppCompatActivity {
//
//        private ViewModel mViewModel;
//        private RecyclerView mRecyclerView;
//        private CharacterListAdapter mCharacterListAdapter;
//
//        public String KEY_BUNDLE= "KEY";
//        public String KEY_INTENT_CHARACTER="KEY_CHARACTER";
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            mRecyclerView = findViewById(R.id.movieList);
//            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//            mCharacterListAdapter = new CharacterListAdapter();
//            mRecyclerView.setAdapter(mCharacterListAdapter);
//
//            mViewModel = ViewModelProviders.of(this).get(ViewModel.class);
//            mViewModel.getCharacters().observe(this, new Observer<List<Character>>() {
//                @Override
//                public void onChanged(@Nullable List<Character> characters) {
//                    mCharacterListAdapter.movieList = characters;
//                    mCharacterListAdapter.notifyDataSetChanged();
//                }
//            });
//        }
//
//
//   }
}
