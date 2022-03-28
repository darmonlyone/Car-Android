package com.sevenpeak.main.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenpeak.R
import com.sevenpeak.main.ui.model.CarAdapter
import com.sevenpeak.main.ui.viewmodels.CarsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<CarsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carsRecyclerView.layoutManager = LinearLayoutManager(this)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.cars.observe(this, Observer {
            it ?: return@Observer
            carsRecyclerView.adapter = CarAdapter(it)
        })
        viewModel.failureGetCarEvent.observe(this, Observer {
            it ?: return@Observer
            Toast.makeText(this, "Bad Request", Toast.LENGTH_SHORT).show()
        })
    }
}