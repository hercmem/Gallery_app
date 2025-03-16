package com.papi.hercmem.android.gallery_app

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.papi.hercmem.android.gallery_app.databinding.ActivityPaintingDetailBinding
import java.util.Locale

class PaintingDetailActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding: ActivityPaintingDetailBinding
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaintingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Αρχικοποίηση του TextToSpeech
        textToSpeech = TextToSpeech(this, this)

        // Ανάκτηση δεδομένων από το Intent
        val name = intent.getStringExtra("name")
        val artist = intent.getStringExtra("artist")
        val description = intent.getStringExtra("description")
        val imageResource = intent.getStringExtra("image")?.let {
            resources.getIdentifier(it, "drawable", packageName)
        }

        // Εμφάνιση δεδομένων στην οθόνη
        binding.paintingNameTextView.text = name
        binding.paintingArtistTextView.text = artist
        binding.paintingDescriptionTextView.text = description
        binding.paintingImageView.setImageResource(imageResource ?: 0)

        // Ρύθμιση του ImageView για να διαβάσει την περιγραφή
        binding.speakImageView.setOnClickListener {
            description?.let {
                speakText(it)
            }
        }
    }

    // Μέθοδος για την ανάγνωση του κειμένου
    private fun speakText(text: String) {
        if (textToSpeech != null && text.isNotEmpty()) {
            textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    // Υλοποίηση της μεθόδου OnInitListener για την αρχικοποίηση του TextToSpeech
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val langResult = textToSpeech?.setLanguage(Locale.getDefault())
            if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Language not supported or missing data", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "TextToSpeech initialization failed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if (textToSpeech != null) {
            textToSpeech?.stop()
            textToSpeech?.shutdown()
        }
        super.onDestroy()
    }
}
