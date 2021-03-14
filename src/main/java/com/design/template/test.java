package com.design.template;

public class test {
    public static void main(String args[]) {
        VehicleTemplate template = new VehicleTemplate();
        template.call(new DriveCallBack() {
            public void drive() {
                System.out.println("this is bycicle");
            }
        });
        template.open();
    }

}
