package com.example.matchthetiles

import android.os.Bundle
import android.service.quicksettings.Tile
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.Stack

class BigGridActivity : AppCompatActivity() {

    private var isClicked: Boolean = false
    private var clickedIndex: Int = 0
    private lateinit var TileList: Array<ImageView>
    private lateinit var ImageStack:Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_grid)
        TileList = arrayOf(
            findViewById(R.id.Tile1),
            findViewById(R.id.Tile2),
            findViewById(R.id.Tile3),
            findViewById(R.id.Tile4),
            findViewById(R.id.Tile5),
            findViewById(R.id.Tile6),
            findViewById(R.id.Tile7),
            findViewById(R.id.Tile8),
            findViewById(R.id.Tile9),
            findViewById(R.id.Tile10),
            findViewById(R.id.Tile11),
            findViewById(R.id.Tile12),
            findViewById(R.id.Tile13),
            findViewById(R.id.Tile14),
            findViewById(R.id.Tile15),
            findViewById(R.id.Tile16),
            findViewById(R.id.Tile17),
            findViewById(R.id.Tile18),
            findViewById(R.id.Tile19),
            findViewById(R.id.Tile20),
            findViewById(R.id.Tile21),
            findViewById(R.id.Tile22),
            findViewById(R.id.Tile23),
            findViewById(R.id.Tile24)
        )
        ImageStack= arrayOf(
            R.drawable.img1,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img12
        )
        ImageStack.shuffle()
        for(tile in TileList)
            tile.setImageResource(R.drawable.tile)

        for ((index,tile) in TileList.withIndex())
        {
            tile.setOnClickListener {
                if(isClicked) {
                    tile.setImageResource(ImageStack[index])
                    if(!checkTileMatched(index))
                    {Thread.sleep(500)
                        TileList[clickedIndex].setImageResource(R.drawable.tile)
                        tile.setImageResource(R.drawable.tile)
                    }
                    isClicked=false
                }
                else
                {
                    clickedIndex=index
                    tile.setImageResource(ImageStack[index])
                    isClicked=true
                }
            }
        }
    }

    private fun checkTileMatched(index: Int):Boolean {
        return ImageStack[index]==ImageStack[clickedIndex]
    }
}