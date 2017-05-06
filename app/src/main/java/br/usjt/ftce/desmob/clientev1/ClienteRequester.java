package br.usjt.ftce.desmob.clientev1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arqdsis on 31/03/2017.
 */
public class ClienteRequester {

    OkHttpClient client = new OkHttpClient();

    public ArrayList<Cliente> get(String url, String chave) throws IOException {
        ArrayList<Cliente> lista = new ArrayList<>();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute(); //error aqui
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                String name = item.getString("name");
                String capital = item.getString("capital");
                String area = item.getString("area");
                String population = item.getString("population");
                Cliente cliente = new Cliente(name, capital, area, population);
                lista.add(cliente);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Bitmap getImage(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();
        Bitmap img = BitmapFactory.decodeStream(is);
        is.close();

        return img;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }
}
