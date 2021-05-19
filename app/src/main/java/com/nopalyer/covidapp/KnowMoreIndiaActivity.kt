package com.nopalyer.covidapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_know_more.*
import kotlinx.android.synthetic.main.activity_know_more_india.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class KnowMoreIndiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_more_india)
      getGlobaltodayData()
      getGlobalData()
    }
    fun getGlobaltodayData(){
    val url:String ="https://covid19.mathdro.id/api/countries/INDIA"

    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        Response.Listener<String> {

            var jsonObject = JSONObject(it.toString())
            var confirmed = JSONObject(jsonObject.getString("confirmed").toString())
            var recovered = JSONObject(jsonObject.getString("recovered").toString())
            var deaths = JSONObject(jsonObject.getString("deaths").toString())
            Log.i("KnowMoreIndiaActivity","today - "+confirmed.getString("value"))
            txtIndiaTodayInfected.text = confirmed.getString("value")
            txtIndiaTodayRecoverd.text = recovered.getString("value")
            txtIndiaTodayDeceased.text = deaths.getString("value")
        },
        Response.ErrorListener {
            Toast.makeText(this@KnowMoreIndiaActivity,it.toString(),Toast.LENGTH_LONG).show()
            txtIndiaTodayInfected.text = "-"
            txtIndiaTodayRecoverd.text = "-"
            txtIndiaTodayDeceased.text = "-"

        }
    )

    val requestQueue = Volley.newRequestQueue(this@KnowMoreIndiaActivity)
    requestQueue.add(stringRequest)
}

    fun getGlobalData(){
        val url:String ="https://covid19.mathdro.id/api/countries/INDIA"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {
                var jsonObject = JSONObject(it.toString())
                var confirmed = JSONObject(jsonObject.getString("confirmed").toString())
                var recovered = JSONObject(jsonObject.getString("recovered").toString())
                var deaths = JSONObject(jsonObject.getString("deaths").toString())
                //now set values in textview
                txtIndiaTotalInfected.text = confirmed.getString("value")
                txtIndiaTotalRecoverd.text = recovered.getString("value")
                txtIndiaTotalDeceased.text = deaths.getString("value")
            },
            Response.ErrorListener {
                Toast.makeText(this@KnowMoreIndiaActivity,it.toString(),Toast.LENGTH_LONG).show()
                txtIndiaTotalInfected.text = "-"
                txtIndiaTotalRecoverd.text = "-"
                txtIndiaTotalDeceased.text = "-"
            }
        )

        val requestQueue = Volley.newRequestQueue(this@KnowMoreIndiaActivity)
        requestQueue.add(stringRequest)
    }

}
