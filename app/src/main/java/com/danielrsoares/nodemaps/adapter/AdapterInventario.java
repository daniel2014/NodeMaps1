package com.danielrsoares.nodemaps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.danielrsoares.nodemaps.R;
import com.danielrsoares.nodemaps.model.MovInventario;
import java.util.List;


/**
 * Created by Jamilton Damasceno
 */
//Essa Classe esta na Aula 57.1 nos arquivos do curso

public class AdapterInventario extends RecyclerView.Adapter<AdapterInventario.MyViewHolder> {

    List<MovInventario> movInventarios;
    Context context;

    public AdapterInventario(List<MovInventario> movInventarios, Context context) {
        this.movInventarios = movInventarios;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_inventario, parent, false);
        return new MyViewHolder(itemLista);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovInventario movInventario = movInventarios.get(position);

        holder.titulo.setText(movInventario.getNode());
        holder.total.setText(movInventario.getTotalAtivos());
        //holder.valor.setText(String.valueOf(movimentacao.getValor()));
        //holder.categoria.setText(movimentacao.getCategoria());
        //holder.valor.setTextColor(context.getResources().getColor(R.color.colorAccentReceita));

        /*
        if (movimentacao.getTipo().equals("d")) {
            holder.valor.setText("-" + movimentacao.getValor());
            holder.valor.setTextColor(context.getResources().getColor(R.color.colorAccentDespesa));
        }
        */
    }


    @Override
    public int getItemCount() {
        return movInventarios.size(); //Vamos descobrir a quantidade de Itens que temos em movimentação
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, total; //valor, categoria;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textAdapter_Node);
            total = itemView.findViewById(R.id.textAdapter_TotalAtivos);
            //valor = itemView.findViewById(R.id.textAdapterValor);
            //categoria = itemView.findViewById(R.id.textAdapterCategoria);
        }

    }

}
