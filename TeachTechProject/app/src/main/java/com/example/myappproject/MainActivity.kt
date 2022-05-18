package com.example.myappproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myappproject.models.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import java.lang.Exception
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    companion object{
        var resultTest = HashMap<Int, String>()
        var currentTest : Int =0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.landingFragment -> bottomNavigationView.visibility = View.GONE
                R.id.entryFragment -> bottomNavigationView.visibility = View.GONE
                R.id.loginFragment -> bottomNavigationView.visibility = View.GONE
                R.id.signUpFragment -> bottomNavigationView.visibility = View.GONE
                else -> bottomNavigationView.visibility = View.VISIBLE
            }
        }

        //create Subject
        val subjPref =  getSharedPreferences("subjects",Context.MODE_PRIVATE)
        val subject = Subject(1,"Sample Subject",6,1)
        subjPref.edit().putString(subject.id.toString(),Gson().toJson(subject)).apply()

        //create Test
        val testPref =  getSharedPreferences("tests",Context.MODE_PRIVATE)
        val testSample = Test(1,1,1,1)
        testPref.edit().putString(testSample.id.toString(),Gson().toJson(testSample)).apply()

        val testSample2 = Test(2,1,1,1)
        testPref.edit().putString(testSample2.id.toString(),Gson().toJson(testSample2)).apply()

        //create questions
        val rowAns = ArrayList<String>()
        rowAns.add("Aida")
        rowAns.add("Anu")
        rowAns.add("Aldiyar")
        val q1 = Question(1,"Where is Aldiyar?", rowAns.clone() as ArrayList<String>,"Aldiyar",1)
        rowAns.clear()
        rowAns.add("2")
        rowAns.add("3")
        rowAns.add("4")
        val q2 = Question(2,"2+2=?",rowAns,"4",1)
        Log.d("quiz1",q1.toString())
        Log.d("quiz2",q2.toString())

        val questionPref =  getSharedPreferences("questions",Context.MODE_PRIVATE)
        questionPref.edit().putString(q1.id.toString(),Gson().toJson(q1)).apply()
        questionPref.edit().putString(q2.id.toString(),Gson().toJson(q2)).apply()

        rowAns.clear()
        rowAns.add("4")
        rowAns.add("5")
        rowAns.add("6")
        val q3 = Question(3,"how many oceans are there on earth?", rowAns.clone() as ArrayList<String>,"5",2)
        rowAns.clear()
        rowAns.add("10900")
        rowAns.add("9500")
        rowAns.add("10000")
        val q4 = Question(4,"How deep is the Mariana Trench?", rowAns.clone() as ArrayList<String>,"10900",2)
        rowAns.clear()
        rowAns.add("Bruce Wayne")
        rowAns.add("Jack Holmes")
        rowAns.add("Druce Wine")
        val q5 = Question(5,"What is batman's name?", rowAns.clone() as ArrayList<String>,"Bruce Wayne",2)

        questionPref.edit().putString(q3.id.toString(),Gson().toJson(q3)).apply()
        questionPref.edit().putString(q4.id.toString(),Gson().toJson(q4)).apply()
        questionPref.edit().putString(q5.id.toString(),Gson().toJson(q5)).apply()
        ///////

        val testStudent = Student("test","pass","testName","testSurname",LocalDate.parse("2001-12-12"),1, Group(0,"NULL"))

        val email = testStudent.login
        val pass = testStudent.password

        val sharedPreference =  getSharedPreferences("users",Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("$email $pass",Gson().toJson(testStudent))
        editor.apply()

    }

    fun changeUserData(firstname: String, surname: String, pass : String): Boolean{
        return try {
            val student = getCurrentUser()
            val oldPass = student.password
            student.name=firstname
            student.surname= surname
            student.password=pass
            Log.d("changeDataMain",student.name)

            val sharedPreference =  getSharedPreferences("users",Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("${student.login} $oldPass").apply()
            editor.putString("${student.login} $pass",Gson().toJson(student)).apply() // update

            val currentUserPref = getSharedPreferences("currentUser",Context.MODE_PRIVATE)
            currentUserPref.edit().putString("existUser",Gson().toJson(student)).apply() // change current user
            true
        } catch (e : Exception){
            e.printStackTrace()
            false
        }
    }


    fun checkAnswer(result:HashMap<Int, String>,student: Student){
        Log.d("quizRes",result.toString())
        var score : Int = 0
        val questionPref =  getSharedPreferences("questions",Context.MODE_PRIVATE)
        Log.d("quizDb",questionPref.all.toString())
//        val testId : Int
        result.keys.forEach{ key ->
            Log.d("quizFor",key.toString())
            if (result[key]==Gson().fromJson(questionPref.getString(key.toString(),"null"),Question::class.java).correctAnswer)
                score++
//            testId = result[key].
        }
        val studentResult = TestResult(getAllTestResults().size+1,student, currentTest,score) // вариант с перезаписью
        val testResPref =  getSharedPreferences("testResults",Context.MODE_PRIVATE)
        resultTest.clear() // clear
//        testResPref.edit().putString(student.login+" "+student.password,Gson().toJson(studentResult)).apply() старый вариант
        testResPref.edit().putString((getAllTestResults().size+1).toString(),Gson().toJson(studentResult)).apply()
        Toast.makeText(this,score.toString(),Toast.LENGTH_LONG).show()
        currentTest =0
    }

    fun getLastRatePlace():Int{
        val students = getAllStudents()
        return students[students.size-1].ratePlace
    }

    fun logoutStudent():Boolean{
        return try {
            val sharedPr = getSharedPreferences("currentUser", Context.MODE_PRIVATE)
            sharedPr.edit().remove("existUser").apply()
            true
        } catch (e : Exception){
            e.printStackTrace()
            false
        }
    }

    fun getAllStudentsSize():Int{
        val sharedPr = getSharedPreferences("users", Context.MODE_PRIVATE)
        return sharedPr.all.size
    }

    fun getAllQuestions():ArrayList<Question>{
        val result = ArrayList<Question>()
        val sharedPr = getSharedPreferences("questions", Context.MODE_PRIVATE)
        val entities = sharedPr.all
        entities.forEach{ entry ->
            result.add(Gson().fromJson(entry.value.toString(),Question::class.java))
            Log.d("quizGet",Gson().fromJson(entry.value.toString(),Question::class.java).toString())
        }
        return result
    }

    fun getAllTestResults():ArrayList<TestResult>{
        val result = ArrayList<TestResult>()
        val sharedPr = getSharedPreferences("testResults", Context.MODE_PRIVATE)
        val entities = sharedPr.all
        entities.forEach{ entry ->
            result.add(Gson().fromJson(entry.value.toString(),TestResult::class.java))
        }
        return result
    }

    fun getAllStudents():ArrayList<Student>{
        val result = ArrayList<Student>()
        val sharedPr = getSharedPreferences("users", Context.MODE_PRIVATE)
        val entities = sharedPr.all
        entities.forEach{ entry ->  
            result.add(Gson().fromJson(entry.value.toString(),Student::class.java))
        }
        val sortedList =result.sortedWith(compareBy{it.ratePlace})
        // на прямую каст не робит, да затратно, но пока так
        val students = ArrayList<Student>()
        for (obj in sortedList) {
            students.add(obj)
        }
        return students
    }

    fun getCurrentUser():Student{
        val sharedPr = getSharedPreferences("currentUser", Context.MODE_PRIVATE)
        val infoStudent = sharedPr?.getString("existUser","null")
        if (infoStudent=="null")
            return Student()
        return Gson().fromJson(infoStudent,Student::class.java)
    }

    fun changeFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment).commit()
    }
}