package com.example.evaluadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class MainActivity extends AppCompatActivity {
    private String URLstring = "https://www.uealecpeterson.net/ws/listadoevaluadores.php";
    RecyclerView recyclerView;
    ArrayList<Evaluadores> evaluadoresArrayList;
    private ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.cvEvaluadores);
        ExtraerEvaluadores();
    }


    private void ExtraerEvaluadores()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try
                        {
                            JSONObject obj = new JSONObject(response);
                            evaluadoresArrayList = new ArrayList<>();
                            JSONArray dataArray  = obj.getJSONArray("listaaevaluador");

                            for (int i = 0; i < dataArray.length(); i++)
                            {
                                Evaluadores evaluadores = new Evaluadores();
                                JSONObject dataobj = dataArray.getJSONObject(i);
                                evaluadores.setIdevaluador(dataobj.getString("idevaluador"));
                                evaluadores.setNombres(dataobj.getString("nombres"));
                                evaluadores.setArea(dataobj.getString("area"));
                                evaluadores.setImgJPG(dataobj.getString("imgJPG"));
                                evaluadores.setImgjpg(dataobj.getString("imgjpg"));
                                evaluadoresArrayList.add(evaluadores);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            listAdapter adapter = new listAdapter(getApplicationContext(), evaluadoresArrayList);
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