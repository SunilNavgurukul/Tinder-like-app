package com.example.konnectorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.konnectorapp.R.layout.collection_of_img;

public class SwipeFragemnt extends Fragment {
    private RecyclerView recyclerView;
    private SwipeFragmentRecyclerViewAdapter adapter;
    private List<ImageModel> imageModelList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(collection_of_img, container, false);
        ImageButton button = v.findViewById(R.id.swipe_filter);
        recyclerView = v.findViewById(R.id.image_recycler);

        imageModelList = new ArrayList<>();
        adapter = new SwipeFragmentRecyclerViewAdapter(getContext(), imageModelList);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        getImageData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), filterActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    private void getImageData() {

        ImageModel imageModel = new ImageModel();
        imageModel.setImage(R.drawable.a);
        imageModelList.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setImage(R.drawable.b);
        imageModelList.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setImage(R.drawable.c);
        imageModelList.add(imageModel);
        imageModel = new ImageModel();
        imageModel.setImage(R.drawable.d);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.e);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.f);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.g);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.h);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.i);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.j);
        imageModelList.add(imageModel);
        imageModel.setImage(R.drawable.k);
        imageModelList.add(imageModel);


    }


}