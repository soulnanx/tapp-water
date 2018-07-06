package br.com.bee.tappwater.ui.models

import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude

class Place() {

    lateinit var name : String
    var latitude : Double = 0.0
    var longitude : Double = 0.0
    lateinit var description : String
    var isFavorite : Boolean = false

    constructor(name : String,
                latitude : Double,
                longitude : Double,
                description : String,
                isFavorite : Boolean) : this() {

        this.name = name
        this.latitude = latitude
        this.longitude = longitude
        this.description = description
        this.isFavorite = isFavorite

    }

    companion object {
        fun all(mDatabase: DatabaseReference) : FirebaseRecyclerOptions<Place> {

            val query  = mDatabase.child("places")
            return FirebaseRecyclerOptions.Builder<Place>()
                    .setQuery(query, Place::class.java)
                    .build()
        }

    }

    @Exclude
    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result["name"] = name
        result["latitude"] = latitude
        result["longitude"] = longitude
        result["description"] = description
        result["isFavorite"] = isFavorite

        return result
    }

    fun save(mDatabase: DatabaseReference) {
        val placeValues = toMap()
        val key = mDatabase.child("places").push().key
        mDatabase.child("/places/" + key.toString()).setValue(placeValues)
        mDatabase.push()
    }


}