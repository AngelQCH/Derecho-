package com.arteyciencia.a2jqch.derechobolivia;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arteyciencia.a2jqch.derechobolivia.adapter.Adaptador;
import com.arteyciencia.a2jqch.derechobolivia.model.Picture;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AsignaturasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AsignaturasFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public AsignaturasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_asignaturas, container, false);
        RecyclerView picturesRecycler=(RecyclerView)view.findViewById(R.id.pictureRecycler);
        picturesRecycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);

        Adaptador pictureAdapterRecyclerView=new Adaptador(buidPictures(),R.layout.cardview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }
    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures=new ArrayList<>();
        Resources resources=getResources();
        TypedArray imgs=resources.obtainTypedArray(R.array.imageMochilero);
        String[] arrayNombres=resources.getStringArray(R.array.dep);
        //tendré que crear otro array con la cantidad de preguntas de cada una para llenarla en el for como los nombres
        for(int i=0; i<5;i++) {
            pictures.add(new Picture(imgs.getResourceId(i, -1), arrayNombres[i], "100 preguntas", i + "4 mensajes"));
        }

        //notarás que nos lentea la aplicación e incluso lentea toda la actividad cuando le mandamos imágnes que no
        //son del tamaño adecuado, por eso la app estaba bien lenta cuando le mandaba en un vector all lo que hay actual en drawables
        return pictures;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
