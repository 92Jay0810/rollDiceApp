package com.example.homework1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.R
import com.example.homework1.model.DiceResult

class Diceadapter(
    private val context: Context,
    private val dataset: DiceResult
) : RecyclerView.Adapter<Diceadapter.DiceViewHolder>() {
    class DiceViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.dice)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceViewHolder {
    // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.horzontial_list_item, parent, false)
        return DiceViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: DiceViewHolder, position: Int) {
        val value = dataset.dicevlue[position]
        if(value==0){
        }else{
            val drawableResource = when (value) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            holder.imageView.setImageResource(drawableResource)
        }
    }

    override fun getItemCount() = dataset.dicevlue.size
}