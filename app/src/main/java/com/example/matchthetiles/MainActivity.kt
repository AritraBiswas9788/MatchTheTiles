package com.example.matchthetiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etname : TextView = findViewById(R.id.editTextPersonName)
        val radioButton16 : RadioButton = findViewById(R.id.radioButton16)
        val radioButton24 : RadioButton = findViewById(R.id.radioButton24)
        val radioButtonTime : RadioButton = findViewById(R.id.radioButtonTime)
        val radioButtonMoves : RadioButton = findViewById(R.id.radioButtonMoves)
        val buttonStartGame : Button = findViewById(R.id.buttonStartGame)

        buttonStartGame.setOnClickListener{
            if(radioButton16.isChecked){
                val intent = Intent(this, SmallGridActivity::class.java)
                intent.putExtra("name", etname.text.toString())
                if(radioButtonTime.isChecked){
                    intent.putExtra("type", "time")
                } else {
                    intent.putExtra("type", "moves")
                }
                startActivity(intent)
            } else if(radioButton24.isChecked){
                val intent = Intent(this, BigGridActivity::class.java)
                intent.putExtra("name", etname.text.toString())
                if(radioButtonTime.isChecked){
                    intent.putExtra("type", "time")
                } else {
                    intent.putExtra("type", "moves")
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "please select no. of tiles", Toast.LENGTH_SHORT).show()
            }
        }
    }
}