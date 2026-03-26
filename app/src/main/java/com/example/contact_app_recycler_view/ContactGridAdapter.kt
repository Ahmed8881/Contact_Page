package com.example.contact_app_recycler_view

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ContactGridAdapter(
    private val context: Context,
    private val contactList: MutableList<Contact>,
    private val listener: OnGridContactActionListener
) : BaseAdapter() {

    interface OnGridContactActionListener {
        fun onGridEditClick(position: Int)
        fun onGridDeleteClick(position: Int)
    }

    override fun getCount(): Int = contactList.size

    override fun getItem(position: Int): Any = contactList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_contact_grid_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val contact = contactList[position]
        viewHolder.tvName.text = contact.name
        viewHolder.tvPhone.text = contact.phone

        // Load image if available
        if (!contact.imageUri.isNullOrEmpty()) {
            try {
                viewHolder.ivImage.setImageURI(Uri.parse(contact.imageUri))
            } catch (e: Exception) {
                // Keep default image
            }
        }

        viewHolder.btnEdit.setOnClickListener {
            listener.onGridEditClick(position)
        }

        viewHolder.btnDelete.setOnClickListener {
            listener.onGridDeleteClick(position)
        }

        return view!!
    }

    private class ViewHolder(view: View) {
        val ivImage: ImageView = view.findViewById(R.id.ivGridImage)
        val tvName: TextView = view.findViewById(R.id.tvGridName)
        val tvPhone: TextView = view.findViewById(R.id.tvGridPhone)
        val btnEdit: Button = view.findViewById(R.id.btnGridEdit)
        val btnDelete: Button = view.findViewById(R.id.btnGridDelete)
    }
}
