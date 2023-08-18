package com.example.mad_practical_5_22172012006

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browserButton:Button = findViewById(R.id.button_brows)
        val editTextBrowser:EditText = findViewById(R.id.editTextText)
        browserButton.setOnClickListener {
            openurl(editTextBrowser.text.toString())

        }
    }

    fun openurl(s:String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(s)).also { startActivity(it) }
    }
    fun call(n:String)
    {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$n")).also { startActivity(it) }
    }
    fun calllog()
    {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun gallery()
    {
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it)}
    }
    fun camera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun alarm()
    {
    Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
}