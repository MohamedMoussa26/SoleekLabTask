package com.example.em7mdmoussa.soleeklabtask.Data.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class countryitem implements Parcelable {

    private String name, id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Creator<countryitem> getCREATOR() {
        return CREATOR;
    }

    public countryitem(String name, String id) {
        this.name = name;
        this.id = id;
    }

    protected countryitem(Parcel in) {
        name = in.readString();
        id = in.readString();
    }

    public static final Creator<countryitem> CREATOR = new Creator<countryitem>() {
        @Override
        public countryitem createFromParcel(Parcel in) {
            return new countryitem(in);
        }

        @Override
        public countryitem[] newArray(int size) {
            return new countryitem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(id);
    }
}
