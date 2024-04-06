package com.example.rollDiceAp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework1.adapter.MutiDiceadapter
import com.example.homework1.databinding.ActivityMainBinding
import com.example.homework1.model.Dice
import com.example.homework1.model.DiceResult

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var currenttext=binding.textView.text.toString().toInt()
        var storereuslt:MutableList<DiceResult> = mutableListOf<DiceResult>()
        binding.plusbotton.setOnClickListener{
            if(currenttext>=10){
            }else{
                currenttext+=1
                binding.textView.text=currenttext.toString()
            }
        }
        binding.minusbutton.setOnClickListener{
            if(currenttext<=1){
            }else{
                currenttext-=1
                binding.textView.text=currenttext.toString()
            }
        }

        binding.verticalRecyclerView.adapter=MutiDiceadapter(this,storereuslt)
        binding.verticalRecyclerView.setHasFixedSize(true)
        binding.verticalRecyclerView.setLayoutManager(LinearLayoutManager(this))
        binding.button.setOnClickListener{
            var dice :Dice=Dice()
            var rollresultarray:IntArray = dice.roll(currenttext)
            var singlesum=rollresultarray.sum()
            var singlerollresult=rollresultarray.toMutableList()
            var diceresult:DiceResult=DiceResult(singlesum,singlerollresult)
            //從頭插入
            storereuslt.add(0,diceresult)
            binding.verticalRecyclerView.smoothScrollToPosition(0)
            //使用notify inserted 來改變資料
            binding.verticalRecyclerView.adapter!!.notifyItemInserted(0)
        }
        binding.button.setOnLongClickListener{
                var currentsize=storereuslt.size
                storereuslt.clear()
            //使用notify range remove 來清除多資料
                binding.verticalRecyclerView.adapter!!.notifyItemRangeRemoved(0,currentsize)
            Toast.makeText(this, "Clear!", Toast.LENGTH_SHORT).show()
            true
        }
    }
}