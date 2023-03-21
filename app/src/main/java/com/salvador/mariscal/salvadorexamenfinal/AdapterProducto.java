package com.salvador.mariscal.salvadorexamenfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salvador.mariscal.salvadorexamenfinal.model.Producto;

import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.MyViewHolder>{

    private Context context;
    private ArrayList<Producto> category;
    private String url = "https://fakestoreapi.com/products";

    public AdapterProducto(Context context, ArrayList<Producto> category) {
        this.context = context;
        this.category = category;
    }


    @NonNull
    @Override
    public AdapterProducto.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.activity_product_lista, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProducto.MyViewHolder holder, int position) {

        holder.id.setText("#" + String.valueOf(position+1));
        holder.title.setText(category.get(position+2).getCategory());
        holder.precio.setText(category.get(position+3).getCategory());
        holder.descripcion.setText(category.get(position+4).getCategory());
        holder.categoria.setText(category.get(position+5).getCategory());
        holder.rate.setText(category.get(position+6).getCategory());
        holder.count.setText(category.get(position+7).getCategory());

        holder.editProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = category.get(position).getId();
                String value = category.get(position).getCategory();

            }
        });

    }

    @Override
    public int getItemCount() {return category.size();
}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, id,precio, descripcion, categoria,rate, count;
        private ImageView editProd;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id_prod);
            title = (TextView) itemView.findViewById(R.id.id_title);
            precio = (TextView) itemView.findViewById(R.id.precio);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            categoria = (TextView) itemView.findViewById(R.id.categoria_prod);
            rate = (TextView) itemView.findViewById(R.id.rate_prod);
            count = (TextView) itemView.findViewById(R.id.count_prod);
            editProd = (ImageView)  itemView.findViewById(R.id.imgBtn_prod);
        }
    }
}
