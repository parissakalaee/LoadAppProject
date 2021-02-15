package com.udacity

import android.app.NotificationManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.udacity.util.NOTIFICATION_ID
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {
    private var fileName = ""
    private var status = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val notificationManager = ContextCompat.getSystemService(
                this,
                NotificationManager::class.java
        ) as NotificationManager
        notificationManager.cancel(NOTIFICATION_ID)

        ok_button.setOnClickListener {
            returnToMainActivity()
        }

        fileName = intent.getStringExtra("fileName").toString()
        status = intent.getStringExtra("status").toString()
        text_file_name.text = fileName
        text_status.text = status
//        if(status.equals("Failed"))
//            text_status.setTextColor("#FF0000")
    }

    private fun returnToMainActivity() {
        val  mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
    }
}
