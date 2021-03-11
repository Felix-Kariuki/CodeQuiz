package com.flexcode.codequiz

object Constants {

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        //1
        val quiz1 = Question(1,
            "What country does this flag belong to?",
             R.drawable.argentina,
            "Argentina", "Armenia",
            "Austria", "Australia",
            1
            )
        questionList.add(quiz1)

        //2
        val quiz2 = Question(2,
            "What country does this flag belong to?",
            R.drawable.congo,
            "Namimbia", "Armenia",
            "Zambia", "Congo",
            4
        )
        questionList.add(quiz2)

        //3
        val quiz3 = Question(3,
            "What country does this flag belong to?",
            R.drawable.kenya,
            "Chile", "SouthSudan",
            "Kenya", "Rwanda",
            3
        )
        questionList.add(quiz3)

        //4
        val quiz4 = Question(4,
            "What country does this flag belong to?",
            R.drawable.southafrica,
            "Eritrea", "SouthAfrica",
            "Morocco", "Johannesburg",
            2
        )
        questionList.add(quiz4)

        //5
        val quiz5 = Question(5,
            "What country does this flag belong to?",
            R.drawable.tanzania,
            "Uganda", "Tanzania",
            "Kenya", "Rwanda",
            2
        )
        questionList.add(quiz5)

        //6
        val quiz6 = Question(6,
            "What country does this flag belong to?",
            R.drawable.russia,
            "Moscow", "Tanzania",
            "Russia", "Armenia",
            3
        )
        questionList.add(quiz6)

        //7
        val quiz7 = Question(7,
            "What country does this flag belong to?",
            R.drawable.usa,
            "USA", "Canada",
            "England", "Rwanda",
            1
        )
        questionList.add(quiz7)

        //8
        val quiz8= Question(8,
            "What country does this flag belong to?",
            R.drawable.uganda,
            "Madagascar", "Ethiopia",
            "Djibouti", "Uganda",
            4
        )
        questionList.add(quiz8)
        return questionList
    }
}