package com.example.infoday.ui.events

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.infoday.R
import com.example.infoday.data.AppDatabase

import com.example.infoday.ui.events.dummy.DummyContent.DummyItem

import com.example.infoday.data.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class EventRecyclerViewAdapter(
    private val values: List<Event>
) : RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_event_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.eventIdView.text = item.deptId + " : " + item.id
        holder.eventNameView.text = item.title
//        holder.contentView.text = item.bookmarked

        holder.itemView.setOnClickListener { v ->
            CoroutineScope(IO).launch {
            val dao = AppDatabase.getInstance(v.context).eventDao()
            dao.update(values[position].also{ it.bookmarked = true })
            dao.findAllBookmarkedEvents().forEach {Log.d("EventRecyclerViewAdapter", "onBindViewHolder: $it") }
        }
            Toast.makeText(v.context, "${item.title} is bookmarked",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val idView: TextView = view.findViewById(R.id.eventId)
//        val contentView: TextView = view.findViewById(R.id.eventName)

        val eventIdView: TextView = view.findViewById(R.id.eventId)
        val eventNameView: TextView = view.findViewById(R.id.eventName)

        override fun toString(): String {
            return super.toString() + " '" + eventNameView.text + "'"
        }
    }
}