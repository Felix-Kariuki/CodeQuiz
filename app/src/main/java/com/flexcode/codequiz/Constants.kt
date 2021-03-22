package com.flexcode.codequiz

object Constants {

    const val USER_NAME: String = "userName"
    const val TOTAL_QUESTIONS: String = "totalQuestions"
    const val CORRECT_ANSWERS: String = "correctAnswers"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        //QUESTION ONE
        val quiz1 = Question(1,
            "Which extension is used to save Kotlin files?",
            ".Kot", ".kt or Kts",
            ".android", ".src",
            2
            )
        questionList.add(quiz1)

        //QUESTION TWO
        val quiz2 = Question(2,
            "How is a multi-line comment is Kotlin Done?",
            "//", "||",
            "/* */", "\\\\",
            3
        )
        questionList.add(quiz2)

        //QUESTION THREE
        val quiz3 = Question(3,
            "The two types of constructors in Kotlin are?",
            "Primary and Secondary constructor", "First and second constructor",
            "None of above", "Constant and parameterized constructor",
            1
        )
        questionList.add(quiz3)

        //QUESTION FOUR
        val quiz4 = Question(4,
            "What handles null exceptions in Kotlin?",
            "sealed classes", "The Kotlin exception",
            "Lambda functions", "Elvis operator",
            4
        )
        questionList.add(quiz4)

        //QUESTION FIVE
        val quiz5 = Question(5,
            "Can java code be converted into Kotlin code",
            "Yes", "MayBe",
            "No", "Not Sure",
            1
        )
        questionList.add(quiz5)

        //QUESTION SIX
        val quiz6 = Question(6,
            "The correct function to get the length of a string in Kotlin is?",
            "str.length", "lengthOf(str)",
            "string(length)", "length.str",
            1
        )
        questionList.add(quiz6)

        //QUESTION SEVEN
        val quiz7 = Question(7,
            "What is the default visibility modifier in Kotlin?",
            "sealed", "private",
            "public", "protected",
            3
        )
        questionList.add(quiz7)


        //QUESTION EIGHT
        val quiz8= Question(8,
            "Which are the basic data types in Kotlin?",
            "Arrays and Booleans", "String and Numbers",
            "Characters", "All of the above",
            4
        )
        questionList.add(quiz8)
        return questionList




    }
}