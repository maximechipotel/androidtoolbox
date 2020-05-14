package fr.isen.chipotel.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_contact.view.*
import kotlinx.android.synthetic.main.recycler_view_contact_cell.view.*

class ContactActivity(val contacts: ArrayList<ContactModel>): RecyclerView.Adapter<ContactActivity.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_contact_cell, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    class ContactViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(contact: ContactModel) {
            view.contactDisplayNameTextView.text = contact.displayName
        }
    }
}

