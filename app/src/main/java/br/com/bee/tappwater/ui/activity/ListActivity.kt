package br.com.bee.tappwater.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.bee.tappwater.R
import br.com.bee.tappwater.ui.adapter.PlaceAdapter
import br.com.bee.tappwater.ui.models.Place
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) : Intent{
            return Intent(context, ListActivity::class.java)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        init()
    }

    private fun init() {
        setList()
    }

    private fun setList() {
        with(placesRV){
            layoutManager = LinearLayoutManager(this@ListActivity)


            val places: MutableList<Place> = mutableListOf()
            val placesListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    places.clear()
                    dataSnapshot.children.mapNotNullTo(places) { it.getValue<Place>(Place::class.java) }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    println("loadPost:onCancelled ${databaseError.toException()}")
                }
            }
            FirebaseDatabase.getInstance().reference.child("places").addListenerForSingleValueEvent(placesListener)
            adapter = PlaceAdapter(this@ListActivity, places)

        }
    }


}