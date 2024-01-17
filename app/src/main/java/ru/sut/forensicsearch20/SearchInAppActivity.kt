package ru.sut.forensicsearch20

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View


class SearchInAppActivity : AppCompatActivity() {

    private lateinit var checkBoxCriteria1Option1: CheckBox
    private lateinit var checkBoxCriteria1Option2: CheckBox
    private lateinit var checkBoxCriteria1Option3: CheckBox
    private lateinit var checkBoxCriteria2Option1: CheckBox
    private lateinit var checkBoxCriteria2Option2: CheckBox
    private lateinit var checkBoxCriteria2Option3: CheckBox
    private lateinit var checkBoxCriteria2Option4: CheckBox
    private lateinit var checkBoxCriteria2Option5: CheckBox
    private lateinit var checkBoxCriteria3Option1: CheckBox
    private lateinit var checkBoxCriteria3Option2: CheckBox
    private lateinit var checkBoxCriteria3Option3: CheckBox
    private lateinit var checkBoxCriteria3Option4: CheckBox
    private lateinit var buttonSearch: Button
    // Win MacOS Lin
    var baseOS = intArrayOf(0, 0, 0)
    // Win MacOS IOS Android FAT
    var targetOS = intArrayOf(0, 0, 0, 0, 0)
    // Net Search Recovery Break
    var searchArea = intArrayOf(0, 0, 0, 0)

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
        checkBoxCriteria2Option5 = findViewById(R.id.checkBoxCriteria2Option6)
        checkBoxCriteria3Option1 = findViewById(R.id.checkBoxCriteria3Option1)
        checkBoxCriteria3Option2 = findViewById(R.id.checkBoxCriteria3Option2)
        checkBoxCriteria3Option3 = findViewById(R.id.checkBoxCriteria3Option3)
        checkBoxCriteria3Option4 = findViewById(R.id.checkBoxCriteria3Option4)
        buttonSearch = findViewById(R.id.buttonSearch)


        checkBoxCriteria1Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                baseOS[0] = 1
            } else {
                baseOS[0] = 0
            }
        }

        checkBoxCriteria1Option2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                baseOS[1] = 1
            } else {
                baseOS[1] = 0
            }
        }

        checkBoxCriteria1Option3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                baseOS[2] = 1
            } else {
                baseOS[2] = 0
            }
        }

        checkBoxCriteria2Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                targetOS[0] = 1
            } else {
                targetOS[0] = 0
            }
        }

        checkBoxCriteria2Option2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                targetOS[1] = 1
            } else {
                targetOS[1] = 0
            }
        }

        checkBoxCriteria2Option3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                targetOS[2] = 1
            } else {
                targetOS[2] = 0
            }
        }

        checkBoxCriteria2Option4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                targetOS[3] = 1
            } else {
                targetOS[3] = 0
            }
        }

        checkBoxCriteria2Option5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                targetOS[4] = 1
            } else {
                targetOS[4] = 0
            }
        }

        checkBoxCriteria3Option1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                searchArea[0] = 1
            } else {
                searchArea[0] = 0
            }
        }

        checkBoxCriteria3Option2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                searchArea[1] = 1
            } else {
                searchArea[1] = 0
            }
        }

        checkBoxCriteria3Option3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                searchArea[2] = 1
            } else {
                searchArea[2] = 0
            }
        }

        checkBoxCriteria3Option4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                searchArea[3] = 1
            } else {
                searchArea[3] = 0
            }
        }

        buttonSearch.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("key", baseOS)
            intent.putExtra("key2", targetOS)
            intent.putExtra("key3", searchArea)
            startActivity(intent)
        }
    }
    }
