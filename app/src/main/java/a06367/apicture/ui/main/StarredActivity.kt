package a06367.apicture.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import a06367.apicture.R
import a06367.apicture.ui.main.adapter.StarredAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_starred.*

class StarredActivity : AppCompatActivity() {
    fun onClickHome (view: View) {
        finish()
    }

    lateinit var myAdapter: StarredAdapter
    lateinit var gridLayoutManger: GridLayoutManager

    lateinit var recyclerActivityViewModel: RecyclerActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starred)
        rv_images.setHasFixedSize(true)
        gridLayoutManger = GridLayoutManager(this,2)
        rv_images.layoutManager=gridLayoutManger

        getMyData()
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
