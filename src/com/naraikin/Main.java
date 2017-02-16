package com.naraikin;

import com.naraikin.crud.Student;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Student.create("Arina", "2013-09-04", "w", 1);
        Student.updateName("IRina", "Arina");
        //Student.delete("Arina", "2013-09-04", "w", 1);

        Student.getAll();

    }

}
