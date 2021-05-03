package id.rrlab.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import id.rrlab.diffutil.adapter.RatingAdapter
import id.rrlab.diffutil.data.DataSource
import id.rrlab.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setList()
    }

    private fun setList() {
        val ratingAdapter = RatingAdapter()
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.adapter = ratingAdapter
            ratingAdapter.setData(DataSource.ratingList)
        }
    }
}