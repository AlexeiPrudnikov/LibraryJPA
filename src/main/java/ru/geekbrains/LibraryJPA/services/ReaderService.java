package ru.geekbrains.LibraryJPA.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.LibraryJPA.models.Book;
import ru.geekbrains.LibraryJPA.models.Reader;
import ru.geekbrains.LibraryJPA.repositories.ReaderRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    public List<Reader> getAll(){
       return readerRepository.findAll();
    }
    public Optional<Reader> getReaderByID(long id){
        return readerRepository.findById(id);
    }
    public Reader addReader(String name){
        return readerRepository.save(new Reader(name));
    }
    public Reader updateReader(long id, String name){
        Optional<Reader> result = readerRepository.findById(id);
        if (result != null){
            Reader  reader =  result.get();
            reader.setName(name);
            readerRepository.save(reader);
            return reader;
        }
        return null;
    }
}
