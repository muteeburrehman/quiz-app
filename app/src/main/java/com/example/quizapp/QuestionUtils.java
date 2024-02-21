package com.example.quizapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionUtils {

    public static List<Question> getElectrophysicsQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is the unit of electrical resistance?",
                new ArrayList<>(Arrays.asList("Ohm", "Watt", "Volt", "Ampere")), 0));

        questions.add(new Question("What does LED stand for?",
                new ArrayList<>(Arrays.asList("Light Emitting Diode", "Light Emitting Device", "Low Energy Diode", "Low Energy Device")), 0));

        questions.add(new Question("Which law is also known as the law of induction?",
                new ArrayList<>(Arrays.asList("Faraday's law", "Ohm's law", "Coulomb's law", "Kirchhoff's law")), 0));

        questions.add(new Question("What is the symbol for capacitance?",
                new ArrayList<>(Arrays.asList("C", "Q", "R", "L")), 0));

        questions.add(new Question("Who is known as the father of electricity?",
                new ArrayList<>(Arrays.asList("Michael Faraday", "Thomas Edison", "Nikola Tesla", "James Clerk Maxwell")), 0));

        questions.add(new Question("What device is used to measure electric current?",
                new ArrayList<>(Arrays.asList("Ammeter", "Voltmeter", "Galvanometer", "Ohmmeter")), 0));

        questions.add(new Question("Which material does not allow electricity to flow through it?",
                new ArrayList<>(Arrays.asList("Insulator", "Conductor", "Semiconductor", "Superconductor")), 0));

        questions.add(new Question("What is the basic principle of electromagnetism?",
                new ArrayList<>(Arrays.asList("Electric current produces a magnetic field", "Magnetic fields produce electric current", "Electricity can only flow through a vacuum", "Magnetic fields can only exist in a vacuum")), 0));

        questions.add(new Question("What is the SI unit of magnetic flux density?",
                new ArrayList<>(Arrays.asList("Tesla", "Weber", "Henry", "Gauss")), 0));

        questions.add(new Question("Which of the following is a passive electronic component?",
                new ArrayList<>(Arrays.asList("Resistor", "Transistor", "Diode", "Operational Amplifier")), 0));

        return questions;
    }
}

