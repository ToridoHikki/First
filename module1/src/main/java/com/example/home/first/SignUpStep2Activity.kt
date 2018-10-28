package com.example.home.first

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_sign_up_step2.*

class SignUpStep2Activity : AppCompatActivity() {

//    override fun onSaveInstanceState(outState: Bundle?) {
//        super.onSaveInstanceState(outState)
//        outState?.putBoolean("footBall", cbFootball.isChecked)
//        outState?.putBoolean("tennis", cbTennis.isChecked)
//        outState?.putBoolean("pingpong", cbPingpong.isChecked)
//        outState?.putBoolean("swimming", cbSwimming.isChecked)
//        outState?.putBoolean("volleyball", cbVolleyball.isChecked)
//        outState?.putBoolean("basketball", cbBasketball.isChecked)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_step2)
//        if (savedInstanceState != null) {
//            cbFootball.isChecked = savedInstanceState.getBoolean("footBall")
//        }
        supportActionBar?.title = "Step 2"

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                salary.text = "Your salary: ${progress * 100} dollars"
            }
        })
        button.setOnClickListener {
            val firstName = intent.getStringExtra("firstName")
            val lastName = intent.getStringExtra("lastName")
            val phoneNumber = intent.getStringExtra("phoneNumber")
            val email = intent.getStringExtra("email")

            val intent = Intent(this, SignUpStep3Activity::class.java)
            intent.putExtra("firstName", firstName)
            intent.putExtra("lastName", lastName)
            intent.putExtra("phoneNumber", phoneNumber)
            intent.putExtra("email", email)
            intent.putExtra("salary", seekBar.progress)
            startActivity(intent)
        }

//        val firstName = intent.getStringExtra("firstName")
////        supportActionBar?.title = "Hello $firstName"
    }
}
