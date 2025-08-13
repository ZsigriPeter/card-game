package com.codecool.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllData {
    private List<ImageData> data;

    public List<ImageData> getData() {
        return data;
    }

    public void setData(List<ImageData> data) {
        this.data = data;
    }

    public static class ImageData {
        private int id;
        @JsonProperty("imgStr")
        private String imageString;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageString() {
            return imageString;
        }

        public void setImageString(String imageString) {
            this.imageString = imageString;
        }
    }
}

