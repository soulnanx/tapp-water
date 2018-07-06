package br.com.bee.tappwater.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bee.tappwater.R
import br.com.bee.tappwater.ui.models.Place
import kotlinx.android.synthetic.main.item_place.view.*

class PlaceAdapter(val context: Context, val places: MutableList<Place>) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PlaceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_place, parent, false)
        return PlaceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return places.size
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]

        setDescription(holder, place)
        setName(holder, place)
        setIsFavorite(holder, place)
    }

    private fun setDescription(holder: PlaceViewHolder, place: Place){
        holder?.description.text = place.description
    }

    private fun setName(holder: PlaceViewHolder, place: Place){
        holder?.name.text = place.name
    }

    private fun setIsFavorite(holder: PlaceViewHolder, place: Place){
        holder?.switch.isChecked = place.isFavorite
    }


    class PlaceViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.nameET!!
        val description = itemView.descriptionTV!!
        val switch = itemView.favoriteS!!


    }
}