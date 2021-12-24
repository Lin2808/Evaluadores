package com.example.evaluadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainEvaluados extends AppCompatActivity
{


    RecyclerView recyclerView;
    ArrayList<Evaluados> evaluadosArrayList;
    private ListAdapter listAdapterEvaluados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_evaluados);

        recyclerView = findViewById(R.id.cvEvaluados);
        ExtraerEvaluados();
    }

    private void ExtraerEvaluados()
    {
        String URLstring = "https://uealecpeterson.net/ws/listadoaevaluar.php?e=1712896529";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject obj = new JSONObject(response);
                            evaluadosArrayList = new ArrayList<>();
                            JSONArray dataArray  = obj.getJSONArray("listaaevaluar");

                            for (int i = 0; i < dataArray.length(); i++)
                            {
                                Evaluados evaluados = new Evaluados();
                                JSONObject dataobj = dataArray.getJSONObject(i);

                                evaluados.setId(dataobj.getString("id"));
                                evaluados.setIdevaluado(dataobj.getString("idevaluado"));
                                evaluados.setNombres(dataobj.getString("Nombres"));
                                evaluados.setGenero(dataobj.getString("genero"));
                                evaluados.setSituacion(dataobj.getString("situacion"));
                                evaluados.setCargo(dataobj.getString("cargo"));
                                evaluados.setFechaInicio(dataobj.getString("fechainicio"));
                                evaluados.setFechaFin(dataobj.getString("fechafin"));
                                evaluados.setImgJPG(dataobj.getString("imgJPG"));
                                evaluados.setImgjpg(dataobj.getString("imgjpg"));
                                evaluadosArrayList.add(evaluados);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            listAdapterEvaluados adapter = new listAdapterEvaluados(getApplicationContext(), evaluadosArrayList);
                            recyclerView.setAdapter(adapter);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}