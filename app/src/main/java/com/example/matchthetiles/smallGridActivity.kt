package com.example.matchthetiles

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class SmallGridActivity : AppCompatActivity() {
    private var matchedCount=0
    private var selected = -1
    private lateinit var isOpen : ArrayList<Boolean>
    private val TilesList = ArrayList<ImageView>()
    private var randomArray = ArrayList<Int>()
    private var size = 0
    private var time = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_grid)

//        size = intent.getIntExtra("size")
//        time = intent.getIntExtra("time")
        size = 16
        time = 60

        val TvTime : TextView = findViewById(R.id.timeTextView)

        for(i in 1..(size/2)){
            randomArray.add(i)
            randomArray.add(i)
        }
        randomArray.shuffle()

        for(i in 0..size) isOpen.add(false)

        val TilesList = ArrayList<ImageView>()
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

        for(i in 0..size){
            TilesList[i].setOnClickListener{
                onTileClicked(i)
                Toast.makeText(this, "$i th tile is clicked",Toast.LENGTH_SHORT)
            }
        }

        object : CountDownTimer(time.toLong()*1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                TvTime.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                GameResult(false)
            }
        }.start()



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
            if(randomArray[i]!=randomArray[selected]){
                TilesList[i].setImageResource(R.drawable.tile)
                isOpen[i]= false
                TilesList[selected].setImageResource(R.drawable.tile)
                isOpen[selected]= false
            }
            else{
                matchedCount+=2
            }
        }
        if(matchedCount==size) GameResult(true)
    }

    private fun GameResult(result: Boolean) {
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
            })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }


}