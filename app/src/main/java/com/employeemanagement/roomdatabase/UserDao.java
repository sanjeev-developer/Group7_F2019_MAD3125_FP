package com.employeemanagement.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    //show all data
    @Query("select * from user")
    List<User> loadAllUsers();

    //fetch user by id
    @Query("select * from user where id = :id")
    User loadUserById(int id);

    //find user by its name
    // @Query("select * from user where name = :firstName and lastName = :lastName")
    // List<User> findUserByNameAndLastName(String firstName, String lastName);

    //insert user
    @Insert(onConflict = REPLACE)
    void insertUser(User user);

    //delete user
    @Delete
    void deleteUser(User user);

    //delete user by name
//    @Query("delete from user where name like :name OR lastName like :name")
//    int deleteUsersByName(String name);

    //replace or insert by name
    @Insert(onConflict = REPLACE)
    void insertOrReplaceUsers(User... users);

    //delete multiple users
    @Delete
    void deleteUsers(User user1, User user2);

    //delete all database
    @Query("DELETE FROM User")
    void deleteAll();
}