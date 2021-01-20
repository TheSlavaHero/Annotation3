package com.company;

import java.io.Serializable;

public class ClassWithFields implements Serializable {
    @Save(directory = "C:\\Users\\slava\\OneDrive\\Рабочий стол\\Жаба\\SavedField.save", i = true)
    private String stroka = "Это текст, который надо сохранить.";


}
