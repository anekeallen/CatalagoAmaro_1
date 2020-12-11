package com.example.catalagoamaro1.dominio;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Produto implements Parcelable {

    private String name;
    private String regular_price;
    private String actual_price;
    private String discount_percentage;
    private String installments;
    private String image;
    private Sizes[] sizes;


    protected Produto(Parcel in) {
        name = in.readString();
        regular_price = in.readString();
        actual_price = in.readString();
        discount_percentage = in.readString();
        installments = in.readString();
        image = in.readString();


    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    public Sizes[] getSizes() {
       return sizes;
    }

    public Produto(String name, String regular_price, String actual_price, String discount_percentage, String installments, String image, Sizes[] sizes) {
        this.name = name;
        this.regular_price = regular_price;
        this.actual_price = actual_price;
        this.discount_percentage = discount_percentage;
        this.installments = installments;
        this.image = image;
        this.sizes = sizes;
    }


    public String getName() {
        return name;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public String getActual_price() {
        return actual_price;
    }

    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public String getInstallments() {
        return installments;
    }

    public String getImage() {
        return image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(regular_price);
        dest.writeString(actual_price);
        dest.writeString(discount_percentage);
        dest.writeString(installments);
        dest.writeString(image);


    }
}
