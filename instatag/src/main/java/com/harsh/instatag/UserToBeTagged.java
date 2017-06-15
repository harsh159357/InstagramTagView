/*
 * Copyright 2017 Harsh Sharma
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.harsh.instatag;

import android.os.Parcel;
import android.os.Parcelable;

public class UserToBeTagged implements Parcelable {
    private String user_unique_id;
    private Double x_co_ord;
    private Double y_co_ord;

    public UserToBeTagged(String user_unique_id, Double x_co_ord, Double y_co_ord) {
        this.user_unique_id = user_unique_id;
        this.x_co_ord = x_co_ord;
        this.y_co_ord = y_co_ord;

    }

    public String getUser_unique_id() {
        return user_unique_id;
    }

    public void setUser_unique_id(String user_unique_id) {
        this.user_unique_id = user_unique_id;
    }

    public Double getX_co_ord() {
        return x_co_ord;
    }

    public void setX_co_ord(Double x_co_ord) {
        this.x_co_ord = x_co_ord;
    }

    public Double getY_co_ord() {
        return y_co_ord;
    }

    public void setY_co_ord(Double y_co_ord) {
        this.y_co_ord = y_co_ord;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.user_unique_id);
        dest.writeValue(this.x_co_ord);
        dest.writeValue(this.y_co_ord);
    }

    protected UserToBeTagged(Parcel in) {
        this.user_unique_id = in.readString();
        this.x_co_ord = (Double) in.readValue(Double.class.getClassLoader());
        this.y_co_ord = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserToBeTagged> CREATOR = new Parcelable.Creator<UserToBeTagged>() {
        @Override
        public UserToBeTagged createFromParcel(Parcel source) {
            return new UserToBeTagged(source);
        }

        @Override
        public UserToBeTagged[] newArray(int size) {
            return new UserToBeTagged[size];
        }
    };
}