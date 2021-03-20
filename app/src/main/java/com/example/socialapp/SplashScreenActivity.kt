package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser


        /**If user is not authorized, send him to SignInActivity to authenticate with google
         * else send him to MainActivity  */
        Handler().postDelayed({
               if (user != null) {
                   val mainIntent = Intent(this, MainActivity::class.java)
                   startActivity(mainIntent)
                   finish()
               } else {
                   val signInIntent = Intent(this, SignInActivity::class.java)
                   startActivity(signInIntent)
                   finish()
               }

        }, 1500)
    }
}