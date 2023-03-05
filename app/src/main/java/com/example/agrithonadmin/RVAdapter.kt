package com.example.agrithonadmin

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.Rotate
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

class RVAdapter(
    private val context: Context,
    private var list: ArrayList<PredictData>,
): RecyclerView.Adapter<RVAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.iv_image)
        var itemPredict: TextView = itemView.findViewById(R.id.tv_prediction)
        var itemDate: TextView = itemView.findViewById(R.id.tv_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycleview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        loadPicture(list[position].image, holder.itemImage)
        holder.itemPredict.text = list[position].prediction
        holder.itemDate.text = list[position].time

        holder.itemPredict.setOnClickListener {
            var intent = Intent(context, DetailsActivity::class.java)
            Log.e("res", list[position].toString())
            intent.putExtra("RESPONSE", list[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun byteArrayToBitmap(data: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(data, 0, data.size)
    }

    fun loadPicture(imageURI: Any, imageView: ImageView) {
        try {
            Glide
                .with(context)
                .load(imageURI)
                .centerCrop()
                .into(imageView)
        }
        catch(e: IOException) {
            e.printStackTrace()
        }
    }
}
