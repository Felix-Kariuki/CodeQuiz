package com.flexcode.codequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionList = Constants.getQuestions()

    }
}