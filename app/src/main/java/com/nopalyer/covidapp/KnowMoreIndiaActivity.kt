package com.nopalyer.covidapp

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
      getGlobalIndiaData()
    }
    fun getGlobalIndiaData(){
    val url:String ="https://covid19.mathdro.id/api/countries/INDIA"

    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {

            var jsonObject = JSONObject(it.toString())
            var confirmed = JSONObject(jsonObject.getString("confirmed").toString())
            var recovered = JSONObject(jsonObject.getString("recovered").toString())
            var deaths = JSONObject(jsonObject.getString("deaths").toString())
            Log.i("KnowMoreIndiaActivity","inida confirmed - "+confirmed.getString("value"))
            txtIndiaTodayInfected.text = confirmed.getString("value")
            txtIndiaTodayRecoverd.text = recovered.getString("value")
            txtIndiaTodayDeceased.text = deaths.getString("value")
                                  },
        {
            Toast.makeText(this@KnowMoreIndiaActivity,it.toString(),Toast.LENGTH_LONG).show()
            txtIndiaTodayInfected.text = "-"
            txtIndiaTodayRecoverd.text = "-"
            txtIndiaTodayDeceased.text = "-"
        }
    )

    val requestQueue = Volley.newRequestQueue(this@KnowMoreIndiaActivity)
    requestQueue.add(stringRequest)
}

}
