package com.vchichvarin.cloudnotesbsc.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vchichvarin.cloudnotesbsc.App
import com.vchichvarin.cloudnotesbsc.R
import com.vchichvarin.cloudnotesbsc.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    private lateinit var noteText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with (binding) {
            noteText.text = intent.extras?.getString("noteText")
            prevScreen.setOnClickListener {
                onBackPressed()
            }
            share.setOnClickListener {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = noteText.text.toString()
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_subject))
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_by)))
            }
        }
    }
}