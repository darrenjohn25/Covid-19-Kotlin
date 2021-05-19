package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough","Dry cough is one where no mucus or phlegm is produced."))
        symptomsList.add(Model(R.drawable.fever,"Fever","It is usually a sign that your body is trying to fight an illness or infection."))
        symptomsList.add(Model(R.drawable.pain,"Head Ache","Messages sent to the brain while muscles or blood vessels swell, tighten etc.. causes headache"))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","A sore throat is pain, scratchiness or irritation of the throat that often worsens when you swallow."))
        symptomsList.add(Model(R.drawable.taste,"Lack of Taste or Smell","Your sense of taste and sense of smell are closely linked and due to the effect of infection you tend to lose those."))

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter
    }
}
