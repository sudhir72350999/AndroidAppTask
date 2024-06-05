package com.sudhirtheindian.oneclickdriveapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textBox1: EditText = findViewById(R.id.text_box_1)
        val textBox2: EditText = findViewById(R.id.text_box_2)
        val textBox3: EditText = findViewById(R.id.text_box_3)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultText: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val list1 = textBox1.text.toString().split(",").map { it.trim().toInt() }
            val list2 = textBox2.text.toString().split(",").map { it.trim().toInt() }
            val list3 = textBox3.text.toString().split(",").map { it.trim().toInt() }

            val intersect = list1.intersect(list2).intersect(list3)
            val union = list1.union(list2).union(list3)
            val highestNumber = union.maxOrNull()

            val result = """
                Intersection: ${intersect.joinToString(", ")}
                Union: ${union.sorted().joinToString(", ")}
                Highest Number: $highestNumber
            """.trimIndent()

            resultText.text = result
        }
    }
}
