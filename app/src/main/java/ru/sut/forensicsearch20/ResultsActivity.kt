package ru.sut.forensicsearch20

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.util.Log


class ResultsActivity : AppCompatActivity() {

    private lateinit var textViewResults: TextView

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {

        val receivedIntent = intent
        val receivedBaseOS = receivedIntent.getIntArrayExtra("key")?: intArrayOf(0, 0, 0)
        val receivedTargetOS = receivedIntent.getIntArrayExtra("key2")?: intArrayOf(0, 0, 0, 0, 0)
        val receivedSearchArea = receivedIntent.getIntArrayExtra("key3")?: intArrayOf(0, 0, 0, 0)
        val receivedSearchContent = receivedBaseOS + receivedTargetOS + receivedSearchArea
        val resultString: String = receivedSearchContent.joinToString(separator = ", ")
        Log.d("testt", resultString)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        textViewResults = findViewById(R.id.textViewResults)

        val dbHelper = DBHelper(this)
        val database: SQLiteDatabase? = dbHelper.readableDatabase
        /*
        val projection = arrayOf(
            DBHelper.COL_ID,
            DBHelper.COL_NAME,
            DBHelper.COL_INFO,
            DBHelper.COL_TG,
            DBHelper.COL_BG,
            DBHelper.COL_PRICE,
            DBHelper.COL_S_AREA
        )
        */
        val sortOrder = "${DBHelper.COL_ID} ASC"

        val searchBaseOS = "(${DBHelper.COL_BG_Win} = ? OR ${DBHelper.COL_BG_Mac} = ? OR ${DBHelper.COL_BG_Lin} = ?) AND "
        val searchTargetOS = "(${DBHelper.COL_TG_Win} = ? OR ${DBHelper.COL_TG_Mac} = ? OR ${DBHelper.COL_TG_IOS} = ? OR ${DBHelper.COL_TG_And} = ? OR ${DBHelper.COL_TG_Lin} = ?) AND "
        val searchArea = "(${DBHelper.COL_A_Net} = ? OR ${DBHelper.COL_A_Sea} = ? OR ${DBHelper.COL_A_Rec} = ? OR ${DBHelper.COL_A_Bre} = ?)"
        val searchCase = searchBaseOS + searchTargetOS + searchArea
        Log.d("testt", searchCase)
        val cursor = database?.query(
            DBHelper.TABLE_NAME,
            //projection,
            null,
            searchCase,
            receivedSearchContent.map { it.toString() }.toTypedArray(),
            null,
            null,
            sortOrder
        )

        val outputText = StringBuilder()
        cursor?.use {
            while (it.moveToNext()) {
                val name = it.getString(it.getColumnIndexOrThrow(DBHelper.COL_NAME))
                val info = it.getString(it.getColumnIndexOrThrow(DBHelper.COL_INFO))
                val s_os = it.getString(it.getColumnIndexOrThrow(DBHelper.COL_BG))
                val t_os = it.getString(it.getColumnIndexOrThrow(DBHelper.COL_TG))
                val price = it.getString(it.getColumnIndexOrThrow(DBHelper.COL_PRICE))
                val area = it.getString(it.getColumnIndexOrThrow(DBHelper.COL_S_AREA))
                outputText.append("Название приложения: $name\n\n Цена: $price \n\n Область применения: $area \n\n $info\n Поддерживаемые ОС:\n $s_os\n Что может анализировать:\n $t_os\n\n---------------------------------\n" )
            }

        }
        textViewResults?.text = if (outputText.isNotEmpty()) {
            outputText.toString()
        } else {
            "По данному запросу ничего не найдено"
        }
    }
}