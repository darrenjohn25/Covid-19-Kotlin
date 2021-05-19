package com.nopalyer.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_precaution.*

class PrecautionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.soap,"Hand Wash","Clean your hands often. Use soap and water, or an alcohol-based hand rub."))
        precautionsList.add(Model(R.drawable.hone,"Stay Home","Stay home if you feel unwell."))
        precautionsList.add(Model(R.drawable.distance,"Social Distance","Maintain a safe distance from anyone who is coughing or sneezing."))
        precautionsList.add(Model(R.drawable.clean,"Clean Object & Surface","Sanitize the surface before you touch"))
        precautionsList.add(Model(R.drawable.cover,"Avoid Touching","Don’t touch your eyes, nose or mouth and Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze."))

        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter
    }
}
