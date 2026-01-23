package com.example.cajeroservice.Service;

import com.example.cajeroservice.JPA.DenominacionJPA;
import com.example.cajeroservice.Repository.DenominacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenominacionService {

    @Autowired
    private DenominacionRepository denominacionRepository;

    public List<DenominacionJPA> getAll() {
        return denominacionRepository.findAll();
    }
}
