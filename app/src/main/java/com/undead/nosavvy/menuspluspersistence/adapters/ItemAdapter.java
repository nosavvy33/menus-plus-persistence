package com.undead.nosavvy.menuspluspersistence.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.undead.nosavvy.menuspluspersistence.R;
import com.undead.nosavvy.menuspluspersistence.models.Item;
import com.undead.nosavvy.menuspluspersistence.repositories.ItemRepository;

import java.util.List;

/**
 * Created by nosavvy on 4/20/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private View itemView;
    private List<Item> items;

    public ItemAdapter(List<Item> items){
        this.items = items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre;
        public TextView precio;
        public TextView descripcion;
        public Button favoritos;
        public Button archivados;
        public ViewHolder(View itemView) {
            super(itemView);
            nombre= (TextView) itemView.findViewById(R.id.item_name);
            precio = (TextView) itemView.findViewById(R.id.item_price);
            descripcion = (TextView) itemView.findViewById(R.id.item_description);
            favoritos = (Button) itemView.findViewById(R.id.favoritos);
            archivados = (Button) itemView.findViewById(R.id.archivados);
        }
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.ViewHolder viewHolder, final int position) {
        final Item item = this.items.get(position);
        viewHolder.nombre.setText(item.getNombre());
        viewHolder.descripcion.setText(item.getDescripcion());
        viewHolder.precio.setText(String.valueOf(item.getPrecio()));
        if(item.getEstado() == "favorito"){
            viewHolder.favoritos.setBackgroundColor(Color.YELLOW);
        }
        viewHolder.archivados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemRepository.updateEstadoArchivado(item.getId());
               // itemView.destroyDrawingCache();
                items = ItemRepository.selectNormalAndFavorites();
                notifyDataSetChanged();
            }
        });
        viewHolder.favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemRepository.updateEstadoFavorito(item.getId());
                viewHolder.favoritos.setBackgroundColor(Color.YELLOW);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

}
