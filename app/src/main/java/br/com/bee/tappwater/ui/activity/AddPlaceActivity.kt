package br.com.bee.tappwater.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.com.bee.tappwater.R
import br.com.bee.tappwater.ui.models.Place
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_place.*

class AddPlaceActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) : Intent {
            return Intent(context, AddPlaceActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)
        init()
    }

    private fun init() {
        setEvents()
    }

    private fun setEvents() {
        addBV.setOnClickListener { createNewPlace()}
    }

    private fun createNewPlace() {

        if (validateForm()){
            val place = Place(nameET.text.toString(), 2.2, 3.3, descriptionET.text.toString(), true)
            place.save(FirebaseDatabase.getInstance().reference)
        }

    }

    private fun validateForm() : Boolean{
        val name = nameET.text.toString()
        val description = descriptionET.text.toString()

        if (name == null){
            nameET.error = "mandatory field"
            return false
        }

        if (description == null){
            descriptionET.error = "mandatory field"
            return false
        }

        return true
    }
}