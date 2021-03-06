package com.example.isaac.m8uf2provafinal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.recyclerViewHolder>{
    ArrayList<ImageUploadInfo> myList;
    Bitmap image;


    public recyclerAdapter(ArrayList<ImageUploadInfo> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new recyclerViewHolder(view);
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final recyclerViewHolder holder, final int position) {

        holder.txtName.setText(myList.get(position).getImageName());
        holder.txtInformacion.setText(myList.get(position).getImageURL());
        holder.myCheckBox.setChecked(myList.get(position).isStatus());
        String imageURL = myList.get(position).getImageURL();

        try {
            if (imageURL.startsWith("http")) {
                holder.foto.setImageBitmap(getBitmapFromURL(imageURL));
            }
        } catch ( Exception e){

        }
        if (holder.myCheckBox.isChecked()) {
            holder.cross.setVisibility(View.VISIBLE);
        } else {
            holder.cross.setVisibility(View.INVISIBLE);
        }

        holder.myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(buttonView.getContext(), "Is checked " + position, Toast.LENGTH_SHORT).show();
                    setFadeAnimation(holder.cross);
                } else {
                    Toast.makeText(buttonView.getContext(), "Not checked " + position, Toast.LENGTH_SHORT).show();
                    setFadeOutAnimation(holder.cross);
                }
            }
        });
    }

    private void setFadeAnimation(View view){
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
        view.setVisibility(View.VISIBLE);
    }

    private void setFadeOutAnimation(View view){
        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
        view.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class recyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtInformacion;
        CheckBox myCheckBox;
        ImageView foto, cross;


        public recyclerViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            foto = (ImageView) itemView.findViewById(R.id.idImagen);
            myCheckBox = (CheckBox) itemView.findViewById(R.id.idCheckBox);
            cross = (ImageView) itemView.findViewById(R.id.idCross);

        }
    }
}