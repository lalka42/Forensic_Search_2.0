package ru.sut.forensicsearch20

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ResultsActivity : AppCompatActivity() {

    private lateinit var textViewResults: TextView

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        textViewResults = findViewById(R.id.textViewResults)

        val dbHelper = DBHelper(this)
        val cursor = dbHelper.getInformation()
        val stringBuilder = StringBuilder()

        while (cursor.moveToNext()) {
            val info = cursor.getString(cursor.getColumnIndex(DBHelper.Companion.COLUMN_INFO))
            stringBuilder.append(info).append("\n\n")
        }
        cursor.close()

        textViewResults.text = stringBuilder.toString()
    }
}
