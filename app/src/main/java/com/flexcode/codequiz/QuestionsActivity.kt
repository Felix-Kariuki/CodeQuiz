package com.flexcode.codequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionList = Constants.getQuestions()
        Log.i("Question Size", "${questionList.size}")

        val currentPosition = 1
        val question: Question? = questionList[currentPosition -1]

        progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition" + "/" + progressBar.max

        tvQuiz.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.OptionOne
        tvOptionTwo.text = question.OptionTwo
        tvOptionThree.text = question.OptionThree
        tvOptionFour.text = question.OptionFour


    }
}