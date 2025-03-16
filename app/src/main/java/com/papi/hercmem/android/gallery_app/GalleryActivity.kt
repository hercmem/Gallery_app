package com.papi.hercmem.android.gallery_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.papi.hercmem.android.gallery_app.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {
    private lateinit var paintingsRecyclerView: RecyclerView
    private lateinit var paintingsAdapter: PaintingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        // Αρχικοποίηση της βάσης δεδομένων με τα δεδομένα των πινάκων
        GalleryDataManager.initializeData(this)

        // Ανάκτηση των δεδομένων των πινάκων από τη βάση δεδομένων
        val paintingsList = GalleryDataManager.getPaintingsData(this)

        // Αρχικοποίηση RecyclerView και Adapter
        paintingsRecyclerView = findViewById(R.id.paintingsRecyclerView)
        paintingsRecyclerView.layoutManager = LinearLayoutManager(this)

        paintingsAdapter = PaintingAdapter(paintingsList)
        paintingsRecyclerView.adapter = paintingsAdapter
    }
}