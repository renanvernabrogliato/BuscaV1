package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClienteAdapter extends BaseAdapter {

    Cliente[] clientes;
    Activity context;

    public ClienteAdapter(Activity context, Cliente[] clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return clientes.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < clientes.length) {
            return clientes[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_cliente, viewGroup, false);

            ImageView fotoCliente = (ImageView) view.findViewById(R.id.foto_cliente);
            TextView nomeCliente = (TextView) view.findViewById(R.id.nome_cliente);
            TextView detalheCliente = (TextView) view.findViewById(R.id.detalhe_cliente);
            //faz cache dos widgets na tagView para usar quando usar quando houver reciclagem
            view.setTag(new ViewHolder(fotoCliente, nomeCliente, detalheCliente));
        }
        //usar os widgets cacheados na tag da view reciclado
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        Drawable foto = Imagem.getDrawable(context);
        holder.getFotoCliente().setImageDrawable(foto);
        holder.getNameCliente().setText(clientes[i].getName());
        holder.getDetalheCliente().setText(clientes[i].getCapital() + "  -  " + clientes[i].getArea() + " - " + clientes[i].getPopulation());

        return view;
    }

}
