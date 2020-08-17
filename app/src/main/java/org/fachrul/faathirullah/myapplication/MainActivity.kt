package org.fachrul.faathirullah.myapplication


import android.app.Activity
import android.content.Context
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import org.fachrul.faathirullah.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName:MyName = MyName("Fachrul Faathirullah")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//kegunaan data binding mempersingkat coding yang kita buat, idak perlu lagi menggunakan findViewById, menggunakan pattern MVVM
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        findViewById<Button>(R.id.btn_done).setOnClickListener {
//            addNickname(it)
//        }
        binding.myName = myName
        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }


    private fun addNickname(view: View){

        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
          // untuk me re create data
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            btnDone.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
