package com.example.peluangkerja;

import java.util.ArrayList;

public class JobDatas {
    private static String[] job = {
            "Socialmedia Specialist",
            "SPV Produksi",
            "Photograper",
            "Customer Service",
            "Videographer (Freelance)",
            "Resto Ayam Sarjana",
            "Socialmedia Specialist",
            "Socialmedia Specialist",
            "Socialmedia Specialist",
            "Socialmedia Specialist"
    };

    private static String[] company = {
            "PT. Makarona Indonesia",
            "Resto Ayam Sarjana",
            "Millionperspective Corporate",
            "Millionperspective Corporate",
            "PT. Millionperspective",
            "PT. Makarona Indonesia",
            "PT. Makarona Indonesia",
            "PT. Makarona Indonesia",
            "Resto Ayam Sarjana",
            "PT. Makarona Indonesia",
    };

    private static String[] salary = {
            "Gaji Rp. 3.000.000 - 5.000.000",
            "Gaji Rp. 4.000.000 - 6.000.000",
            "Gaji Rp. 4.000.000 - 6.000.000",
            "Gaji Rp. 4.000.000 - 6.000.000",
            "Gaji Rp. 4.000.000 - 6.000.000",
            "Gaji Rp. 4.000.000 - 6.000.000",
            "Gaji Rp. 4.000.000 - 6.000.000",
            "Gaji Rp. 3.000.000 - 5.000.000",
            "Gaji Rp. 3.000.000 - 5.000.000",
            "Gaji Rp. 3.000.000 - 5.000.000"
    };

    private static String[] city = {
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor",
            "Kab. Bogor"
    };

    private static String[] time = {
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
            "4 Hari yang lalu",
    };

    private static int[] jobImage = {
            R.drawable.imgjob,
            R.drawable.img_logoayamsarjana,
            R.drawable.img_million,
            R.drawable.img_million,
            R.drawable.img_logoayamsarjana,
            R.drawable.img_million,
            R.drawable.imgjob,
            R.drawable.img_logoayamsarjana,
            R.drawable.img_million,
            R.drawable.imgjob,
    };

    public static ArrayList<Jobs> getJobList() {
        Jobs jobs;
        ArrayList<Jobs> list = new ArrayList<>();

        for (int i = 0; i < job.length; i++) {
            jobs = new Jobs();
            jobs.setJob(job[i]);
            jobs.setCompany(company[i]);
            jobs.setSalary(salary[i]);
            jobs.setCity(city[i]);
            jobs.setTime(time[i]);
            jobs.setJobImage(jobImage[i]);

            list.add(jobs);
        }
        return list;
    }


}
