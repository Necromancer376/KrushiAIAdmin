package com.example.agrithonadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*
import java.io.IOException

class DetailsActivity : AppCompatActivity() {

    private lateinit var data: PredictData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setupActionBar()

        data = intent.getParcelableExtra<PredictData>("RESPONSE")!!

        tv_disease.text = data.prediction
        tv_description.text = data.description
        tv_symptoms.text = data.symptoms
        tv_source.text = data.source
        tv_location.text = data.location
        try {
            loadPicture(data.image, iv_image_result)
        }catch (e: Exception){ }
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar_details)

        val actionBar = supportActionBar
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_arrow)
        }

        toolbar_details.setNavigationOnClickListener{
            onBackPressed()
            finish()
        }
    }

    fun loadPicture(imageURI: Any, imageView: ImageView) {
        try {
            Glide
                .with(this)
                .load(imageURI)
                .centerCrop()
                .into(imageView)
        }
        catch(e: IOException) {
            e.printStackTrace()
        }
    }
}