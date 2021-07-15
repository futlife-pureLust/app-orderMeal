package com.example.ordermeal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//手動import
import android.app.Activity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

//第一步：撰寫MainActivity，按下按鈕，切換至Main2Activtiy
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //「」「」
      btn_choice.setOnClickListener{
            //透過Intent切換至Main2Activity，並傳遞requestCode
            startActivityForResult(Intent(this,MainActivity2::class.java),1)
        }
    }

    //第二步：建立onActivityResult()，接收返回資料，將data內容讀出，以textView顯示
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode,resultCode,data)
        //判斷Bundle是否不為空
        val b = data?.extras?: return
        //驗證請求對像與回傳狀態
        if(requestCode==1&&resultCode==Activity.RESULT_OK){
            tv_meal2.text=String.format("飲料： %s\n\n甜度： %s\n\n冰塊： %s\n\n",b.getString("drink"),b.getString("sugar"),b.getString("ice"))
        }
    }
}

