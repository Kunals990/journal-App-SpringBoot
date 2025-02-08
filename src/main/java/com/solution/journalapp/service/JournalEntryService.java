package com.solution.journalapp.service;

import com.solution.journalapp.entity.JournalEntry;
import com.solution.journalapp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        try{
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepository.save(journalEntry);

        }catch (Exception e){
            log.error("Error saving journal entry", e);
        }

    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findEntryById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteEntryById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }

    public void updateEntryById(ObjectId id, JournalEntry journalEntry){
        journalEntry.setId(id);
        journalEntryRepository.save(journalEntry);
    }
}
