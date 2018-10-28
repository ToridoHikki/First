package com.example.home.first

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class SignUpStep1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Step 1"

        button.setOnClickListener {
            val intent = Intent(this, SignUpStep2Activity::class.java)
            intent.putExtra("firstName", firstName.text.toString())
            intent.putExtra("lastName", lastName.text.toString())
            intent.putExtra("phoneNumber", phoneNum.text.toString())
            intent.putExtra("email", email.text.toString())
            startActivity(intent)

        }
    }
}
