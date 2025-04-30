package com.aquasnap.yolov8tflite

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView

class LibraryActivity : AppCompatActivity() {

    private lateinit var fishItems: List<FishItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.library)

        // Fish 1
        val imageContainer1 = findViewById<FrameLayout>(R.id.image_container1)
        val fishName1 = findViewById<TextView>(R.id.fish_name1)
        val localName1 = findViewById<TextView>(R.id.local_name1)
        val openDescButton1 = findViewById<ImageButton>(R.id.open_fish1)

// Fish 2
        val imageContainer2 = findViewById<FrameLayout>(R.id.image_container2)
        val fishName2 = findViewById<TextView>(R.id.fish_name2)
        val localName2 = findViewById<TextView>(R.id.local_name2)
        val openDescButton2 = findViewById<ImageButton>(R.id.open_fish2)

// Fish 3
        val imageContainer3 = findViewById<FrameLayout>(R.id.image_container3)
        val fishName3 = findViewById<TextView>(R.id.fish_name3)
        val localName3 = findViewById<TextView>(R.id.local_name3)
        val openDescButton3 = findViewById<ImageButton>(R.id.open_fish3)

// Fish 4
        val imageContainer4 = findViewById<FrameLayout>(R.id.image_container4)
        val fishName4 = findViewById<TextView>(R.id.fish_name4)
        val localName4 = findViewById<TextView>(R.id.local_name4)
        val openDescButton4 = findViewById<ImageButton>(R.id.open_fish4)

// Fish 5
        val imageContainer5 = findViewById<FrameLayout>(R.id.image_container5)
        val fishName5 = findViewById<TextView>(R.id.fish_name5)
        val localName5 = findViewById<TextView>(R.id.local_name5)
        val openDescButton5 = findViewById<ImageButton>(R.id.open_fish5)

// Fish 6
        val imageContainer6 = findViewById<FrameLayout>(R.id.image_container6)
        val fishName6 = findViewById<TextView>(R.id.fish_name6)
        val localName6 = findViewById<TextView>(R.id.local_name6)
        val openDescButton6 = findViewById<ImageButton>(R.id.open_fish6)

// Fish 7
        val imageContainer7 = findViewById<FrameLayout>(R.id.image_container7)
        val fishName7 = findViewById<TextView>(R.id.fish_name7)
        val localName7 = findViewById<TextView>(R.id.local_name7)
        val openDescButton7 = findViewById<ImageButton>(R.id.open_fish7)

// Fish 8
        val imageContainer8 = findViewById<FrameLayout>(R.id.image_container8)
        val fishName8 = findViewById<TextView>(R.id.fish_name8)
        val localName8 = findViewById<TextView>(R.id.local_name8)
        val openDescButton8 = findViewById<ImageButton>(R.id.open_fish8)

// Fish 9
        val imageContainer9 = findViewById<FrameLayout>(R.id.image_container9)
        val fishName9 = findViewById<TextView>(R.id.fish_name9)
        val localName9 = findViewById<TextView>(R.id.local_name9)
        val openDescButton9 = findViewById<ImageButton>(R.id.open_fish9)

// Fish 10
        val imageContainer10 = findViewById<FrameLayout>(R.id.image_container10)
        val fishName10 = findViewById<TextView>(R.id.fish_name10)
        val localName10 = findViewById<TextView>(R.id.local_name10)
        val openDescButton10 = findViewById<ImageButton>(R.id.open_fish10)


        fishItems = listOf(
            FishItem("Humphead Wrasse", "Mameng", R.drawable.wrasse, imageContainer1, fishName1, localName1, openDescButton1),
            FishItem("Yellowtail Fusilier", "Morong", R.drawable.fusilier, imageContainer2, fishName2, localName2, openDescButton2),
            FishItem("Trigger Fish", "Pugot", R.drawable.pugot, imageContainer3, fishName3, localName3, openDescButton3),
            FishItem("Goatfish", "Salmonito", R.drawable.salmonito, imageContainer4, fishName4, localName4, openDescButton4),
            FishItem("Yellowfin Tuna", "Ahi", R.drawable.ahi, imageContainer5, fishName5, localName5, openDescButton5),
            FishItem("Needle Fish", "Tapog", R.drawable.tapog, imageContainer6, fishName6, localName6, openDescButton6),
            FishItem("Rabbit Fish", "Kitong", R.drawable.kitong, imageContainer7, fishName7, localName7, openDescButton7),
            FishItem("Sea Bass Fish", "Apahap", R.drawable.apahap, imageContainer8, fishName8, localName8, openDescButton8),
            FishItem("Parrot Fish", "Mulmul", R.drawable.mulmul, imageContainer9, fishName9, localName9, openDescButton9),
            FishItem("Mackerel Tuna", "Tulingan", R.drawable.tulingan, imageContainer10, fishName10, localName10, openDescButton10)
        )



        displayFishList(fishItems)

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = fishItems.filter {
                    it.fishName.contains(newText ?: "", ignoreCase = true) ||
                            it.localName.contains(newText ?: "", ignoreCase = true)
                }
                displayFishList(filteredList)
                return true
            }
        })

        for (fish in fishItems) {
            fish.openButton.setOnClickListener {
                val intent = Intent(this, FishDescriptionActivity::class.java)
                intent.putExtra("fishName", fish.fishName)
                intent.putExtra("fishLocalName", fish.localName)
                intent.putExtra("fishImageResId", fish.imageResId)
                startActivity(intent)
            }
        }
    }

    private fun displayFishList(filteredFishItems: List<FishItem>) {
        for (fish in fishItems) {
            fish.container.visibility = FrameLayout.GONE
        }

        for (fish in filteredFishItems) {
            fish.container.visibility = FrameLayout.VISIBLE
        }
    }
}

data class FishItem(
    val fishName: String,
    val localName: String,
    val imageResId: Int,
    val container: FrameLayout,
    val fishNameTextView: TextView,
    val localNameTextView: TextView,
    val openButton: ImageButton
)
