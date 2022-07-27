package a06367.apicture.ui.main

import android.app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import a06367.apicture.R

class NewCollectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_collection)
    }

    fun onClickHome (view: View) {
        finish()
    }
}