package com.example.konnectorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SwipeFragmentRecyclerViewAdapter extends RecyclerView.Adapter<SwipeFragmentRecyclerViewAdapter.recyler> {

    Context c;
    List<ImageModel> listAdapters;

    public SwipeFragmentRecyclerViewAdapter(Context c, List<ImageModel> listAdapters) {
        this.c = c;
        this.listAdapters = listAdapters;
    }

    @NonNull
    @Override
    public recyler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.carditem, parent, false);
        return new recyler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final recyler holder, int position) {

        final ImageModel itemholder = listAdapters.get(position);
        holder.imageView.setImageResource(itemholder.getImage());
    }

    @Override
    public int getItemCount() {
        return listAdapters.size();
    }

    public class recyler extends RecyclerView.ViewHolder {

        ImageView imageView;

        public recyler(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);

        }
    }
}
