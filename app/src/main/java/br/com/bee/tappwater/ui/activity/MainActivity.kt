package br.com.bee.tappwater.ui.activity

import android.os.Bundle
import br.com.bee.tappwater.R
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        enterBtn.setOnClickListener { navigateToMap()}
        save.setOnClickListener { navigateToAddPlace() }

    }

    private fun navigateToMap() {
        val intent = ListActivity.newIntent(this)
        startActivity(intent)
    }

    private fun navigateToAddPlace() {
        val intent = AddPlaceActivity.newIntent(this)
        startActivity(intent)
    }



}