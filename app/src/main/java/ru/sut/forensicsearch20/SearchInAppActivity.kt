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

        checkBoxCriteria1Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Действия при активации чекбокса
                showToast("Критерий 1 Опция 1 выбрана")
            }
        }

        buttonSearch.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            // Добавьте здесь логику формирования запроса
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
