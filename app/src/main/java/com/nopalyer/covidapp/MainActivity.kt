package com.nopalyer.covidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Dry cough is one where no mucus or phlegm is produced."))
        symptomsList.add(Model(R.drawable.fever,"Fever","It is usually a sign that your body is trying to fight an illness or infection."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Messages sent to the brain while muscles or blood vessels swell, tighten etc.. causes headache"))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter


        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Clean your hands often. Use soap and water, or an alcohol-based hand rub."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Stay home if you feel unwell."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Maintain a safe distance from anyone who is coughing or sneezing."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerViewPrecautions.adapter = precautionsAdapter

        txtViewSymptoms.setOnClickListener {
            var intent = Intent(this@MainActivity,SymptomsActivity::class.java)
            startActivity(intent)
        }
        btnKnowMoreindia.setOnClickListener {
            var intent = Intent(this@MainActivity,KnowMoreIndiaActivity::class.java)
            startActivity(intent)
        }
        btnKnowMore.setOnClickListener {
            var intent = Intent(this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener {
            var intent = Intent(this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }
        getGlobalData()
    }
    fun getGlobalData(){
        val url:String ="https://corona.lmao.ninja/v2/all/"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> {

                var jsonObject = JSONObject(it.toString())

                //now set values in textview
                txtInfected.text = jsonObject.getString("cases")
                txtRecoverd.text = jsonObject.getString("recovered")
                txtDeceased.text = jsonObject.getString("deaths")
                txtTodayInfected.text = jsonObject.getString("todayCases")
                txtTodayRecoverd.text = jsonObject.getString("todayRecovered")
                txtTodayDeceased.text = jsonObject.getString("todayDeaths")

            },
            Response.ErrorListener {
                Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_LONG).show()
                txtInfected.text = "-"
                txtRecoverd.text = "-"
                txtDeceased.text = "-"

            }
        )

        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }
}
