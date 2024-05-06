package com.example.st10456346.mypetappfurryflair

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class page_2 : AppCompatActivity() {

    //Implementing each progressbar
    private lateinit var eatProgressBar: ProgressBar
    private lateinit var playProgressBar: ProgressBar
    private lateinit var bathProgressBar: ProgressBar

    private var eat_level = 100
    private var eatDecreaseRate = 7
    private var bath_level = 100
    private var bathDecreaseRate = 7
    private var play_level = 100
    private var playDecreaseRate = 7

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        //Declarations
        val eatbutton = findViewById<Button>(R.id.eatbutton)
        val playbutton = findViewById<Button>(R.id.playbutton)
        val bathbutton = findViewById<Button>(R.id.bathbutton)
        val imageView = findViewById<ImageView>(R.id.kung_fu_panda_image2)
        val displaytext = findViewById<TextView>(R.id.displaytext)
        eatProgressBar = findViewById<ProgressBar>(R.id.eatProgressBar)
        playProgressBar = findViewById<ProgressBar>(R.id.playProgressBar)
        bathProgressBar = findViewById<ProgressBar>(R.id.bathProgressBar)

        //Implementation of Coroutine for  each progressbar
        eatProgressBar.progress = eat_level.toInt()
        val eatingCoroutine = launchEatingCoroutine()
        bathProgressBar.progress = bath_level.toInt()
        val bathingCoroutine = launchBathingroutine()
        playProgressBar.progress = play_level.toInt()
        val playCoroutine = launchPlayCoroutine()


        eatbutton.setOnClickListener {
            imageView.setImageResource(R.drawable.kung_fu_panda_eating)
            displaytext.text = "Thank you for serving me, that was fantastic! I may need to save some for later though"
            eat_level = 100
            eatProgressBar.progress = eat_level.toInt()

        }
        playbutton.setOnClickListener {
            imageView.setImageResource(R.drawable.kung_fu_panda_playing)
            displaytext.text = "Thanks for playing! I'm having a great time, maybe we can play again soon?"
            play_level = 100
            playProgressBar.progress = play_level.toInt()


        }
        bathbutton.setOnClickListener {
            imageView.setImageResource(R.drawable.kung_fu_panda_bathing)
            displaytext.text = "That bath was just what I needed. Thanks for taking care of me, I feel nice and clean now"
            bath_level = 100
            bathProgressBar.progress = bath_level.toInt()
        }

    }

    //Initiating launch for each progressbar
    private fun launchEatingCoroutine(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                if (eat_level > 0) {
                    eat_level -= eatDecreaseRate
                    eatProgressBar.progress = eat_level.toInt()
                }
                delay(2500)
            }
        }
    }

    private fun launchBathingroutine(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                if (bath_level > 0) {
                    bath_level -= bathDecreaseRate
                    bathProgressBar.progress = bath_level.toInt()
                }
                delay(2500)
            }
        }
    }

    private fun launchPlayCoroutine(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                if (play_level > 0) {
                    play_level -= playDecreaseRate
                    playProgressBar.progress = play_level.toInt()
                }
                delay(2500)
            }
        }
    }
}
