package com.papi.hercmem.android.gallery_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaintingAdapter(private val paintingsList: List<Painting>) :
    RecyclerView.Adapter<PaintingAdapter.PaintingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaintingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_painting, parent, false)
        return PaintingViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaintingViewHolder, position: Int) {
        val painting = paintingsList[position]

        holder.bind(painting)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, PaintingDetailActivity::class.java).apply {
                putExtra("name", painting.name)
                putExtra("artist", painting.artist)
                putExtra("description", painting.description)
                putExtra("image", painting.image)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = paintingsList.size

    inner class PaintingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val paintingNameTextView: TextView = itemView.findViewById(R.id.paintingName)
        private val artistTextView: TextView = itemView.findViewById(R.id.artist)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
        private val paintingImageView: ImageView = itemView.findViewById(R.id.paintingImage)

        fun bind(painting: Painting) {
            paintingNameTextView.text = painting.name
            artistTextView.text = painting.artist
            descriptionTextView.text = painting.description
            // Για την εικόνα, αν χρησιμοποιείς resources στο drawable:
            val imageResId = itemView.context.resources.getIdentifier(painting.image, "drawable", itemView.context.packageName)
            paintingImageView.setImageResource(imageResId)
        }
    }
}
