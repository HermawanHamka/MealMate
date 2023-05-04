package com.example.mealmate

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import java.text.SimpleDateFormat

class personalisasi2 : AppCompatActivity() {
    private val CHANNEL_ID = "MealMateChannel"
    private val NOTIFICATION_ID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalisasi2)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val buttonRekomendasi = findViewById<TextView>(R.id.buttonRekomendasi)
        buttonRekomendasi.setOnClickListener {
        // Mengisi inputSarapan dengan waktu yang diinginkan
            val inputSarapan = findViewById<EditText>(R.id.inputSarapan)
            val inputMakanSiang = findViewById<EditText>(R.id.inputMakanSiang)
            val inputMakanMalam = findViewById<EditText>(R.id.inputMakanMalam)
            inputSarapan.setText("08:00")
            inputMakanSiang.setText("13:00")
            inputMakanMalam.setText("19:30")

            //Notif
            val waktuSarapan = inputSarapan.text.toString()

// Konversi waktu ke format sistem Android
            val waktuSarapanMillis = SimpleDateFormat("HH:mm").parse(waktuSarapan)?.time

// Buat objek AlarmManager dan Intent untuk menampilkan notifikasi
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, NotificationReceiver::class.java)

// Buat PendingIntent untuk menampilkan notifikasi
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE)

// Buat objek Notification
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.button_close)
                .setContentTitle("Sarapan")
                .setContentText("Sudah saatnya sarapan!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

// Buat objek NotificationManager
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

// Tentukan waktu untuk menampilkan notifikasi
            val currentTimeMillis = System.currentTimeMillis()
            val notificationTimeMillis = waktuSarapanMillis?.minus(currentTimeMillis)

// Gunakan AlarmManager untuk menampilkan notifikasi pada waktu yang ditentukan
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, currentTimeMillis + notificationTimeMillis!!, pendingIntent)

// Tampilkan notifikasi
            notificationManager.notify(NOTIFICATION_ID, builder.build())
        }

        val backButton: ImageView = findViewById<ImageView>(R.id.imageBack)
        backButton.setOnClickListener {
            val intent = Intent(this, personalisasi1::class.java)
            startActivity(intent)
        }

        val nextButton: Button = findViewById<Button>(R.id.button_lanjut)
        nextButton.setOnClickListener {
            val intent = Intent(this, personalisasi3::class.java)
            startActivity(intent)


        }



    }




}
