package com.example.rickmorty;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>{
    public List<Character> movieList = new ArrayList<>();

    @NonNull
    @Override
    public CharacterListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CharacterListViewHolder holder, int position) {
        final Character character = movieList.get(position);

        holder.name.setText(character.name);
        GlideApp
                .with(holder.itemView.getContext())
                .load(character.image)
                .into(holder.poster);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ActivityFragment.class);
                intent.putExtra("CHID", character.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class CharacterListViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView poster;
        public CharacterListViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.movieTitle);
            poster = itemView.findViewById(R.id.movieImage);
        }
    }
}
