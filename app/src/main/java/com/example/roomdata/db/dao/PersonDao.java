package com.example.roomdata.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdata.model.PersonData;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<PersonData> getAll();

    @Insert
    void insertAll(PersonData users);

    @Delete
    void delete(PersonData users);

    @Update
    void update(PersonData users);

}