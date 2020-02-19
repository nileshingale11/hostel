package com.example.hostel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        text_in_edit_name.addTextChangedListener(this)

        btn_registerScr_register.setOnClickListener(this)
        textView_login_link.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_registerScr_register -> {
                registerUser()
            }
            textView_login_link -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun registerUser() {
        val email = text_in_edit_email_register.text?.trim()
        val password = text_in_edit_password_register.text?.trim()
        when {
            text_in_edit_name.text?.isEmpty()!! -> {
                text_in_layout_name.error = getString(R.string.empty_name_error_msg)
            }
            text_in_edit_email_register.text?.isEmpty()!! -> {
                text_in_layout_username_register.error = getString(R.string.empty_email_error_msg)
            }
            text_in_edit_password_register.text?.isEmpty()!! -> {
                text_in_layout_password_register.error =
                    getString(R.string.empty_password_error_msg)
            }
            text_in_edit_confirm_password.text?.isEmpty()!! -> {
                text_in_layout_confirm_password.error = getString(R.string.empty_password_error_msg)
            }
        }
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}
