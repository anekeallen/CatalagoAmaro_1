package com.example.catalagoamaro1.dominio;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Sizes implements Parcelable {
    private boolean available;
    private String size;

    protected Sizes(Parcel in) {
        available = in.readByte() != 0;
        size = in.readString();
    }

    public static final Creator<Sizes> CREATOR = new Creator<Sizes>() {
        @Override
        public Sizes createFromParcel(Parcel in) {
            return new Sizes(in);
        }

        @Override
        public Sizes[] newArray(int size) {
            return new Sizes[size];
        }
    };

    public boolean isAvailable() {
        return available;
    }

    public String getSize() {
        return size;
    }

    public Sizes(boolean available, String size) {
        this.available = available;
        this.size = size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (available ? 1 : 0));
        dest.writeString(size);
    }
}
