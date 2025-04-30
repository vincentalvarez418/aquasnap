package com.aquasnap.yolov8tflite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.widget.Button

class HistoryAdapter(
    private val context: Context,
    private val historyList: MutableList<FishHistoryItem>,
    private val deleteItem: (Int) -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = historyList.size

    override fun getItem(position: Int): Any = historyList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.history_item, parent, false)

        val fishNameTextView: TextView = view.findViewById(R.id.fishNameTextView)
        val fishImageView: ImageView = view.findViewById(R.id.fishImageView)
        val timestampTextView: TextView = view.findViewById(R.id.timestampTextView)
        val deleteButton: ImageView = view.findViewById(R.id.deleteButton)

        val fishHistoryItem = historyList[position]

        // Set data to views
        fishNameTextView.text = fishHistoryItem.fishName
        fishImageView.setImageResource(fishHistoryItem.fishImageResId)
        timestampTextView.text = fishHistoryItem.timestamp

        // Set delete button click listener
        deleteButton.setOnClickListener {
            deleteItem(position)
        }

        // Set click listener for fish item to navigate to FishHistoryDescriptionActivity
        view.setOnClickListener {
            val intent = Intent(context, FishHistoryDescriptionActivity::class.java)
            intent.putExtra("fishName", fishHistoryItem.fishName)
            intent.putExtra("fishImageResId", fishHistoryItem.fishImageResId)
            intent.putExtra("timestamp", fishHistoryItem.timestamp)
            context.startActivity(intent)
        }

        return view
    }
}

