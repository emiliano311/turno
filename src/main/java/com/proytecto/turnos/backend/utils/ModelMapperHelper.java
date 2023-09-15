package com.proytecto.turnos.backend.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperHelper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getModelMapper() {
        return modelMapper;
    }
}
