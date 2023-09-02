package com.example.matchthetiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class SmallGridActivity : AppCompatActivity() {
    private var f=0
    private var selected = -1
    private lateinit var isOpen : ArrayList<Boolean>
    private val TilesList = ArrayList<ImageView>()
    private var randomArray = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_grid)


//        val size = intent.getIntExtra("size")
        val size =16

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



    }

    private fun onTileClicked(i: Int) {
        if(isOpen[i]) return
        if(selected==-1){

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
            selected = randomArray[i]

        }
        else {

        }
    }
}