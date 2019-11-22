package com.example.konnectorapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

//public class swipeActivity extends AppCompatActivity  {

public class swipeActivity extends Fragment  {

        public MyAppAdapter myAppAdapter;
        public ViewHolder viewHolder;
        private ArrayList<Data> array;
        private SwipeFlingAdapterView flingContainer;
        View v=null;
        ImageView imageView ;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.swipelayout, container, false);
        flingContainer = (SwipeFlingAdapterView) v.findViewById(R.id.frame);
        ImageButton imageButton = v.findViewById(R.id.swipe_filter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),filterActivity.class);
                startActivity(intent);
            }
        });

        array = new ArrayList<>();
        array.add(new Data(R.drawable.a, "Katrina Kaif\n" +
        "India"
        ));
        array.add(new Data(R.drawable.b, "Watson\n" +
"India"
        ));
        array.add(new Data(R.drawable.c, "Johansson \n" +
"India"
        ));
        array.add(new Data(R.drawable.d, "Priyanka Chopra\n" +
"India"
        ));
        array.add(new Data(R.drawable.e, "Deepika Padukone\n" +
"India"        ));
        array.add(new Data(R.drawable.f, "Anjelina Jolie \n" +
"India"
        ));
        array.add(new Data(R.drawable.e, "Aishwarya Rai\n" +
"India"
        ));
        array.add(new Data(R.drawable.k, "Aishwarya Rai\n" +
                "India"
        ));
        array.add(new Data(R.drawable.h, "Aishwarya Rai\n" +
                "India"
        ));
        array.add(new Data(R.drawable.i, "Aishwarya Rai\n" +
                "India"
        ));
        array.add(new Data(R.drawable.j, "Aishwarya Rai\n" +
                "India"
        ));
        array.add(new Data(R.drawable.l, "Aishwarya Rai\n" +
                "India"
        ));
        array.add(new Data(R.drawable.tt, "Aishwarya Rai\n" +
                "India"
        ));

        myAppAdapter = new MyAppAdapter(array, swipeActivity.this);
        flingContainer.setAdapter(myAppAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                array.remove(0);
                myAppAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                array.remove(0);
                myAppAdapter.notifyDataSetChanged();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.background).setAlpha(0);

                myAppAdapter.notifyDataSetChanged();
            }
        });
        return v;

    }


    public class ViewHolder {
            public FrameLayout background;
            public TextView DataText;
            public ImageView cardImage;


        }

        public class MyAppAdapter extends BaseAdapter {


            public List<Data> parkingList;
            public swipeActivity context;

            private MyAppAdapter(List<Data> apps, swipeActivity context) {
                this.parkingList = apps;
                this.context = context;
            }

            @Override
            public int getCount() {
                return parkingList.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {

                View rowView = convertView;


                if (rowView == null) {

                    LayoutInflater inflater = getLayoutInflater();
                    rowView = inflater.inflate(R.layout.konnector_layout_view, parent, false);
                    // configure view holder
                    viewHolder = new ViewHolder();
                    viewHolder.DataText = (TextView) rowView.findViewById(R.id.bookText);
                    viewHolder.background = (FrameLayout) rowView.findViewById(R.id.background);
                    viewHolder.cardImage = (ImageView) rowView.findViewById(R.id.cardImage);
                    rowView.setTag(viewHolder);

                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.DataText.setText(parkingList.get(position).getDescription() + "");

                Glide.with(getActivity()).load(parkingList.get(position).getImagePath()).into(viewHolder.cardImage);

                return rowView;
            }
        }
    }

