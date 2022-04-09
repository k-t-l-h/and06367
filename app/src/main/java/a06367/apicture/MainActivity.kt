package a06367.apicture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView =  findViewById(R.id.activity_main__rv_1 )
        rv.adapter = MainAdapter(genListOfPics())
        rv.layoutManager =  GridLayoutManager(this, 2)
    }

    private fun genListOfPics(): List<Picture> {
        return listOf(
            Picture("Title1", "Description1", R.drawable.teleg),
            Picture("Title1", "Description1", R.drawable.teleg),
            Picture("Title1", "Description1", R.drawable.teleg),
            Picture("Title1", "Description1", R.drawable.teleg),
            Picture("Title1", "Description1", R.drawable.teleg),
            Picture("Title1", "Description1", R.drawable.teleg),
        )
    }
}