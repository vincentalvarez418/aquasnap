package com.aquasnap.yolov8tflite

import android.os.Parcelable
import android.os.Parcel

data class FishHistoryItem(
    val fishName: String,
    val fishImageResId: Int,
    val timestamp: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fishName)
        parcel.writeInt(fishImageResId)
        parcel.writeString(timestamp)
    }

    override fun describeContents(): Int = 0

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<FishHistoryItem> {
            override fun createFromParcel(parcel: Parcel): FishHistoryItem {
                return FishHistoryItem(parcel)
            }

            override fun newArray(size: Int): Array<FishHistoryItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}

