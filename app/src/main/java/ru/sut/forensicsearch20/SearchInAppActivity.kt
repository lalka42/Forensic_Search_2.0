package ru.sut.forensicsearch20

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class SearchInAppActivity : AppCompatActivity() {

    private lateinit var checkBoxCriteria1Option1: CheckBox
    private lateinit var checkBoxCriteria1Option2: CheckBox
    private lateinit var checkBoxCriteria1Option3: CheckBox
    private lateinit var checkBoxCriteria2Option1: CheckBox
    private lateinit var checkBoxCriteria2Option2: CheckBox
    private lateinit var checkBoxCriteria2Option3: CheckBox
    private lateinit var checkBoxCriteria2Option4: CheckBox
    private lateinit var checkBoxCriteria2Option5: CheckBox
    private lateinit var checkBoxCriteria2Option6: CheckBox
    private lateinit var checkBoxCriteria2Option7: CheckBox
    private lateinit var checkBoxCriteria3Option1: CheckBox
    private lateinit var checkBoxCriteria3Option2: CheckBox
    private lateinit var checkBoxCriteria3Option3: CheckBox
    private lateinit var checkBoxCriteria3Option4: CheckBox
    private lateinit var buttonSearch: Button

    private val OS_LINUX = 1
    private val OS_WINDOWS = 2
    private val OS_MACOS = 4

    private var selectedOS: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_in_app)

        checkBoxCriteria1Option1 = findViewById(R.id.checkBoxCriteria1Option1)
        checkBoxCriteria1Option2 = findViewById(R.id.checkBoxCriteria1Option2)
        checkBoxCriteria1Option3 = findViewById(R.id.checkBoxCriteria1Option3)
        checkBoxCriteria2Option1 = findViewById(R.id.checkBoxCriteria2Option1)
        checkBoxCriteria2Option2 = findViewById(R.id.checkBoxCriteria2Option2)
        checkBoxCriteria2Option3 = findViewById(R.id.checkBoxCriteria2Option3)
        checkBoxCriteria2Option4 = findViewById(R.id.checkBoxCriteria2Option4)
        checkBoxCriteria2Option5 = findViewById(R.id.checkBoxCriteria2Option5)
        checkBoxCriteria2Option6 = findViewById(R.id.checkBoxCriteria2Option6)
        checkBoxCriteria2Option7 = findViewById(R.id.checkBoxCriteria2Option7)
        checkBoxCriteria3Option1 = findViewById(R.id.checkBoxCriteria3Option1)
        checkBoxCriteria3Option2 = findViewById(R.id.checkBoxCriteria3Option2)
        checkBoxCriteria3Option3 = findViewById(R.id.checkBoxCriteria3Option3)
        checkBoxCriteria3Option4 = findViewById(R.id.checkBoxCriteria3Option4)
        buttonSearch = findViewById(R.id.buttonSearch)

        val dbrequest = StringBuilder("SELECT * FROM forensic_table WHERE ")



        checkBoxCriteria1Option3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedOS = selectedOS or OS_LINUX
            } else {
                selectedOS = selectedOS and OS_LINUX.inv()
            }
        }

        checkBoxCriteria1Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedOS = selectedOS or OS_WINDOWS
            } else {
                selectedOS = selectedOS and OS_WINDOWS.inv()
            }
        }

        checkBoxCriteria1Option2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedOS = selectedOS or OS_MACOS
            } else {
                selectedOS = selectedOS and OS_MACOS.inv()
            }
        }

        checkBoxCriteria2Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria2Option2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria2Option3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria2Option4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria2Option5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria2Option6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria2Option7.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

            }
        }

        checkBoxCriteria3Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                dbrequest.append("target_OS_support=1 AND ")
            }
        }

        checkBoxCriteria3Option2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                dbrequest.append("target_OS_support=1 AND ")
            }
        }

        checkBoxCriteria3Option3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                dbrequest.append("target_OS_support=1 AND ")
            }
        }

        checkBoxCriteria3Option4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                dbrequest.append("target_OS_support=1 AND ")
            }
        }

        dbrequest.append("1=1 ")
        buttonSearch.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            // Добавьте здесь логику формирования запроса
            Log.d("SearchInAppActivityt", selectedOS.toString())
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
