package com.example.blgbosslupitgupit

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AboutTheShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val editProfileButton = findViewById<TextView>(R.id.edit_profile_button)
        editProfileButton.setOnClickListener {
            showEditProfilePopup()
        }
    }

    private fun showEditProfilePopup() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.popup_edit_profile, null)
        builder.setView(dialogLayout)

        val emailEditText = dialogLayout.findViewById<EditText>(R.id.email_edit_text)
        val birthDateEditText = dialogLayout.findViewById<EditText>(R.id.birth_date_edit_text)
        val genderEditText = dialogLayout.findViewById<EditText>(R.id.gender_edit_text)
        val contactNumberEditText = dialogLayout.findViewById<EditText>(R.id.contact_number_edit_text)

        val emailTextView = findViewById<TextView>(R.id.email_text_view)
        val birthDateTextView = findViewById<TextView>(R.id.birth_date_text_view)
        val genderTextView = findViewById<TextView>(R.id.gender_text_view)
        val contactNumberTextView = findViewById<TextView>(R.id.contact_number_text_view)

        emailEditText.setText(emailTextView.text)
        birthDateEditText.setText(birthDateTextView.text)
        genderEditText.setText(genderTextView.text)
        contactNumberEditText.setText(contactNumberTextView.text)

        val dialog = builder.create()

        val saveButton = dialogLayout.findViewById<Button>(R.id.save_button)
        val cancelButton = dialogLayout.findViewById<Button>(R.id.cancel_button)

        saveButton.setOnClickListener {
            emailTextView.text = emailEditText.text
            birthDateTextView.text = birthDateEditText.text
            genderTextView.text = genderEditText.text
            contactNumberTextView.text = contactNumberEditText.text
            dialog.dismiss()
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}