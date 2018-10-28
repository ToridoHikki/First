package com.example.home.first

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up_step3.*

class SignUpStep3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_step3)

        btnSendEmail.setOnClickListener {

            val firstName = intent.getStringExtra("firstName")
            val lastName = intent.getStringExtra("lastName")
            val phoneNumber = intent.getStringExtra("phoneNumber")
            val email = intent.getStringExtra("email")
            val salary = intent.getIntExtra("salary", 0)

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // only email apps should handle this
                putExtra(Intent.EXTRA_EMAIL, email)
                putExtra(Intent.EXTRA_SUBJECT, "User's registration info.")
                putExtra(Intent.EXTRA_TEXT, "${firstName}_$lastName\n$phoneNumber\n${salary * 100} dollars")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }
        btnRestart.setOnClickListener {
            val intent = Intent(this, SignUpStep1Activity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)

        }

    }
}
