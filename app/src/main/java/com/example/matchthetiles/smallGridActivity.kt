package com.example.matchthetiles


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.typeOf


class SmallGridActivity : AppCompatActivity() {
    private var matchedCount=0
    private var selected = -1
    private val isOpen = ArrayList<Boolean>()
    private val TilesList = ArrayList<ImageView>()
    private var randomArray = ArrayList<Int>()
    private var size = 16
    private var time = 30
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_grid)

        val name = intent.getStringExtra("name")
        val tvName: TextView = findViewById(R.id.nameTextView)
        tvName.text = "Name : $name"

        val tvTime : TextView = findViewById(R.id.timeTextView)

        timer = object : CountDownTimer(time.toLong() * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvTime.text = "Time left: " + millisUntilFinished / 1000 + "sec"
            }

            override fun onFinish() {
                GameResult(false)
            }
        }.start()

        for(i in 1..(size/2)){
            randomArray.add(i)
            randomArray.add(i)
        }
        randomArray.shuffle()

        for(i in 0..size) isOpen.add(false)

        TilesList.add(findViewById(R.id.Tile1))
        TilesList.add(findViewById(R.id.Tile2))
        TilesList.add(findViewById(R.id.Tile3))
        TilesList.add(findViewById(R.id.Tile4))
        TilesList.add(findViewById(R.id.Tile5))
        TilesList.add(findViewById(R.id.Tile6))
        TilesList.add(findViewById(R.id.Tile7))
        TilesList.add(findViewById(R.id.Tile8))
        TilesList.add(findViewById(R.id.Tile9))
        TilesList.add(findViewById(R.id.Tile10))
        TilesList.add(findViewById(R.id.Tile11))
        TilesList.add(findViewById(R.id.Tile12))
        TilesList.add(findViewById(R.id.Tile13))
        TilesList.add(findViewById(R.id.Tile14))
        TilesList.add(findViewById(R.id.Tile15))
        TilesList.add(findViewById(R.id.Tile16))

        for(i in 0 until size) TilesList[i].setImageResource(R.drawable.tile)
        for(i in 0 until size){
            TilesList[i].setOnClickListener{
                onTileClicked(i)
            }
        }

    }


    private fun onTileClicked(i: Int) {
        if(isOpen[i]) return

        when(randomArray[i]){
            1-> TilesList[i].setImageResource(R.drawable.img1)
            2-> TilesList[i].setImageResource(R.drawable.img2)
            3-> TilesList[i].setImageResource(R.drawable.img3)
            4-> TilesList[i].setImageResource(R.drawable.img4)
            5-> TilesList[i].setImageResource(R.drawable.img5)
            6-> TilesList[i].setImageResource(R.drawable.img6)
            7-> TilesList[i].setImageResource(R.drawable.img7)
            8-> TilesList[i].setImageResource(R.drawable.img8)
            9-> TilesList[i].setImageResource(R.drawable.img9)
            10-> TilesList[i].setImageResource(R.drawable.img10)
            11-> TilesList[i].setImageResource(R.drawable.img11)
            12-> TilesList[i].setImageResource(R.drawable.img12)
        }
        isOpen[i] = true
        if(selected==-1){

            selected = i

        }
        else {
            val j = selected
            if(randomArray[i]!=randomArray[j]){
                val handler = Handler()
                handler.postDelayed(
                    Runnable {
                        TilesList[i].setImageResource(R.drawable.tile)
                        isOpen[i]= false
                        TilesList[j].setImageResource(R.drawable.tile)
                        isOpen[j]= false
                    },
                    500
                )

            }
            else{
                matchedCount+=2
            }
            selected = -1
        }
        if(matchedCount==size) GameResult(true)
    }


    private fun GameResult(result: Boolean) {
        timer.cancel()
        if(result){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("YOU WON!")
            builder.setMessage("Play Again?")
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener{ dialog, which->
                val intent = Intent(this, SmallGridActivity::class.java)
                startActivity(intent)
                finish()
            })
            builder.setNegativeButton("Exit", DialogInterface.OnClickListener{ dialog, which->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("YOU LOST!")
            builder.setMessage("Play Again?")
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener{ dialog, which->
                val intent = Intent(this, SmallGridActivity::class.java)
                startActivity(intent)
                finish()
            })
            builder.setNegativeButton("Exit", DialogInterface.OnClickListener{ dialog, which->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }


}