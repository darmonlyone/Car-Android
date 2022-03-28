package com.sevenpeak.main.ui.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sevenpeak.R
import com.sevenpeak.main.domain.model.Car
import com.sevenpeak.main.ui.model.mapper.CarToUiCarMapper


class CarAdapter(
    private val dataSet: Array<Car>
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        private val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        private val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        private val carImageImageView: ImageView = view.findViewById(R.id.carImageImageView)

        fun bind(uiCar: UiCar) {
            titleTextView.text = uiCar.title
            dateTextView.text = uiCar.date
            descriptionTextView.text = uiCar.ingress

            Glide.with(carImageImageView.context).load(uiCar.imageUrl).fitCenter()
                .error(R.drawable.ic_launcher_foreground).into(
                    carImageImageView
                )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car, parent, false)

        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(CarToUiCarMapper().map(dataSet[position]))
    }

    override fun getItemCount() = dataSet.size
}