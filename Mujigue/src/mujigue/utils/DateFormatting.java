/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mujigue.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author herma
 */
public class DateFormatting {

    public java.sql.Date fromString(String stringDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = format.parse(stringDate);
        return new java.sql.Date(date.getTime());
    }

    public String fromFormat(String before) throws ParseException{
        DateFormat targetFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = originalFormat.parse(before);
        String formattedDate = targetFormat.format(date);  // 20120821
        return formattedDate;
    }
}
