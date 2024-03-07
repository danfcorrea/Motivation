package com.danfcorrea.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.danfcorrea.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = SharedPreferences(this).getString("USER_NAME")
        binding.textHello.text = buildString {
            append(getString(R.string.hello))
            append(" ")
            append(name)
        }
        binding.buttonNewMessage.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonNewMessage){
            TODO("Gerar nova Frase")
        }
    }


}