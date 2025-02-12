package com.solution.journalapp.service;

import com.solution.journalapp.entity.JournalEntry;
import com.solution.journalapp.entity.User;
import com.solution.journalapp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        }catch (Exception e){
            log.error("Error saving journal entry", e);
        }

    }

    public void saveEntry(JournalEntry journalEntry) {
        try{
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

    public void deleteEntryById(ObjectId id, String userName){
        try{
            User user = userService.findByUserName(userName);
            user.getJournalEntries().removeIf(x->x.getId().equals(id));
            userService.saveEntry(user);
            journalEntryRepository.deleteById(id);
        }catch (Exception e){
            log.error("Error saving journal entry", e);
        }


    }

    public void updateEntryById(ObjectId id, JournalEntry journalEntry){
        journalEntry.setId(id);
        journalEntryRepository.save(journalEntry);
    }
}
