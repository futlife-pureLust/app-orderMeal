package com.example.ordermeal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.app.Activity
import android.content.Intent
import android.widget.CheckBox

import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //接收
        intent?.extras?.let{
            tv_value2.text = it.getString("key")

        }

        btn_mealConfirm.setOnClickListener{
//將主餐名稱放入Bundle
            val b= Bundle()
            lateinit var mealA: CheckBox
            lateinit var mealB: CheckBox
            lateinit var mealC: CheckBox
            lateinit var mealD: CheckBox
            mealA = findViewById(R.id.checkBox)
            mealB = findViewById(R.id.checkBox2)
            mealC = findViewById(R.id.checkBox3)
            mealD = findViewById(R.id.checkBox4)
            var meal1 = if(mealA.isChecked) "A餐" else ""
            var meal2 = if(mealB.isChecked) "B餐" else ""
            var meal3 = if(mealC.isChecked) "C餐" else ""
            var meal4 = if(mealD.isChecked) "D餐" else ""
            val meal = "$meal1 $meal2 $meal3 $meal4"

            b.putString("mainMeal",meal)

            //透過setResult將資料回傳
            setResult(Activity.RESULT_OK,Intent().putExtras(b))

            finish()
        }
    }
}