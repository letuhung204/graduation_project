package com.example.demo.validation;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.TaskProgress;

public final class Util {
    @SuppressWarnings("deprecation")
	public static List<Date> getListDate(Date startDate, Date finishDate, Date lastDateFromLog) {
        List<Date> listDate = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        if (lastDateFromLog.after(finishDate)) {
            finishDate = lastDateFromLog;
        }
        finishDate.setHours(0);
        finishDate.setMinutes(0);
        finishDate.setSeconds(0);
        startDate.setMinutes(0);
        startDate.setHours(0);
        startDate.setSeconds(0);
        Date date = startDate;
        while (!date.after(finishDate)) {
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            listDate.add(date);
            date = c.getTime();
        }
        return listDate;
    }

    @SuppressWarnings("deprecation")
	public static List<Double> getListExpectProgress(Date startDate, Date finishDate) {
        List<Double> listProgress = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        long duration = finishDate.getTime() - startDate.getTime();
        double progress = 0;
        finishDate.setHours(0);
        finishDate.setMinutes(0);
        finishDate.setSeconds(0);
        startDate.setMinutes(0);
        startDate.setHours(0);
        startDate.setSeconds(0);
        Date date = startDate;
        while (!date.after(finishDate)) {
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            progress = Math.ceil((double) (100 * (date.getTime() - startDate.getTime()) / duration));
            listProgress.add(progress);
            date = c.getTime();
        }
        return listProgress;
    }

    @SuppressWarnings("deprecation")
	public static List<Double> getListActualProgress(Date startDate, List<TaskProgress> workLogList) {
        List<Double> listProgress = new ArrayList<>();
        startDate.setHours(0);
        startDate.setMinutes(0);
        startDate.setSeconds(0);
        Calendar c = Calendar.getInstance();
        Date date;
        Date referDate = startDate;
        TaskProgress workLog;
        int length = workLogList.size();
        for (int i = 0; i < length; i++) {
            workLog = workLogList.get(i);
            date = workLog.getDateLog();
            while (referDate.before(date)) {
                c.setTime(referDate);
                c.add(Calendar.DATE, 1);
                referDate = c.getTime();
                listProgress.add(null);
            }
            if (date.getTime() != referDate.getTime()) {
                listProgress.add(Double.valueOf(workLog.getProgress()));
                c.setTime(referDate);
                c.add(Calendar.DATE, 1);
                referDate = c.getTime();
            }
        }
        return listProgress;
    }

    @SuppressWarnings("deprecation")
	public static List<String> getLabelFromListDate(List<Date> listDate) {
        List<String> listLabel = new ArrayList<>();
        StringBuilder label = new StringBuilder();
        label.append("[");
        for (Date date : listDate) {
            label.setLength(0);
            label.append("\"");
            label.append(date.getDate());
            label.append("-");
            label.append(date.getMonth() + 1);
            label.append("-");
            label.append(date.getYear() + 1900);
            label.append("\"");
            listLabel.add(label.toString());
        }
        return listLabel;
    }
    
}
