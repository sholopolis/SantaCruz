package com.example.android.santacruz;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * representation of a place that has a location, a name, a phone and a webPage.
 */

public class Place implements Parcelable{
    // name of the place
    private String mPlace;
    // latitud of the location
    private double mLatitud;
    // longitud of the location
    private double mLongitud;
    //phone of the place
    private String mPhone;
    // the place's website
    private String mWebPage;
    // the mini image associated with the place's logo or representative image
    int mImageResourceId;
    // a short description of what the place is
    String mShortDescription;
    // resource id of a more detailed image for the place
    private int mDetailedImageResourceId;
    /**
     * @param place    place of the location
     * @param latitud  latitud coordinate of the place
     * @param longitud longitud coordinate of the place
     * @param phone    the phone number of the place
     * @param webPage  webpage of the place, it can also be a facebook page
     * @param shortDescription   a short description of the place
     */
    public Place(String place, double latitud, double longitud, String phone, String webPage,
                 int imageResourceId, String shortDescription, int detailedImageResourceId) {
        mPlace = new String(place);
        mLatitud = latitud;
        mLongitud = longitud;
        mPhone = new String(phone);
        mWebPage = new String(webPage);
        mImageResourceId = imageResourceId;
        mShortDescription = new String(shortDescription);
        mDetailedImageResourceId = detailedImageResourceId;
    }

    /**
     * @return the name of the place
     */
    public String getNameOfPlace() {
        return mPlace;
    }

    /**
     * @return latitud coordinate of the place
     */
    public double getLatitud() {
        return mLatitud;
    }

    /**
     * @return longitud coordinate of the place
     */
    public double getLongitud() {
        return mLongitud;
    }

    /**
     * @return telephone of the place
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * @return webpage of the place
     */
    public String getWebPage() {
        return mWebPage;
    }

    /**
     * @return the id associated with the image of this place in the resources
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /**
     * @return short description of the place
     */
    public String getShortDescription(){
        return mShortDescription;
    }
    /**
     * @return id for the detail image of the place
     */
    public int getDetailedImageResourceId(){
        return mDetailedImageResourceId;
    }

    // parceable


    public int describeContents() {
        return 0;
    }
    // writes my object to a parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mPlace);
        out.writeDouble(mLatitud);
        out.writeDouble(mLongitud);
        out.writeString(mPhone);
        out.writeString(mWebPage);
        out.writeInt(mImageResourceId);
        out.writeString(mShortDescription);
        out.writeInt(mDetailedImageResourceId);
    }

    public static final Parcelable.Creator<Place> CREATOR
            = new Parcelable.Creator<Place>() {
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        public Place[] newArray(int size) {
            return new Place [size];
        }
    };
    // constructor unfolding the parcel
    private Place(Parcel in) {
        mPlace = in.readString();
        mLatitud = in.readDouble();
        mLongitud = in.readDouble();
        mPhone = in.readString();
        mWebPage = in.readString();
        mImageResourceId = in.readInt();
        mShortDescription = in.readString();
        mDetailedImageResourceId = in.readInt();
    }
}
