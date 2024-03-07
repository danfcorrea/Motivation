package com.danfcorrea.motivation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.danfcorrea.motivation.models.MotivationConstants
import com.danfcorrea.motivation.R
import com.danfcorrea.motivation.data.Mock
import com.danfcorrea.motivation.services.SharedPreferences
import com.danfcorrea.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var actualCategory: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        handleFilter(R.id.imageAll)
        actualCategory = MotivationConstants.FILTER.ALL
        handleName()
        binding.buttonNewMessage.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonNewMessage) {
            handleMessage(actualCategory)
        }
        if (v.id in listOf(R.id.imageAll, R.id.imageHappy, R.id.imageSun))
            handleFilter(v.id)
    }

    private fun handleFilter(id: Int) {
        handleCategory(id)
        handleMessage(actualCategory)
    }

    private fun handleMessage(category: String) {
        val message = generateMessage(category)
        binding.textMessage.text = message
    }

    private fun generateMessage(category: String): String {
        return Mock().getPhrase(category)
    }

    private fun handleCategory(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.md_theme_onPrimary))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.md_theme_onPrimary))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.md_theme_onPrimary))

        when (id) {
            R.id.imageAll -> {
                binding.imageAll.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.md_theme_secondary
                    )
                )
                actualCategory = MotivationConstants.FILTER.ALL
            }

            R.id.imageHappy -> {
                binding.imageHappy.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.md_theme_secondary
                    )
                )
                actualCategory = MotivationConstants.FILTER.HAPPY
            }

            R.id.imageSun -> {
                binding.imageSun.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.md_theme_secondary
                    )
                )
                actualCategory = MotivationConstants.FILTER.SUN
            }
        }
    }

    private fun handleName() {
        val name = SharedPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textHello.text = buildString {
            append(getString(R.string.hello))
            append(" ")
            append(name)
        }
    }


}