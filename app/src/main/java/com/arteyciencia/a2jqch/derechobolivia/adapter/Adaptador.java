package com.arteyciencia.a2jqch.derechobolivia.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arteyciencia.a2jqch.derechobolivia.ContenidoActivity;
import com.arteyciencia.a2jqch.derechobolivia.R;
import com.arteyciencia.a2jqch.derechobolivia.model.Picture;

import java.util.ArrayList;
/**
 * Created by Personal Familiar on 27/06/2017.
 */


public class Adaptador extends RecyclerView.Adapter<Adaptador.PictureViewHolder> {
    private ArrayList<Picture> pictures;
    private int resource;//será el cardView
    private Activity activity;//para pasar como parametro la actividad de donde se está lamando
    //private RecyclerView.OnItemTouchListener itemClickListener;

    public Adaptador(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, final int position) {
//aquí será el paso de datos de la lista de pictures
        Picture picture=pictures.get(position);
        //se va generando objetos con datos llenas de tarjetas
        holder.pictureCard.setImageResource(picture.getPicture());
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, ContenidoActivity.class);
                /*switch (position){
                    case 0:
                        //sería para hacer realizar all in the activity questions enviar el array de preguntas
                        //desde aquí, o sacarlo en la actividad al reconocer de qué card proviene
                        //mandaremos un dato con la posicion y allí dependiendo de la posicion tomará el array indicado
                        intent.putExtra("dato1","CULTURA");
                        break;
                    case 1:
                        intent.putExtra("dato1","GASTRONOMIA");
                        break;
                    case 2:
                        intent.putExtra("dato1","DESTINOS");
                        break;
                    case 3:
                        intent.putExtra("dato1","HISTORIA");
                        break;
                    case 4:
                        intent.putExtra("dato1","FLORAFAUNA");
                        break;
                }*/

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureCard;
        private TextView usernameCard, timeCard, likeNumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);
            pictureCard= (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard= (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard= (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard= (TextView) itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
