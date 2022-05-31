package a06367.apicture.ui.main

import android.app.Activity

import a06367.apicture.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.paging.ExperimentalPagingApi

class CabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cab)
    }

//    @OptIn(ExperimentalPagingApi::class)
@OptIn(ExperimentalPagingApi::class)
fun onClickHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onClickClose(view: View) {
        finish()
    }

    fun onClickCollections(view: View) {
        val intent = Intent(this, NewCollectionActivity::class.java)
        startActivity(intent)
    }

    fun collectionOpen(view: View) {
        val intent = Intent(this, CollectionActivity::class.java)
        startActivity(intent)
    }
}