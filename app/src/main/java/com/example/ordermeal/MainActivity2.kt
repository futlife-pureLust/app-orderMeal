package com.example.ordermeal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//手動import
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    //切換頁並夾帶資料
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //接收並顯示呼叫者傳來桌號資料
        intent?.extras?.let{
            tv_value2.text  = it.getString("key")
        }

        //第三步：設定Button監聽事件，判斷是否輸入飲料名稱，並讀取RadioGroup數值
        btn_send.setOnClickListener{
            if(ed_drink.length()<1)
                Toast.makeText(this,"請輸入飲料名稱",Toast.LENGTH_SHORT).show()
            else{
                //宣告Bundle
                val b = Bundle()
                //取得EditText字串內容，把飲料名稱與甜度及冰塊資訊放入Bundle
                b.putString("drink",ed_drink.text.toString())

                b.putString(
                    "sugar",radioGroup1.findViewById<RadioButton>(
                        radioGroup1.checkedRadioButtonId
                    )
                )
                b.putString(
                    "ice",radioGroup2.findViewById<RadioButton>(
                        radioGroup2.checkedRadioButtonId
                    ).text.toString()
                )
                //用Activity.RESULT_OK標記執行狀態並記錄Intent
                setResult(Activity.RESULT_OK, Intent().putExtra(b))
                finish()
            }
        }
    }
}