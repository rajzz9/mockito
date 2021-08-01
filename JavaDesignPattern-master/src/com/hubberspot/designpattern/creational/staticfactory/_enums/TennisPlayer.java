package com.hubberspot.designpattern.creational.staticfactory._enums;

public class TennisPlayer implements Player {
    @Override
    public void play() {
        System.out.println("Tennis player playing ...");
    }
}