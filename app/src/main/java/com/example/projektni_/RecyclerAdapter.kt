package com.example.projektni_

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projektni_.model.LektirasItem
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val dataList: MutableList<LektirasItem>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        context = parent.context
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lektire_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val data = dataList[position]
        val lektiraTitleTextView = holder.itemView.findViewById<TextView>(R.id.lektira_title)
        val lektiraAuthorTextView = holder.itemView.findViewById<TextView>(R.id.lektira_author)
        val lektiraPlaceTextView = holder.itemView.findViewById<TextView>(R.id.lektira_place)
        val lektiraImageImageView = holder.itemView.findViewById<ImageView>(R.id.lektira_image)
        Picasso.get()
            .load(data.image)
            .into(lektiraImageImageView)
        lektiraTitleTextView.text = data.title
        lektiraAuthorTextView.text = data.author
        lektiraPlaceTextView.text = data.place

        holder.itemView.setOnClickListener{
            val intent = Intent(context,Lektira::class.java)
            intent.putExtra("title", data.title)
            intent.putExtra("author", data.author)
            intent.putExtra("place", data.place)
            intent.putExtra("characters", data.characters)
            intent.putExtra("plot", data.plot)
            //bitan dio
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}