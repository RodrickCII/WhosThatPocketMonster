package com.example.mobileappdev2025

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    private var score :Int = 0;
    var img_num: Int = 0;
    var correctionChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // above init layout ui

        //pickRandomNumber()
        findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.sirfetchd_silhouette)
        setScore(0, 0)
    }

    fun radioButtonOnClick(view: View)
    {
        if ((img_num == 0) && view.id == R.id.Sirfectch_d){
            correctionChecked = true
        }

        else if ((img_num == 2) && view.id == R.id.Glalie){
            correctionChecked = true
        }

        else if ((img_num == 4) && view.id == R.id.Delphox){
            correctionChecked = true
        }

        else if ((img_num == 6) && view.id == R.id.Dedenne){
            correctionChecked = true
        }

        else
            correctionChecked = false
    }

    fun submitButtonOnClick(view: View)
    {
        if(img_num < 7) {
            if(img_num == 0 || img_num == 2 || img_num == 4 || img_num == 6) {
                if (correctionChecked) {
                    setScore(score + 1, img_num + 1)
                } else {
                    setScore(score - 1, img_num + 1)
                }

            } else {
                setScore(score, img_num + 1)
            }

            nextButtonOnClick()
        }

        else {
            findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.sirfetchd_silhouette)
            img_num = 0
        }
    }

    fun setScore(_score: Int, _img_num: Int)
    {
        score = _score;
        img_num = _img_num;

        // vari = (condition) ? true : false;
        // findViewById<ImageView>(R.id.you_won_image).visibility = if (score > 5) View.VISIBLE else View.INVISIBLE;

        findViewById<TextView>(R.id.score_text).text = "Score: $score"
    }

    fun nextButtonOnClick() {

        if(img_num == 0 || img_num == 2 || img_num == 4 || img_num == 6) {
            findViewById<Button>(R.id.submit_button).text = "Submit"
        }

        else if (img_num == 1 || img_num == 3 || img_num == 5 || img_num == 7) {
            findViewById<Button>(R.id.submit_button).text = "Next"
        }

            if (img_num == 0) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.sirfetchd_silhouette)
            }

            else if (img_num == 1) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.sirfetchd_reveal)
            }

            else if (img_num == 2) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.glalie_silhouette)
            }

            else if (img_num == 3) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.glalie_reveal)
            }

            else if (img_num == 4) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.delphox_silhouette)
            }

            else if (img_num == 5) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.delphox_reveal)
            }

            else if (img_num == 6) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.dedenne_silhouette)
            }

            else if (img_num == 7) {
                findViewById<ImageView>(R.id.you_won_image).setImageResource(R.drawable.dedenne_reveal)
            }

            correctionChecked = false
        }
    }