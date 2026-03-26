package com.example.contact_app_recycler_view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewAllContactsActivity : AppCompatActivity(), ContactGridAdapter.OnGridContactActionListener {

    private lateinit var gridViewContacts: GridView
    private lateinit var etSearch: EditText
    private lateinit var btnSort: Button
    private lateinit var gridAdapter: ContactGridAdapter
    private var allContacts = mutableListOf<Contact>()
    private var filteredContacts = mutableListOf<Contact>()
    private var isAscending = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_all_contacts)

        gridViewContacts = findViewById(R.id.gridViewContacts)
        etSearch = findViewById(R.id.etSearch)
        btnSort = findViewById(R.id.btnSort)

        // Get contacts from MainActivity via static variable
        allContacts = MainActivity.allContactsList.toMutableList()
        filteredContacts.addAll(allContacts)

        gridAdapter = ContactGridAdapter(this, filteredContacts, this)
        gridViewContacts.adapter = gridAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Search functionality
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterContacts(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Sort functionality
        btnSort.setOnClickListener {
            isAscending = !isAscending
            btnSort.text = if (isAscending) "Sort ↑" else "Sort ↓"
            filterContacts(etSearch.text.toString())
        }
    }

    private fun filterContacts(query: String) {
        filteredContacts.clear()

        if (query.isEmpty()) {
            filteredContacts.addAll(allContacts)
        } else {
            filteredContacts.addAll(
                allContacts.filter { contact ->
                    contact.name.contains(query, ignoreCase = true) ||
                    contact.phone.contains(query, ignoreCase = true)
                }
            )
        }

        // Sort
        if (isAscending) {
            filteredContacts.sortBy { it.name }
        } else {
            filteredContacts.sortByDescending { it.name }
        }

        gridAdapter.notifyDataSetChanged()
    }

    override fun onGridEditClick(position: Int) {
        val contact = filteredContacts[position]
        showEditDialog(contact)
    }

    override fun onGridDeleteClick(position: Int) {
        val contact = filteredContacts[position]
        AlertDialog.Builder(this)
            .setTitle("Delete Contact")
            .setMessage("Are you sure you want to delete ${contact.name}?")
            .setPositiveButton("Yes") { _, _ ->
                allContacts.remove(contact)
                filteredContacts.remove(contact)
                gridAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Contact deleted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun showEditDialog(contact: Contact) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_dialog_edit_item, null)
        val etEditName = dialogView.findViewById<EditText>(R.id.etEditName)
        val etEditPhone = dialogView.findViewById<EditText>(R.id.etEditPhone)

        etEditName.setText(contact.name)
        etEditPhone.setText(contact.phone)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Edit Contact")
            .setView(dialogView)
            .setPositiveButton("Update", null)
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            val updatedName = etEditName.text.toString().trim()
            val updatedPhone = etEditPhone.text.toString().trim()

            if (validateInputs(updatedName, updatedPhone, etEditName, etEditPhone)) {
                contact.name = updatedName
                contact.phone = updatedPhone
                gridAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Contact updated", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
    }

    private fun validateInputs(
        name: String,
        phone: String,
        nameInput: EditText,
        phoneInput: EditText
    ): Boolean {
        var isValid = true

        if (name.isEmpty()) {
            nameInput.error = "Name is required"
            isValid = false
        }

        if (phone.isEmpty()) {
            phoneInput.error = "Phone number is required"
            isValid = false
        } else if (phone.length < 10 || !phone.all { it.isDigit() || it == '+' }) {
            phoneInput.error = "Enter valid phone number"
            isValid = false
        }

        return isValid
    }
}
