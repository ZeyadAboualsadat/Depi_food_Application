package com.example.citiesapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.citiesapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding= DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.btLogin.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            //intent.putExtra("title","Cities")
            startActivity(intent)
        }


    }
}