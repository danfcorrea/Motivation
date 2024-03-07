package com.danfcorrea.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.danfcorrea.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.buttonSave)
            handleSave()
    }

    private fun handleSave() {
        if(nameIsValid())
            binding.editName.error = "Nome Inválido"
        else {
            save(MotivationConstants.KEY.USER_NAME, binding.editName.text.toString())
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun save(key: String, string: String) {
        SharedPreferences(this).storeString(key, string)
    }

    private fun nameIsValid(): Boolean {
        return binding.editName.text.isNullOrBlank()
    }
}