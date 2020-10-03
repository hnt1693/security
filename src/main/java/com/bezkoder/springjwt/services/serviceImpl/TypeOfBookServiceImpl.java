package com.bezkoder.springjwt.services.serviceImpl;

import com.bezkoder.springjwt.entities.TypeOfBook;
import com.bezkoder.springjwt.repository.TypeOfBookRepository;
import com.bezkoder.springjwt.services.TypeOfBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfBookServiceImpl implements TypeOfBookService {
    @Autowired
    private TypeOfBookRepository typeRepo;
    @Override
    public List<TypeOfBook> getAll() {
        return typeRepo.findAll();
    }
}
