package br.usjt.ftce.desmob.clientev1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText textNome;
    ArrayList<Cliente> lista;
    ClienteRequester clienteRequester;
    Intent intent;
    String chave;
    public static final String LISTA = "br.usjt.ftce.desmob.clientev1.lista";
    public static final String CHAVE = "br.usjt.ftce.desmob.clientev1.busca";
    public static final String SERVIDOR = "https://restcountries.eu";
    public static final String APPSTRING = "/rest/v2";
    public static final String RECURSO = "/all ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.buscar_clientes);
    }

    public void buscarCliente(View view) {
        // Intent intent = new Intent(this, ListarClientesActivity.class);
        intent = new Intent(this, ListarClientesActivity.class);
        //String nome = textNome.getText().toString();
        chave = textNome.getText().toString();
        //intent.putExtra(CHAVE, nome);
        clienteRequester = new ClienteRequester();
        String alo = SERVIDOR + APPSTRING + RECURSO;
        System.out.println("ALO: " + alo);
        if (clienteRequester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        lista = clienteRequester.get(SERVIDOR + APPSTRING + RECURSO, chave);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
