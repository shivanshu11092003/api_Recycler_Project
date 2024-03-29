package com.example.shoppingapp

import android.app.Activity
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context :Activity,private val persondata : List<User>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(itemview)


    }

    override fun getItemCount(): Int {
        return persondata.size


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = persondata[position]
        holder.id.text= currentitem.id.toString()
        holder.name.text=currentitem.firstName
        holder.lastname.text=currentitem.lastName

        Picasso.get().load(currentitem.image).into(holder.personimage)


    }
    class MyViewHolder(itemview : View):RecyclerView.ViewHolder(itemview) {
        val name : TextView
        val id :TextView
        val personimage : ShapeableImageView
        val lastname :TextView
        init {
            name=itemview.findViewById(R.id.Entername)
            id=itemview.findViewById(R.id.Enterid)
            personimage=itemview.findViewById(R.id.shapeableImageView)
            lastname=itemview.findViewById(R.id.Enterlastname)

        }




    }
}