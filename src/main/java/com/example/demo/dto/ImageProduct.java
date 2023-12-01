// Generated with g9.

package com.example.demo.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageProduct implements Serializable {
	private int imageId;
    private String image;
    
    public ImageProduct(com.example.demo.model.ImageProduct imageProduct) {
    	this.imageId = imageProduct.getImageId();
    	this.image = imageProduct.getImage();
    }
}
