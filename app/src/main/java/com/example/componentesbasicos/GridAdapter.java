package com.example.componentesbasicos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    String[] legenda;
    int[] imagens;
    LayoutInflater inflater;

    public GridAdapter(Context context, String[] legenda, int[] imagens) {
        this.context = context;
        this.legenda = legenda;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return legenda.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.grid_item,null);
        }

        ImageView imageView = view.findViewById(R.id.gridImagem);
        TextView textView = view.findViewById(R.id.nomeItem);

        imageView.setImageResource(imagens[posicao]);
        textView.setText(legenda[posicao]);

        return view;
    }
}
