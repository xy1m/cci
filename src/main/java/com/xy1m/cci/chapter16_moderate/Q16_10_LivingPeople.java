package com.xy1m.cci.chapter16_moderate;

import java.util.Arrays;

public class Q16_10_LivingPeople {

    // Time=O(RP) where R is the year range from min to max, P is the number of people
    int maxAliveYearByBruteForce(Person[] people, int min, int max) {
        int maxYear = 0;
        int maxAlive = 0;
        for (int year = min; year <= max; year++) {
            int alive = 0;
            for (Person person : people) {
                if (person.birth <= year && year <= person.death) {
                    alive++;
                }
            }
            if (alive > maxAlive) {
                maxYear = year;
                maxAlive = alive;
            }
        }
        return maxYear;
    }

    // Time=O(PY+R) where P is the number of people, Y is the years people alive, R is the year range
    int maxAliveYearByBetterBruteForce(Person[] people, int min, int max) {
        int[] years = new int[max - min + 1];
        for (Person person : people) {
            incrementRange(years, person.birth - min, person.death - min);
        }
        int maxAliveYear = 0;
        for (int i = 0; i < years.length; i++) {
            if (years[i] > maxAliveYear) {
                maxAliveYear = i;
            }
        }
        return min + maxAliveYear;
    }

    void incrementRange(int[] years, int birth, int death) {
        for (int i = birth; i <= death; i++) {
            years[i]++;
        }
    }

    // Time=O(P*logP), P is the number of people
    int maxAliveYearBySort(Person[] people, int min, int max) {
        int[] birthYears = getSortedYears(people, true);
        int[] deathYears = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = 0;
        while (birthIndex < birthYears.length) {
            if (birthYears[birthIndex] <= deathYears[deathIndex]) {
                currentAlive++;
                if (currentAlive > maxAlive) {
                    maxAlive = currentAlive;
                    maxAliveYear = birthYears[birthIndex];
                }
                birthIndex++;
            }
            else if (birthYears[birthIndex] > deathYears[deathIndex]) {
                currentAlive--;
                deathIndex++;
            }
        }
        return maxAliveYear;
    }

    // Time=O(P)
    int maxAliveYearByBetterSort(Person[] people, int min, int max) {
        int[] birthYears = getSortedYears(people, true);
        int[] deathYears = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = 0;
        while (birthIndex < birthYears.length) {
            if (birthYears[birthIndex] <= deathYears[deathIndex]) {
                currentAlive++;
                if (currentAlive > maxAlive) {
                    maxAlive = currentAlive;
                    maxAliveYear = birthYears[birthIndex];
                }
                birthIndex++;
            }
            else if (birthYears[birthIndex] > deathYears[deathIndex]) {
                currentAlive--;
                deathIndex++;
            }
        }
        return maxAliveYear;
    }

    int[] getSortedYears(Person[] people, boolean copyBirthYear) {
        int[] years = new int[people.length];
        for (int i = 0; i < years.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }
        Arrays.sort(years);
        return years;
    }


    static class Person {
        public int birth;
        public int death;

        public Person(int birth, int death) {
            this.birth = birth;
            this.death = death;
        }
    }

    public static void main(String[] args) {
        Q16_10_LivingPeople main = new Q16_10_LivingPeople();

        Person[] people = new Person[]{
                new Person(1900, 2000),
                new Person(1991, 1938),
                new Person(1926, 1937),
                new Person(1960, 1988)
        };
        int minYear = 1900, maxYear = 2000;

        int maxAliveYear = main.maxAliveYearByBruteForce(people, minYear, maxYear);
        System.out.println(maxAliveYear);

        int maxAliveYear1 = main.maxAliveYearByBetterBruteForce(people, minYear, maxYear);
        System.out.println(maxAliveYear1);

        int maxAliveYear2 = main.maxAliveYearBySort(people, minYear, maxYear);
        System.out.println(maxAliveYear2);


    }
}
