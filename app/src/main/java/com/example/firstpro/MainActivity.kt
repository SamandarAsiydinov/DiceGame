package com.example.firstpro

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_browser.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn2.isEnabled = false
        gameFun()
    }

    private fun gameFun() {
        var sum1 = 0
        var sum1Saver = 0
        var sum2Saver = 0
        var sum2 = 0
        var count = 100
        val animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        limit.setOnClickListener {
            if (count > 200) {
                count = 100
                limit.text = count.toString()
            } else {
                count += 100
                limit.text = count.toString()
            }
        }
        btn1.setOnClickListener {
            btn1.isEnabled = false
            btn2.isEnabled = true

            val random = Random.nextInt(1, 7)
            val random2 = Random.nextInt(1, 7)

            score.text = (random + random2).toString()

            img1.startAnimation(animation)
            img1.setImageResource(
                when (random) {
                    1 -> R.drawable.dice1
                    2 -> R.drawable.dice2
                    3 -> R.drawable.dice3
                    4 -> R.drawable.dice4
                    5 -> R.drawable.dice5
                    6 -> R.drawable.dice6
                    else -> R.drawable.dice1
                }
            )
            img2.startAnimation(animation)
            img2.setImageResource(
                when (random2) {
                    1 -> R.drawable.dice1
                    2 -> R.drawable.dice2
                    3 -> R.drawable.dice3
                    4 -> R.drawable.dice4
                    5 -> R.drawable.dice5
                    6 -> R.drawable.dice6
                    else -> R.drawable.dice1
                }
            )
            sum1 = random + random2
            sum1Saver += sum1
            txt1.text = sum1Saver.toString()
            sum1 = 0

            if (sum1Saver >= count) {
                customAlertDialog()
                btn1.isEnabled = false
                btn2.isEnabled = false
            }
        }

        btn2.setOnClickListener {
            btn1.isEnabled = true
            btn2.isEnabled = false
            val random = Random.nextInt(1, 7)
            val random2 = Random.nextInt(1, 7)

            score.text = (random + random2).toString()

            img1.startAnimation(animation)
            img1.setImageResource(
                when (random) {
                    1 -> R.drawable.dice1
                    2 -> R.drawable.dice2
                    3 -> R.drawable.dice3
                    4 -> R.drawable.dice4
                    5 -> R.drawable.dice5
                    6 -> R.drawable.dice6
                    else -> R.drawable.dice1
                }
            )
            img2.startAnimation(animation)
            img2.setImageResource(
                when (random2) {
                    1 -> R.drawable.dice1
                    2 -> R.drawable.dice2
                    3 -> R.drawable.dice3
                    4 -> R.drawable.dice4
                    5 -> R.drawable.dice5
                    6 -> R.drawable.dice6
                    else -> R.drawable.dice1
                }
            )
            sum2 = random + random2
            sum2Saver += sum2
            txt2.text = sum2Saver.toString()
            sum2 = 0
            if (sum2Saver >= count) {
                customAlertDialog()
                btn1.isEnabled = false
                btn2.isEnabled = false

            }
        }
        refresh_btn.setOnClickListener {
            sum1Saver = 0
            sum2Saver = 0
            count = 100
            limit.text = count.toString()
            score.text = (0).toString()
            btn1.isEnabled = true
            btn2.isEnabled = false
            txt1.text = sum1Saver.toString()
            txt2.text = sum2Saver.toString()
        }
    }


    private fun customAlertDialog() {
        val factory = LayoutInflater.from(this)
        val dialogView: View = factory.inflate(R.layout.alert_dialog, null)
        val dialog = AlertDialog.Builder(this).create()
        dialog.setView(dialogView)
        dialogView.findViewById<View>(R.id.okey).setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}