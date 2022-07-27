package a06367.apicture.ui.main

import a06367.apicture.R
import a06367.apicture.ui.main.adapter.StarredAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import kotlinx.android.synthetic.main.activity_collection.*
import androidx.lifecycle.Observer

class CollectionActivity : AppCompatActivity() {

    lateinit var myAdapter: StarredAdapter
    lateinit var gridLayoutManger: GridLayoutManager

    lateinit var recyclerActivityViewModel: RecyclerActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
        rv_images.setHasFixedSize(true)
        gridLayoutManger = GridLayoutManager(this,2)
        rv_images.layoutManager=gridLayoutManger

        getMyData()
    }

    fun onClickHome (view: View) {
        finish()
    }

    private fun getMyData() {

        recyclerActivityViewModel= ViewModelProvider(this).get(RecyclerActivityViewModel::class.java)
        recyclerActivityViewModel.getRecyclerListDataObserver().observe(this,Observer<List<StarredData>>{

            myAdapter= StarredAdapter(baseContext,it)
            myAdapter.notifyDataSetChanged()
            rv_images.adapter=myAdapter

        })

        recyclerActivityViewModel.makeApiCall()

    }
}