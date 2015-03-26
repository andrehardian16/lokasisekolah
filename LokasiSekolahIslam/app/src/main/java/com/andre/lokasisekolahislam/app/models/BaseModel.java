package com.andre.lokasisekolahislam.app.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created by Andre on 3/17/2015.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor(suppressConstructorProperties = true)
public class BaseModel implements Serializable {
    private String id;
    @SerializedName("id_field")
    private int idField;
    private double latitude;
    private double longitude;
    private String jenis;
    private String alamat;
    @SerializedName("nama_institusi")
    private String namaInstitusi;
    /*private String judul;
    private String deskripsi;*/

}
