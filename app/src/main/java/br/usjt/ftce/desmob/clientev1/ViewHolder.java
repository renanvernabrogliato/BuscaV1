package br.usjt.ftce.desmob.clientev1;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by arqdsis on 24/03/2017.
 */
public class ViewHolder {
    private ImageView fotoCliente;
    private TextView nameCliente, detalheCliente;

    public ViewHolder(ImageView fotoCliente, TextView nameCliente, TextView detalheCliente) {
        this.fotoCliente = fotoCliente;
        this.nameCliente = nameCliente;
        this.detalheCliente = detalheCliente;
    }

    public ImageView getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(ImageView fotoCliente) {
        this.fotoCliente = fotoCliente;
    }

    public TextView getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(TextView nomeCliente) {
        this.nameCliente = nomeCliente;
    }

    public TextView getDetalheCliente() {
        return detalheCliente;
    }

    public void setDetalheCliente(TextView detalheCliente) {
        this.detalheCliente = detalheCliente;
    }
}
