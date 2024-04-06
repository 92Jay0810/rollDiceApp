package com.example.homework1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework1.R
import com.example.homework1.model.DiceResult

class MutiDiceadapter(
    private val context: Context,
    private val dataset: MutableList<DiceResult>
) : RecyclerView.Adapter<MutiDiceadapter.MutiDiceViewHolder>() {
    class MutiDiceViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textview:TextView=view.findViewById(R.id.sum_textview)
        val horizontalrecyview:RecyclerView=view.findViewById(R.id.inner_horizontal_recycler_view)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MutiDiceadapter.MutiDiceViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.vertical_list_item, parent, false)
        return MutiDiceadapter.MutiDiceViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: MutiDiceadapter.MutiDiceViewHolder, position: Int) {
        val sumvalue = dataset[position].sum
        holder.textview.text=sumvalue.toString()
        holder.horizontalrecyview.adapter=Diceadapter(context,dataset[position])
        holder.horizontalrecyview.setHasFixedSize(true)
        holder.horizontalrecyview.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false))

    }

    override fun getItemCount() = dataset.size
}