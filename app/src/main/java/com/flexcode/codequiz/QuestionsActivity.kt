package com.flexcode.codequiz


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers:Int = 0
    private var mUserName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //getting the userName from put Extra in intent
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        setContentView(R.layout.activity_questions)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)

        //On click for submit button to check correctness of an answer
        btnSubmit.setOnClickListener(this)

    }

    //function for setting a question and its answers
    private fun setQuestion(){
        /*mCurrentPosition = 1*///testing not needed anymore so as to transition to next quiz
        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        //setting the btn to submit or finish accordingly
        if (mCurrentPosition == mQuestionList!!.size) {
            btnSubmit.text = getString(R.string.FINISH)
        }else {
            btnSubmit.text = getString(R.string.submit)
        }

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuiz.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.OptionOne
        tvOptionTwo.text = question.OptionTwo
        tvOptionThree.text = question.OptionThree
        tvOptionFour.text = question.OptionFour
    }

    //changing the default options view to default color and bg
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tvOptionOne)
        options.add(1,tvOptionTwo)
        options.add(2,tvOptionThree)
        options.add(3,tvOptionFour)

        //using for loop to assign the default color,bg for the options
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.quiz_option_bg
            )
        }
    }

    //implementing onclick listener added on the class so as to use onclick listener on options
    //selecting the bg  option and changing border color
    //click listeners for btn and answers or options
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvOptionOne ->{
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(tvOptionTwo,2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(tvOptionThree,3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(tvOptionFour,4)
            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    //moving to next question
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }//result of finishing the questions / result
                        else -> {
                            //moving over to the result page
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else {
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    //checking correct answer in the question
                    if (question!!.CorrectAnswer != mSelectedOptionPosition){
                        //setting wrong bg since selected option is wrong
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_bg)
                    }else {
                        //Increasing the number of correct answers by one
                        mCorrectAnswers++
                    }
                    //setting the bg for option with correct answer
                    answerView(question.CorrectAnswer, R.drawable.correct_option_bg)

                    //Changing button from submit to go to next question or finish
                    //if its  the last question then.....
                    if (mCurrentPosition == mQuestionList!!.size) {
                        btnSubmit.text = getString(R.string.FINISH)
                    }//if not the last question ...
                    else {
                        btnSubmit.text = getString(R.string.next)
                    }
                    //setting selected position back to zero so as to go to next quiz
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    //function for clicking btn and setting the drawable bg for correct and wrong
    private fun answerView(answer:Int, drawableView:Int){
        when(answer) {
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            4 -> {
                tvOptionFour.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
        }
    }

    //function for selected option in order to change it color on click
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_bg
        )
    }
}