//package com.example.infoday.ui.events
//
//class DeptRecyclerViewAdapter {
//}

package com.example.infoday.ui.events

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.infoday.R

import com.example.infoday.ui.events.dummy.DummyContent.DummyItem
import com.example.infoday.data.Dept// ui.events.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class DeptRecyclerViewAdapter(
    private val values: List<Dept>
) : RecyclerView.Adapter<DeptRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_event_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
//        holder.idView.text = item.id
//        holder.contentView.text = item.content
        holder.eventIdView.text = item.id
        holder.eventNameView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val idView: TextView = view.findViewById(R.id.eventId)
//        val contentView: TextView = view.findViewById(R.id.eventName)
        val eventIdView: TextView = view.findViewById(R.id.eventId)
        val eventNameView: TextView = view.findViewById(R.id.eventName)

        init {
            view.setOnClickListener {
                it.findNavController().navigate(R.id.action_eventFragment_self,
                    bundleOf(Pair("dept_id", eventIdView.text.toString()))
                )
            }
        }

        override fun toString(): String {
//            return super.toString() + " '" + contentView.text + "'"
            return super.toString() + " '" + eventNameView.text + "'"
        }
    }
}