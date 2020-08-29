package com.example.finalprojection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class postJob extends AppCompatActivity {
    Button save;
    EditText taskname,location,payment,description,workhours;
    RequestQueue requestQueue;
    String insertUrl=" http://192.168.100.6:8000/api/job";
    String showUrl="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);
        taskname=findViewById(R.id.taskn);
        location=findViewById(R.id.locationy);
        payment=findViewById(R.id.paymenty);
        description=findViewById(R.id.descriptiony);
        workhours=findViewById(R.id.worky);
        save=findViewById(R.id.savey);
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request=new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        taskname.setText("");
                        location.setText("");
                        payment.setText("");
                        description.setText("");
                        workhours.setText("");

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String>parameters=new HashMap<String,String>();
                        parameters.put("task_name",taskname.getText().toString());
                        parameters.put("location",location.getText().toString());
                        parameters.put("payment",payment.getText().toString());
                        parameters.put("description",description.getText().toString());
                        parameters.put("work_hours",workhours.getText().toString());

                        return parameters;

                    }
                };
                requestQueue.add(request);


            }

        });
    }

}
