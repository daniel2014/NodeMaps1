package com.danielrsoares.nodemaps.adapter;


/*
public class AdapterInventario {

    List<MovInventario> inventarios;
    Context context;

    public AdapterInventario(List<MovInventario> inventarios, Context context){
        this.inventarios = inventarios;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_inventario, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        MovInventario inventario = inventarios.get(position);

        holder.node.setText(inventario.getNode());
        holder.totalAtivos.setText(inventario.getTotalAtivos());

    }

    @Override
    public int getItemCount(){
        return inventarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView node, totalAtivos;

        public MyViewHolder(View itemView){
            super(itemView);

            node = itemView.findViewById(R.id.textAdapterInventarioNode);
            totalAtivos = itemView.findViewById(R.id.textAdapterInventarioTotalNode);
        }
    }

}
*/
