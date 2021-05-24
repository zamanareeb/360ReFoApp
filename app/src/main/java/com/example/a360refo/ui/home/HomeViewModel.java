package com.example.a360refo.ui.home;


import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private String imgUrl;

    public HomeViewModel(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}