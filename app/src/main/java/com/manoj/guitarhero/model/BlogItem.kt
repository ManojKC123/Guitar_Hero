package com.manoj.guitarhero.model


import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["title"], unique = true)])
data class BlogItem (
    @PrimaryKey(autoGenerate= true)
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "body")
    var body: String? = null,

    @ColumnInfo(name = "picture")
    var picture: String? = null,


    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "username")
    var username: String? = null,



    ): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(body)
        parcel.writeString(picture)
        parcel.writeString(username)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BlogItem> {
        override fun createFromParcel(parcel: Parcel): BlogItem {
            return BlogItem(parcel)
        }

        override fun newArray(size: Int): Array<BlogItem?> {
            return arrayOfNulls(size)
        }
    }
}