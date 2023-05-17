package com.management.modelo.repositories;

import java.util.List;

import com.management.modelo.schema.Producto;

public interface QRCodeRepository {

    void generateQrCode(List<Producto> productos);
    Producto readQrCode();
}
